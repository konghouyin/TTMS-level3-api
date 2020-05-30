
const reportAddRule = {
	commentId: {
		type: "int",
	},
	reporttypeId: {
		type: "int",
	},
	reportText: {
		type: "string",
	}
}

const idRule = {
	commentId: {
		type: "int",
	}
}

const commentAddRule = {
	playId:{
		type: "int",
	},
	commentText: {
		type: "string",
	},
	commentLevel: {
		type: "int",
	}
	
}

const empty = {}

const reportRouter = {
	"/TTMS-v3/api/report/add": reportAddRule,
	"/TTMS-v3/api/comment/report":empty,
	"/TTMS-v3/api/comment/del":idRule,
	"/TTMS-v3/api/comment/reject":idRule,
	"/TTMS-v3/api/comment/add":commentAddRule
}

module.exports = {
	reportRouter
}
