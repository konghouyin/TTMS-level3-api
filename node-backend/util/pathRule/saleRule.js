const idRule = {
	id: {
		type: "int",
	}
}

const orderRule = {
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
	"/TTMS-v3/api/selectOrder":idRule,
	"/TTMS-v3/api/selectAllOrder": empty,
	"/TTMS-v3/api/saleOrder": idRule,
}

module.exports = {
	saleRouter
}
