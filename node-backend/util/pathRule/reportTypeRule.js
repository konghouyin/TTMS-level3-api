
const empty = {}

const reportTypeAddRule = {
	reporttypeName: {
		type: "string",
		max: 15
	}
}

const reportTypeDelRule = {
	reporttypeId: {
		type: "int"
	}
}

const reportTypeRouter = {
	"/TTMS-v3/api/reportType/all": empty,
	"/TTMS-v3/api/reportType/add": reportTypeAddRule,
	"/TTMS-v3/api/reportType/del": reportTypeDelRule
}


module.exports = {
	reportTypeRouter
}