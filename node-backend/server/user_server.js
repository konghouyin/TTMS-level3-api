const express = require('express');
const sql = require('../util/sql.js');
const pool = sql.createPool();
//创建数据库连接池

const server = express();
const {send,postQuery} = require('../util/http.js'); 
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
