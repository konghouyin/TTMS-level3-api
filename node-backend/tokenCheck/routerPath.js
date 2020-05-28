const userPoint = 526 //用户信息管理后台
const managerPoint = 536 // 剧院经理管理后台
const java = 8080 //java后台端口号

//服务端口配置

userStatusTable = {
	user: 1, 		//用户
	manager: 2, 	//剧院管理（演出厅、剧目、票房）
	recommend: 3, 	//推荐流管理
	sale: 4, 		//销售（售票、退票）
	Finance: 5, 	//财务模块（票房统计、销售统计）
	userManager: 6, //用户管理
	comment: 7, 	//评论管理
	push: 8, 		//推送系统
	wx: 9 			//微信小程序
}
//权限配置


const managerConfig = {
	point: managerPoint,
	status: [userStatusTable.manager]
}

const reportConfig = {
	point: java,
	status: [userStatusTable.comment]
}
//配置聚合

const router = {
	"/userAll": {
		point: userPoint,
		status: [userStatusTable.userManager]
	},
	"/query": managerConfig,
	"/playAdd": managerConfig,
	"/playAll": managerConfig,
	"/playMain": managerConfig,
	"/playDel": managerConfig,
	"/playEdit": managerConfig,
	
	"/reportType/all":reportConfig,
	"/reportType/add":reportConfig,
	"/reportType/del":reportConfig,
	
}

module.exports = {
	router
}
