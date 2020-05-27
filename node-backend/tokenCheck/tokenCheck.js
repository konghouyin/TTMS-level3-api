const sql = require('../util/sql.js');
const pool = sql.createPool();
const routerPath = require('./routerPath.js').router;

//创建数据库连接池
const TOKEN = require('../util/tokenModule.js');
var request = require("request"); //微信小程序安全登录

const {
	send,
	app,
	getRouter,
	judge
} = require('../util/http.js'); //解析网络请求
app.listen(517);

let serverAccount = getRouter();
let serverApi = getRouter();

app.use('/TTMS-v3/account', serverAccount);
app.use('/TTMS-v3/api', serverApi);

serverAccount.post('/reg', async function(req, res) {
	let obj = req.obj;

	let sqlString = sql.select(['user_name'], 'user', `user_name=${sql.escape(obj.name)}`);
	try {
		var selectRepeat = await sql.sever(pool, sqlString);
	} catch (err) {
		send({
			"msg": err,
			"style": -2
		});
	}
	if (selectRepeat.length == 0) {
		let sqlString = sql.insert('user', ['user_status', 'user_name', 'user_password', 'user_time'],
			['', sql.escape(obj.name), sql.escape(obj.password), 'NOW()']);
		try {
			await sql.sever(pool, sqlString);
		} catch (err) {
			send({
				"msg": err,
				"style": -2
			});
			return;
		}
		send(res, {
			"msg": "注册成功",
			"style": 1
		})
	} else {
		send(res, {
			"msg": "注册失败--用户名重复",
			"style": 0
		})
	}
});
//用户注册


serverAccount.post('/login', async function(req, res) {
	let obj = req.obj;

	let sqlString = sql.select(['user_id', 'user_name', 'user_status'], 'user',
		`user_name=${sql.escape(obj.name)} AND user_password=${sql.escape(obj.password)}`);
	try {
		var selectAns = await sql.sever(pool, sqlString);
	} catch (err) {
		send({
			"msg": err,
			"style": -2
		});
		return;
	}
	if (selectAns.length != 1) {
		send(res, {
			"msg": "用户名或密码错误！",
			"style": 0
		})
	} else {
		console.log(selectAns)
		send(res, {
			"msg": "登录成功！",
			"data": selectAns[0],
			"token": TOKEN.createToken(selectAns[0]),
			"style": 1
		})
	}
});
//系统登录


serverApi.get('*', async function(req, res) {
	let userInfo = {};
	if (req.obj.token && (userInfo = TOKEN.verifyTokenMiddle(req.obj.token)) && userInfo.style) {

		let url = req._parsedUrl.pathname;
		let checkInfo = routerPath[url];
		//获取转发信息,查看路由权限
		if (checkInfo === undefined) {
			send(res, {
				"msg": "路由权限未开放",
				"style": -4
			})
			return
		}

		let user_status = userInfo.info.user_status.split(',');
		let isPass = checkInfo.status.reduce((last, item) => {
			return last || user_status.indexOf(item)
		}, false)
		if (!isPass) {
			send(res, {
				"msg": "权限不足",
				"style": -4
			})
			return
		}
		//计算权限是否可以转发

		let sendMessage = Object.assign({}, req.obj);
		delete sendMessage.token;

		let options = {
			method: "POST",
			url: `http://localhost:${checkInfo.point}${req._parsedUrl.pathname}`,
			body: JSON.stringify({
				data: req.obj,
				userInfo: userInfo.info
			})
		};
		console.log(options)
		request(options, function(error, response, body) {
			if (error) {
				console.log(error);
				send(res, {
					message: "rpc_Fail",
					style: -5
				})
			} else {
				let back = JSON.parse(body)
				if (back.style === 1) {
					send(res, back)
				} else {
					console.log(body)
					send(res, {
						message: "rpc_Fail",
						style: -5
					})
				}
			}
		});
	} else {
		send(res, {
			"msg": "token-error",
			"style": -3
		})
	}

});
//api-token校验





// function loginCheck(code) {
// 	return new Promise(function(resolve, reject) {
// 		try {
// 			let options = {
// 				method: 'GET',
// 				url: 'https://api.weixin.qq.com/sns/jscode2session',
// 				qs: {
// 					appid: 'wx9ccfffa2a67aac4c',
// 					secret: 'd5c6c6508f7d81c8c216e6f61f10192b',
// 					js_code: code,
// 					grant_type: 'authorization_code'
// 				},
// 				headers: {
// 					'cache-control': 'no-cache',
// 					Connection: 'keep-alive',
// 					'accept-encoding': 'gzip, deflate',
// 					Host: 'api.weixin.qq.com',
// 					'Cache-Control': 'no-cache',
// 					Accept: '*/*',
// 				}
// 			};
// 			request(options, function(error, response, body) {
// 				if (error) {
// 					resolve({
// 						message: "验证请求失败",
// 						style: 0
// 					})
// 				} else {
// 					resolve({
// 						message: body,
// 						style: 1
// 					});
// 				}
// 			});
// 		} catch (e) {
// 			resolve({
// 				message: "验证请求失败",
// 				style: 0
// 			})
// 		}
// 	})
// }



// server.post('/wxlogin', async function(req, res) {
// 	let obj = req.obj;
// 	let judgeOptions = {
// 		code: {
// 			length: 32
// 		}
// 	}
// 	let judgeCtrl = judge(judgeOptions, obj);
// 	if (judgeCtrl.style == 0) {
// 		send(res, {
// 			"msg": judgeCtrl.message,
// 			"style": -1
// 		})
// 		return;
// 	}
// 	let pathCtrl = await loginCheck(obj.code)
// 	if (pathCtrl.style == 1) {
// 		let back = JSON.parse(pathCtrl.message);
// 		if (back.openid) {
// 			let sqlString = sql.select(['user_id'], 'user', `user_name=${sql.escape(back.openid)}`);
// 			try {
// 				var selectAns = await sql.sever(pool, sqlString);
// 			} catch (err) {
// 				send({
// 					"msg": err,
// 					"style": -2
// 				});
// 				return;
// 			}
// 			if (selectAns.length == 0) {
// 				let sqlString = sql.insert('user', ['user_status', 'user_name', 'user_password', 'user_time'],
// 					[4, sql.escape(back.openid), sql.escape(back.openid), 'NOW()']);
// 				try {
// 					var InsertAns = await sql.sever(pool, sqlString);
// 				} catch (err) {
// 					send({
// 						"msg": err,
// 						"style": -2
// 					});
// 					return;
// 				}
// 				cookieStep({
// 					name: back.openid,
// 					password: back.openid
// 				}, res);
// 				send(res, {
// 					"msg": "注册成功",
// 					"id": InsertAns.insertId,
// 					"style": 1
// 				})
// 			} else {
// 				cookieStep({
// 					name: back.openid,
// 					password: back.openid
// 				}, res);
// 				send(res, {
// 					"msg": "登录成功",
// 					"id": selectAns[0].user_id,
// 					"style": 1
// 				})
// 			}
// 		} else {
// 			send(res, {
// 				"msg": "验证失败！",
// 				"style": -1
// 			})
// 		}

// 	} else {
// 		send(res, {
// 			"msg": pathCtrl.message,
// 			"style": -1
// 		})
// 	}
// })






// server.post('/userEdit', async function(req,res) {
// 	let obj = req.obj;
// 	let judgeOptions = {
// 		id: {
// 			type: "int",
// 			length: 11
// 		},
// 		status: {
// 			type: "only",
// 			main: ['0', '1', '2', '3', '4'],
// 			//0表示没有权，1表示运营，2表示销售，3表示财务，4表示个人
// 			length: 64
// 		},
// 		password: {
// 			length: 32
// 		},
// 		tel: {
// 			length: 12
// 		},
// 		passwordchange: {
// 			type: "only",
// 			main: ['0', '1'],
// 			//0表示不修改，1表示修改
// 		}
// 	}
// 	let judgeCtrl = judge(judgeOptions, obj);
// 	if (judgeCtrl.style == 0) {
// 		send(res, {
// 			"msg": judgeCtrl.message,
// 			"style": -1
// 		})
// 		return;
// 	}
// 	let sqlStringSelect = sql.select(['user_id'], 'user', 'user_id=' + sql.escape(obj.id));
// 	try {
// 		var selectAns = await sql.sever(pool, sqlStringSelect);
// 	} catch (err) {
// 		send(res, {
// 			"msg": err,
// 			"style": -2
// 		});
// 		return;
// 	}
// 	if (selectAns.length != 1) {
// 		send(res, {
// 			"msg": "没有查询到要修改的id",
// 			"style": 0
// 		});
// 		return;
// 	}

// 	if (obj.passwordchange == 0) {
// 		let sqlString = sql.update('user', [ 'user_status', 'user_tel'],
// 			[sql.escape(obj.status), obj.tel==""?null:sql.escape(obj.tel)],
// 			'user_id=' + sql.escape(obj.id));
// 		try {
// 			var selectAns = await sql.sever(pool, sqlString);
// 		} catch (err) {
// 			send(res, {
// 				"msg": err,
// 				"style": -2
// 			});
// 			return;
// 		}
// 	} else {

// 		let sqlString = sql.update('user', ['user_password', 'user_status', 'user_tel'],
// 			[ sql.escape(obj.password), sql.escape(obj.status), obj.tel==""?null:sql.escape(obj.tel)],
// 			'user_id=' + sql.escape(obj.id));
// 		try {
// 			var selectAns = await sql.sever(pool, sqlString);
// 		} catch (err) {
// 			send(res, {
// 				"msg": err,
// 				"style": -2
// 			});
// 			return;
// 		}
// 	}
// 	send(res, {
// 		"msg": "编辑成功！",
// 		"style": 1
// 	});
// })
// //修改个人信息
