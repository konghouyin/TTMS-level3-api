const idRule = {
	id: {
		type: "int",
	}
}

const reportAddRule = {
	id: {
		type: "int",
	},
	ticket: {
		type: "Array",
	}
}

const empty = {}

const reportRouter = {
	"/TTMS-v3/api/report/add": empty,
	
}

module.exports = {
	reportRouter
}
