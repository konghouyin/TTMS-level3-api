const express = require('express');
//const request = require("request"); //发送网路请求
const routerRule = require("./pathRule/index.js").router;

const server = express(); //使用express框架


server.all('*', function(req, res, next) {
	res.header("Access-Control-Allow-Origin", req.headers.origin); //需要显示设置来源
	res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
	res.header("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");
	res.header("Access-Control-Allow-Credentials", true); //带cookies7     
	res.header("Content-Type", "application/json;charset=utf-8"); //解决中文乱码
	next();
});
//处理跨域-中间件


function postQuery(req, res, next) {
	let message = '';
	req.on('data', function(data) {
		message += data;
	})
	req.on('end', function() {
		try {
			req.obj = JSON.parse(message);
		} catch (e) {
			req.obj = {};
		}
		next();
	});
}
server.post('*',postQuery);
//post请求数据解析-中间件

server.get('*', function(req, res, next) {
	req.obj = req.query;
	next();

});
//get请求数据解析-中间件


server.all('*', function(req, res, next) {
	let data = req.obj;
	console.log(data)
	let check = judge(routerRule[req._parsedUrl.pathname],data);
	if(check.style === 1){
		next();
	}else{
		send(res,{
			"msg": check.message || "参数错误！",
			"style": -1
		});
	}
});
//参数校验


function judge(judge, obj) {
	if(judge === undefined){
		return {
			style: 0,
			message: "路径匹配有误"
		};
	}
	for (each in judge) {
		if (obj[each] == undefined) {
			return {
				style: 0,
				message: each+"参数缺失"
			};
		}
		
		if(judge[each].type && judge[each].type.toLowerCase() === "string"){
			if (!( typeof(obj[each]) ==='string')){
				return {
					style: 0,
					message: each + "(string)参数格式不对"
				};
			}
		}
		
		if (judge[each].type.toLowerCase() === "string" && judge[each].max < obj[each].length) {
			return {
				style: 0,
				message: each + "长度不符合要求"
			};
		}
		
		if(judge[each].type && judge[each].type.toLowerCase() === "array"){
			if (!(obj[each] instanceof Array)){
				return {
					style: 0,
					message: each + "(Array)参数格式不对"
				};
			}
		}
		
		if(judge[each].type && judge[each].type.toLowerCase() === "object"){
			if (!(obj[each] instanceof Object)){
				return {
					style: 0,
					message: each + "(Object)参数格式不对"
				};
			}
		}
		

		if (judge[each].type && judge[each].type.toLowerCase()  === "int") {
			let int = Number.parseInt(obj[each]);
			if (isNaN(int)) {
				return {
					style: 0,
					message: each + "(Int)参数格式不对"
				};
			} else {
				obj[each] = int;
			}
		}

		if (judge[each].type && judge[each].type.toLowerCase()  === "float") {
			let float = Number.parseFloat(obj[each]);
			if (isNaN(float)) {
				return {
					style: 0,
					message: each + "(Float)参数格式不对"
				};
			} else {
				obj[each] = float;
			}
		}

		if (judge[each].type && judge[each].type.toLowerCase() === "only") {
			let flag = 0;
			for (let i = 0; i < judge[each].main.length; i++) {
				if (judge[each].main[i] === obj[each]) {
					flag = 1;
				}
			}
			if (flag === 0) {
				return {
					style: 0,
					message: each + "(only)参数内容不对"
				};
			}
		}
	}
	return {
		style: 1
	};
}
//审核参数正确性


function getRouter(){
	return express.Router();
}
//创建路由

function send(res, obj) {
	res.write(JSON.stringify(obj));
	res.end();
}
//发送请求


module.exports = {
	send: send,
	app: server,
	getRouter:getRouter,
	postQuery
}
