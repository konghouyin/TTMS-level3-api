
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

const reportDelRule = {
	commentId: {
		type: "int",
	}
}

const empty = {}

const reportRouter = {
	"/TTMS-v3/api/report/add": reportAddRule,
	"/TTMS-v3/api/comment/report":empty,
	"/TTMS-v3/api/comment/del":reportDelRule
}

module.exports = {
	reportRouter
}
