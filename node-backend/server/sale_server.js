const express = require('express');
const request = require('request');
const sql = require('../util/sql.js');
const pool = sql.createPool();
//创建数据库连接池

const server = express();
const {
	send,
	postQuery
} = require('../util/http.js');


server.listen(546);

server.post('*', postQuery);
//post请求数据解析-中间件


server.post('/playNear', async function(req, res) {
	let sqlString =
		`SELECT distinct play.play_id, play.play_name, play.play_director, play.play_performer,
	 play.play_type, play.play_length,play.play_country, play.play_language, play.play_status, play.play_pic,
	  play.play_link, play.play_path FROM play,plan WHERE Date(plan.plan_startime) between Date(NOW()) 
	  and Date(date_add(NOW(), interval 5 day)) and plan.play_id=play.play_id `;
	try {
		var selectAns = await sql.sever(pool, sqlString);
	} catch (err) {
		send(res, {
			"msg": err,
			"style": -2
		});
		return;
	}
	send(res, {
		"msg": "查询成功！",
		"data": selectAns,
		"style": 1
	});
})
//查询近5日的电影信息



server.post('/planList', async function(req, res) {
	let obj = req.obj.data;

	let sqlString = sql.select(['play_id'], 'play', 'play_id=' + sql.escape(obj.id));
	try {
		var selectAns = await sql.sever(pool, sqlString);
	} catch (err) {
		send(res, {
			"msg": err,
			"style": -2
		});
		return;
	}
	if (selectAns.length != 1) {
		send(res, {
			"msg": "没有查询到此电影！",
			"style": 0
		});
		return;
	}

	sqlString = sql.select(['plan.plan_id', 'plan.room_id', 'room.room_name', 'DAYOFWEEK(plan.plan_startime) AS data',
			'plan.plan_startime', 'plan.plan_money', 'plan.plan_language'
		], 'plan,room',
		'plan.room_id=room.room_id and plan.play_id=' + sql.escape(obj.id) +
		' and Date(plan.plan_startime) between Date(NOW()) and Date(date_add(NOW(), interval 5 day))');
	try {
		var selectAns = await sql.sever(pool, sqlString + ' ORDER BY plan.plan_startime');
		var back = [];
		for (let i = 0; i < selectAns.length; i++) {
			sqlString = sql.select(['count(*)'], 'plan,ticket',
				'plan.plan_id=ticket.plan_id and (ticket.ticket_status=0 or (ticket.ticket_status=2 and ticket.ticket_time < date_sub(NOW(),interval 10 minute))) and plan.plan_id=' +
				sql.escape(selectAns[i].plan_id));
			let seatAns = await sql.sever(pool, sqlString);
			back.push(Object.assign({}, selectAns[i], {
				seat_num: seatAns[0]["count(*)"]
			}))
		}
	} catch (err) {
		send(res, {
			"msg": err,
			"style": -2
		});
		return;
	}
	send(res, {
		"msg": "查询成功！",
		"data": back,
		"style": 1
	});

})
//查询某一个电影近5天的演出计划


server.post('/ticketList', async function(req, res) {
	let obj = req.obj.data;
	let sqlString = sql.select(['plan_id'], 'plan', 'plan_id=' + sql.escape(obj.id));
	try {
		var selectAns = await sql.sever(pool, sqlString);
	} catch (err) {
		send(res, {
			"msg": err,
			"style": -2
		});
		return;
	}
	if (selectAns.length != 1) {
		send(res, {
			"msg": "没有查询到电影的演出计划！",
			"style": 0
		});
		return;
	}
	sqlString = sql.select(['play.play_id', 'play.play_name', 'play.play_director', 'play.play_performer',
			'play.play_type', 'play.play_length', 'play.play_country', 'play.play_pic', 'plan.plan_language',
			'plan.plan_startime', 'plan.plan_money', 'room.room_id', 'room.room_row', 'room_col'
		], 'room,play,plan',
		'plan.play_id=play.play_id and plan.room_id=room.room_id and plan_id=' + sql.escape(obj.id));
	try {
		var selectAnsData = await sql.sever(pool, sqlString);
	} catch (err) {
		send(res, {
			"msg": err,
			"style": -2
		});
		return;
	}
	//查询剧目信息


	sqlString = sql.select(['ticket.ticket_id', 'seat.seat_id', 'seat.seat_row', 'seat.seat_col'], 'ticket,seat',
		'plan_id=' + sql.escape(obj.id));
	//查询所有票
	try {
		var selectAnsAll = await sql.sever(pool, sqlString);
	} catch (err) {
		send(res, {
			"msg": err,
			"style": -2
		});
		return;
	}


	sqlString = sql.select(['ticket.ticket_id', 'seat.seat_id', 'seat.seat_row', 'seat.seat_col'],
		'ticket,seat', 'ticket.seat_id=seat.seat_id and ticket.plan_id=' + sql.escape(obj.id) +
		' and (ticket.ticket_status=1 or (ticket.ticket_status=2 and ticket.ticket_time > date_sub(NOW(),interval 10 minute) or ticket.ticket_status=3))'
	);
	//查询已卖出的票
	try {
		var selectAnsSale = await sql.sever(pool, sqlString);
	} catch (err) {
		send(res, {
			"msg": err,
			"style": -2
		});
		return;
	}

	send(res, {
		"msg": "查询成功！",
		"data": selectAnsData,
		"dataAll": selectAnsAll,
		"dataSale": selectAnsSale,
		"style": 1
	});

})
//查询某一个演出计划的演出票


server.post('/order', async function(req, res) {
	let obj = req.obj.data;
	let info = req.obj.userInfo;
	let ticketArr = [];
	for (let index = 0; index < obj.ticket.length; index++) {
		let child = obj.ticket[index];
		let int = Number.parseInt(child);
		if (isNaN(int)) {
			send(res, {
				"msg": "数组第" + index + "元素不是Int类型",
				"style": 0
			})
			return;
		}
		ticketArr.push(child);
	}
	ticketStr = 'ticket_id=' + ticketArr.join(' or ticket_id=');
	//参数为整数校验

	let sqlStringSelect = sql.select(['count(*)'], 'ticket,plan',
		'ticket.plan_id=plan.plan_id and plan.plan_startime > NOW() and (ticket_status=0 or (ticket_status=2 and ticket_time < date_sub(NOW(),interval 10 minute))) and (' +
		ticketStr + ')');
	try {
		var selectAns = await sql.sever(pool, sqlStringSelect);
	} catch (err) {
		send(res, {
			"msg": err,
			"style": -2
		});
		return;
	}
	if (selectAns[0]['count(*)'] != ticketArr.length) {
		send(res, {
			"msg": "演出票校验错误！",
			"style": 0
		});
		return;
	}
	//校验问题：
	//1.同一张票多次购买
	//2.购买已经售出的票
	//3.购买当前时间之前的票

	let connect = await sql.handler(pool);
	try {
		for (let i = 0; i < ticketArr.length; i++) {
			let sqlString = sql.update('ticket', ['ticket_status', 'ticket_time'], ['2', 'NOW()'], 'ticket_id=' + sql.escape(
				ticketArr[i]));
			await sql.stepsql(connect, sqlString);
		}


		let sqlStringSelect = sql.select(['plan_money'], 'ticket,plan', 'ticket.plan_id=plan.plan_id and ticket_id=' +
			sql
			.escape(ticketArr[0]));
		let money = await sql.stepsql(connect, sqlStringSelect);

		let sqlString = sql.insert('orderticket', ['user_id', 'orderticket_money', 'orderticket_history',
				'orderticket_time', 'orderticket_status'
			],
			[info.user_id, Number.parseFloat(money[0].plan_money) * ticketArr.length, sql.escape(JSON.stringify(
				ticketArr)), 'NOW()', '0']);
		var orderId = await sql.stepsql(connect, sqlString);

		await connect.commit()
	} catch (err) {
		await connect.rollback()
		send(res, {
			"msg": err,
			"style": -2
		});
		return;
	} finally {
		connect.release()
	}

	send(res, {
		"msg": "订票成功！",
		"id": orderId.insertId,
		"style": 1
	});
})
//订票


server.post('/selectOrder', async function(req, res) {
	let obj = req.obj.data;

	let arr = []; //购票数组
	let sqlString = sql.select(['orderticket_money', 'orderticket_history', 'orderticket_time',
			'orderticket_status'
		],
		'orderticket', 'orderticket_id=' + sql.escape(obj.id));
	try {
		selectBase = await sql.sever(pool, 'SELECT distinct ' + sqlString.split('SELECT')[1]);
	} catch (err) {
		send(res, {
			"msg": err,
			"style": -2
		});
		return;
	}
	let num = JSON.parse(selectBase[0].orderticket_history);
	//查询订单基础信息


	sqlString = sql.select(['room.room_name', 'play.play_name', 'play.play_pic', 'plan.plan_startime',
			'plan.plan_language', 'plan.plan_money'
		], 'play,plan,room,ticket,seat',
		'ticket.plan_id=plan.plan_id and ticket.seat_id=seat.seat_id and plan.play_id=play.play_id and plan.room_id=room.room_id and ticket.ticket_id=' +
		sql.escape(num[0]));
	try {
		selectPlay = await sql.sever(pool, 'SELECT distinct ' + sqlString.split('SELECT')[1]);
	} catch (err) {
		send(res, {
			"msg": err,
			"style": -2
		});
		return;
	}
	//查询剧目信息


	ticketStr = 'ticket_id=' + num.join(' or ticket_id=');
	sqlString = sql.select(['seat.seat_row', 'seat.seat_col', 'ticket.ticket_status', 'ticket.ticket_id'],
		'seat,ticket', 'ticket.seat_id=seat.seat_id  and (' + ticketStr + ')');
	try {
		selectTicket = await sql.sever(pool, sqlString);
	} catch (err) {
		send(res, {
			"msg": err,
			"style": -2
		});
		return;
	}
	//查询影票信息


	send(res, {
		"msg": "查询成功！",
		"order": selectBase,
		"play": selectPlay,
		"ticket": selectTicket,
		"style": 1
	});

})
//查询订单详情


server.post('/selectAllOrder', async function(req, res) {
	let info = req.obj.userInfo;
	let arr = []; //保存所有信息
	let sqlString = sql.select(['orderticket_id', 'orderticket_money', 'orderticket_history', 'orderticket_time',
		'orderticket_status'
	], 'orderticket', 'user_id=' + info.user_id);
	try {
		selectBase = await sql.sever(pool, 'SELECT distinct ' + sqlString.split('SELECT')[1] +
			" ORDER BY orderticket_id DESC");
	} catch (err) {
		send(res, {
			"msg": err,
			"style": -2
		});
		return;
	}
	//查询所有订单
	arr = selectBase;

	for (let i = 0; i < selectBase.length; i++) {
		let num = JSON.parse(selectBase[i].orderticket_history);
		//查询订单基础信息
		sqlString = sql.select(['room.room_name', 'play.play_name', 'play.play_pic', 'plan.plan_startime',
				'plan.plan_language', 'plan.plan_money'
			], 'play,plan,room,ticket,seat',
			'ticket.plan_id=plan.plan_id and ticket.seat_id=seat.seat_id and plan.play_id=play.play_id and plan.room_id=room.room_id and ticket.ticket_id=' +
			sql.escape(num[0]));
		try {
			selectPlay = await sql.sever(pool, 'SELECT distinct ' + sqlString.split('SELECT')[1]);
		} catch (err) {
			send(res, {
				"msg": err,
				"style": -2
			});
			return;
		}
		//查询剧目信息
		arr[i].play = selectPlay[0];

		ticketStr = 'ticket_id=' + num.join(' or ticket_id=');
		sqlString = sql.select(['seat.seat_row', 'seat.seat_col', 'ticket.ticket_status', 'ticket.ticket_id'],
			'seat,ticket', 'ticket.seat_id=seat.seat_id  and (' + ticketStr + ')');
		try {
			selectTicket = await sql.sever(pool, sqlString);
		} catch (err) {
			send(res, {
				"msg": err,
				"style": -2
			});
			return;
		}
		//查询影票信息
		arr[i].ticket = selectTicket;
	}
	send(res, {
		"msg": "查询成功！",
		"data": arr,
		"style": 1
	});

})
//查询我的所有订单


server.post('/saleOrder', async function(req, res) {
	let obj = req.obj.data;
	let info = req.obj.userInfo;
	let sqlString = sql.select(['orderticket_id'], 'orderticket',
		'orderticket_status=0 and NOW()<date_add(orderticket_time, interval 10 minute) and orderticket_id=' + sql.escape(
			obj.id));
	try {
		var selectAns = await sql.sever(pool, sqlString);
	} catch (err) {
		send(res, {
			"msg": err,
			"style": -2
		});
		return;
	}
	if (selectAns.length != 1) {
		send(res, {
			"msg": "不满足付款规则",
			"style": 0
		});
		return;
	}
	//支付驳回

	let connect = await sql.handler(pool);
	try {
		let sqlString = sql.update('orderticket', ['orderticket_status'], ['1'], 'orderticket_id=' + sql.escape(obj.id));
		await sql.stepsql(connect, sqlString);
		//更新订单信息

		sqlString = sql.select(['orderticket_history'], 'orderticket', 'orderticket_id=' + sql.escape(obj.id));
		let selectAns = await sql.stepsql(connect, sqlString);
		//查询订单

		let arr = JSON.parse(selectAns[0].orderticket_history); //ticketId集合

		sqlString = sql.select(['plan.plan_money'], 'ticket,plan', 'ticket.plan_id=plan.plan_id and ticket_id=' + sql
			.escape(
				arr[0]));
		selectAns = await sql.stepsql(connect, sqlString);
		//查询票价
		let money = selectAns[0].plan_money;



		for (let i = 0; i < arr.length; i++) {
			let sqlString = sql.update('ticket', ['ticket_status'], ['3'], 'ticket_id=' + sql.escape(arr[i]));
			await sql.stepsql(connect, sqlString);

			sqlString = sql.insert('sale', ['user_id', 'ticket_id', 'sale_money', 'sale_status', 'sale_time'],
				[info.user_id, sql.escape(arr[i]), sql.escape(money), '1', 'NOW()']);
			await sql.stepsql(connect, sqlString);
		}
		//生成销售单

		await connect.commit()
	} catch (err) {
		await connect.rollback()
		send(res, {
			"msg": err,
			"style": -2
		});
		return;
	} finally {
		connect.release()
	}

	send(res, {
		"msg": "购票成功！",
		"style": 1
	});
})
//支付订单




server.post('/cancelOrder', async function(req, res) {
	let obj = req.obj.data;

	let sqlString = sql.select(['orderticket_id'], 'orderticket',
		'orderticket_status=0 and orderticket_id=' + sql.escape(obj.id));
	try {
		var selectAns = await sql.sever(pool, sqlString);
	} catch (err) {
		send(res, {
			"msg": err,
			"style": -2
		});
		return;
	}
	if (selectAns.length != 1) {
		send(res, {
			"msg": "不满足取消规则",
			"style": 0
		});
		return;
	}
	//取消驳回


	let connect = await sql.handler(pool);
	try {
		let sqlString = sql.update('orderticket', ['orderticket_status'], ['-1'], 'orderticket_id=' + sql.escape(obj.id));
		await sql.stepsql(connect, sqlString);
		//更新订单信息

		sqlString = sql.select(['orderticket_history'], 'orderticket', 'orderticket_id=' + sql.escape(obj.id));
		let selectAns = await sql.stepsql(connect, sqlString);
		//查询订单

		let arr = JSON.parse(selectAns[0].orderticket_history); //ticketId集合


		for (let i = 0; i < arr.length; i++) {
			let sqlString = sql.update('ticket', ['ticket_status'], ['0'], 'ticket_status=2 and ticket_id=' + sql.escape(
				arr[
					i]));
			await sql.stepsql(connect, sqlString);
		}
		//恢复票状态

		await connect.commit()
	} catch (err) {
		await connect.rollback()
		send(res, {
			"msg": err,
			"style": -2
		});
		return;
	} finally {
		connect.release()
	}

	send(res, {
		"msg": "订单取消成功！",
		"style": 1
	});
})
//订单取消






server.post('/ticketMessage', async function(req, res) {
	let obj = req.obj.data;

	let sqlString = sql.select(['ticket_id'], 'ticket', 'ticket_id=' + sql.escape(obj.id));
	try {
		var selectAns = await sql.sever(pool, sqlString);
	} catch (err) {
		send(res, {
			"msg": err,
			"style": -2
		});
		return;
	}
	if (selectAns.length != 1) {
		send(res, {
			"msg": "没有查询到该id对应的电影！",
			"style": 0
		});
		return;
	}

	sqlString = sql.select(['room.room_name', 'seat.seat_row', 'seat.seat_col', 'play.play_name', 'play.play_pic',
			'plan.plan_startime', 'plan.plan_language', 'plan.plan_money'
		],
		'play,plan,room,seat,ticket',
		'ticket.plan_id=plan.plan_id and ticket.seat_id=seat.seat_id and plan.play_id=play.play_id and seat.room_id=room.room_id and ticket.ticket_id=' +
		sql.escape(obj.id));
	try {
		selectAns = await sql.sever(pool, 'SELECT distinct ' + sqlString.split('SELECT')[1]);
	} catch (err) {
		send(res, {
			"msg": err,
			"style": -2
		});
		return;
	}
	send(res, {
		"msg": "查询成功！",
		"data": selectAns,
		"style": 1
	});

})
//根据ticket_id查询票的详细信息




server.post('/cancelSale', async function(req, res) {
	let obj = req.obj.data;
	let info = req.obj.userInfo;
	let sqlString = sql.select(['ticket_id'], 'ticket,plan',
		'(ticket.ticket_status=1 or ticket.ticket_status=3) and NOW()<plan.plan_startime and ticket.plan_id=plan.plan_id and ticket.ticket_id=' +
		sql.escape(obj.id));
	try {
		var selectAns = await sql.sever(pool, sqlString);
	} catch (err) {
		send(res, {
			"msg": err,
			"style": -2
		});
		return;
	}
	if (selectAns.length != 1) {
		send(res, {
			"msg": "不满足退票规则",
			"style": 0
		});
		return;
	}
	//支付驳回

	let connect = await sql.handler(pool);
	try {
		let sqlString = sql.update('ticket', ['ticket_status'], ['0'], 'ticket_id=' + sql.escape(obj.id));
		await sql.stepsql(connect, sqlString);
		//更新票状态--->未卖出

		sqlString = sql.select(['plan.plan_money'], 'ticket,plan', 'ticket.plan_id=plan.plan_id and ticket_id=' +
			sql.escape(obj.id));
		selectAns = await sql.stepsql(connect, sqlString);
		//查询票价
		let money = selectAns[0].plan_money;

		sqlString = sql.insert('sale', ['user_id', 'ticket_id', 'sale_money', 'sale_status', 'sale_time'],
			[info.user_id, sql.escape(obj.id), sql.escape(money), '0', 'NOW()']);
		await sql.stepsql(connect, sqlString);
		//生成退票销售单

		await connect.commit()
	} catch (err) {
		await connect.rollback()
		send(res, {
			"msg": err,
			"style": -2
		});
		return;
	} finally {
		connect.release()
	}

	send(res, {
		"msg": "退票成功！",
		"style": 1
	});
})
//退票
