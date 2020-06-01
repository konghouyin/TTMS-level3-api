const userPoint = 526 //用户信息管理后台
const managerPoint = 536 // 剧院经理管理后台
const salePoint = 546 // 购票退票后台
const java = 8080 //java后台端口号

//服务端口配置

userStatusTable = {
	user: 1, 		//用户
	manager: 2, 	//剧院管理（演出厅、剧目、票房）
	recommend: 3, 	//推荐流管理
	sale: 4, 		//销售（售票、退票）
	finance: 5, 	//财务模块（票房统计、销售统计）
	userManager: 6, //用户管理
	comment: 7, 	//评论管理
	push: 8, 		//推送系统
	wx: 9 			//微信小程序
} 
//权限配置

const selectConfig = {
	point: managerPoint,
	status: [userStatusTable.manager,userStatusTable.sale,userStatusTable.user]
}
//剧目数据查询

const ticketSelectConfig = {
	point: salePoint,
	status: [userStatusTable.wx,userStatusTable.sale,userStatusTable.user]
}
//销售数据查询

const userCommentConfig = {
	point: java,
	status: [userStatusTable.user]
}
//评论举报 / 用户

const userManagerConfig = {
	point: userPoint,
	status: [userStatusTable.userManager]
}
//用户平台管理


const userConfig = {
	point: userPoint,
	status: [userStatusTable.user]
}
//个人中心管理


const managerConfig = {
	point: managerPoint,
	status: [userStatusTable.manager]
}
//剧院经理

const reportConfig = {
	point: java,
	status: [userStatusTable.comment]
}
//举报管理
//配置聚合

const router = {
	"/userAll": userManagerConfig,
	"/userEdit":userManagerConfig,
	"/userMain": userManagerConfig,
	"/userChange":userManagerConfig,
	
	"/query": managerConfig,
	"/playAdd": managerConfig,
	"/playAll": selectConfig,
	"/playMain": selectConfig,
	"/playDel": managerConfig,
	"/playEdit": managerConfig,
	"/upload/singlefile":managerConfig,
	
	"/roomAdd": managerConfig,
	"/roomAll":selectConfig,
	"/roomMain":selectConfig,
	"/roomDel": managerConfig,
	"/roomEdit": managerConfig,
	
	"/planAdd":managerConfig,
	"/planGet":selectConfig,
	
	"/reportType/all":Object.assign({},reportConfig,{status:[userStatusTable.comment,userStatusTable.user]}),
	"/reportType/add":reportConfig,
	"/reportType/del":reportConfig,
	
	"/report/add":userCommentConfig,
	"/comment/report":reportConfig,
	"/comment/del":reportConfig,
	"/comment/reject":reportConfig,
	"/comment/add":userCommentConfig,
	
	"/playNear":ticketSelectConfig,
	"/planList":ticketSelectConfig,
	"/ticketList":ticketSelectConfig,
	"/order":ticketSelectConfig,
	"/selectOrder":ticketSelectConfig,
	"/selectAllOrder":ticketSelectConfig,
	"/saleOrder":ticketSelectConfig,
	"/cancelOrder":ticketSelectConfig,
	"/ticketMessage":ticketSelectConfig,
	"/cancelSale":ticketSelectConfig,
	
}

module.exports = {
	router
}
