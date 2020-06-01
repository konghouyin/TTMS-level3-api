const queryRule = {
	url: {
		type: "string",
		max: 500
	}
}

const playAddRule = {
	name: {
		type: "string",
		max: 64
	},
	director: {
		type: "string",
		max: 32
	},
	actor: {
		type: "string",
		max: 128
	},
	type: {
		type: "string",
		max: 32
	},
	timelong: {
		type: "int",
		max: 32
	},
	country: {
		type: "string",
		max: 32
	},
	language: {
		type: "string",
		max: 32
	},
	status: {
		type: "only",
		main: ["已上映", "即将上映", "已下线"],
		max: 32
	},
	pic: {
		type: "string",
		max: 200
	},
	link: {
		type: "string",
		max: 200
	},
	url: {
		type: "string",
		max: 200
	}
}

const playMainRule = {
	id: {
		type: "int"
	}
}

const empty = {}


const playRouter = {
	"/TTMS-v3/api/query": queryRule,
	"/TTMS-v3/api/playAdd": playAddRule,
	"/TTMS-v3/api/playAll": empty,
	"/TTMS-v3/api/playMain": playMainRule,
	"/TTMS-v3/api/playDel": playMainRule,
	"/TTMS-v3/api/playEdit": Object.assign({}, playAddRule, playMainRule),
	"/TTMS-v3/api/upload/singlefile": empty
}

module.exports = {
	playRouter
}