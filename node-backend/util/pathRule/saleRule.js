const idRule = {
	id: {
		type: "int",
	}
}

const orderRule = {
	id: {
		type: "int",
	},
	ticket: {
		type: "Array",
	}
}

const empty = {}

const saleRouter = {
	"/TTMS-v3/api/playNear": empty,
	"/TTMS-v3/api/planList": idRule,
	"/TTMS-v3/api/ticketList": idRule,
	"/TTMS-v3/api/order": orderRule,
	
}

module.exports = {
	saleRouter
}
