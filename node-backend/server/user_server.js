const express = require('express');
const sql = require('../util/sql.js');
const pool = sql.createPool();
//创建数据库连接池

const server = express();
const {
	send,
	postQuery
} = require('../util/http.js');
server.listen(526);

server.post('*', postQuery);
//post请求数据解析-中间件

server.post('/userAll', async function(req, res) {
	let sqlString = sql.select(["user_id", "user_status", "user_name", "user_tel", "user_time"], 'user');
	try {
		var selectRepeat = await sql.sever(pool, sqlString);
	} catch (err) {
		send({
			"msg": err,
			"style": -2
		});
	}
	send(res, {
		"msg": "查询成功",
		"data": selectRepeat,
		"style": 1
	})
})
//查询所有用户

server.post('/userEdit', async function(req, res) {
	let obj = req.obj.data;
	let sqlStringSelect = sql.select(['user_id'], 'user', 'user_id=' + sql.escape(obj.id));
	try {
		var selectAns = await sql.sever(pool, sqlStringSelect);
	} catch (err) {
		send(res, {
			"msg": err,
			"style": -2
		});
		return;
	}
	if (selectAns.length != 1) {
		send(res, {
			"msg": "没有查询到要修改的id",
			"style": 0
		});
		return;
	}

	if (obj.passwordchange == 0) {
		let sqlString = sql.update('user', ['user_status', 'user_tel'],
			[sql.escape(obj.status), obj.tel == "" ? null : sql.escape(obj.tel)],
			'user_id=' + sql.escape(obj.id));
		try {
			var selectAns = await sql.sever(pool, sqlString);
		} catch (err) {
			send(res, {
				"msg": err,
				"style": -2
			});
			return;
		}
	} else {

		let sqlString = sql.update('user', ['user_password', 'user_status', 'user_tel'],
			[sql.escape(obj.password), sql.escape(obj.status), obj.tel == "" ? null : sql.escape(obj.tel)],
			'user_id=' + sql.escape(obj.id));
		try {
			var selectAns = await sql.sever(pool, sqlString);
		} catch (err) {
			send(res, {
				"msg": err,
				"style": -2
			});
			return;
		}
	}
	send(res, {
		"msg": "编辑成功！",
		"style": 1
	});
})
//修改用户信息



server.post('/userMain', async function(req, res) {
	let obj = req.obj;
	let sqlString = sql.select(["user_id", "user_sex", "user_name", "user_tel", "user_hobby", "user_signal"], 'user',
		`user_id=${obj.userInfo.user_id}`);
	try {
		var selectRepeat = await sql.sever(pool, sqlString);
	} catch (err) {
		send({
			"msg": err,
			"style": -2
		});
	}
	if (selectRepeat[0]) {
		send(res, {
			"msg": "查询成功",
			"data": selectRepeat[0],
			"style": 1
		})
	} else {
		send(res, {
			"msg": "查询无此人信息",
			"style": 0
		})
	}
})
//查询当前登录用户信息



server.post('/userChange', async function(req, res) {
	let obj = req.obj.data;
	let info = req.obj.userInfo;
	let sqlStringSelect = sql.select(['user_id'], 'user', 'user_id=' + info.user_id);
	try {
		var selectAns = await sql.sever(pool, sqlStringSelect);
	} catch (err) {
		send(res, {
			"msg": err,
			"style": -2
		});
		return;
	}
	if (selectAns.length != 1) {
		send(res, {
			"msg": "没有查询到要修改的账户",
			"style": 0
		});
		return;
	}

	let sqlString = sql.update('user', ['user_sex', 'user_signal', 'user_tel','user_hobby'],
		[sql.escape(obj.sex), sql.escape(obj.signal), 
		obj.tel == "" ? null : sql.escape(obj.tel),sql.escape(obj.hobby)],
		'user_id=' + info.user_id);
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
		"msg": "编辑成功！",
		"style": 1
	});
})
//修改个人信息
