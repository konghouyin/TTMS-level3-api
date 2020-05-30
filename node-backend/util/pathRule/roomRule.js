const roomAddRule = {
	name: {
		type: "string",
		max: 64
	},
	row: {
		type: "int",
	},
	col: {
		type: "int",
	},
	seat: {
		type: "Array",
	},
	status: {
		type: 'only',
		main: ["0", "1"],
	},
}

const roomIdRule = {
	id: {
		type: "int",
	}
}

const roomChangeRule = {
	change: {
		type: 'only',
		main: ["0", "1"]
	}
}

const empty = {}


const roomRouter = {
	"/TTMS-v3/api/roomAdd": roomAddRule,
	"/TTMS-v3/api/roomAll": empty,
	"/TTMS-v3/api/roomMain": roomIdRule,
	"/TTMS-v3/api/roomDel": roomIdRule,
	"/TTMS-v3/api/roomEdit": Object.assign({},roomAddRule,roomIdRule, roomChangeRule),
}


module.exports = {
	roomRouter
}
