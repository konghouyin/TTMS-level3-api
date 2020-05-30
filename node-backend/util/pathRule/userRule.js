const empty = {}

const userEditRule = {
	id: {
		type: "int",
	},
	status: {
		type: "string",
		max: 64
	},
	password: {
		type: "string",
		max: 32
	},
	tel: {
		type: "string",
		max: 15
	},
	passwordchange: {
		type: "only",
		main: ['0', '1'],
		//0表示不修改，1表示修改
	}
}


const userChangeRule = {
	hobby: {
		type: "string",
		max: 200
	},
	signal: {
		type: "string",
		max: 200
	},
	tel: {
		type: "string",
		max: 15
	},
	sex: {
		type: "only",
		main: ['1', '2'],
		//1表示男，2表示女
	}
}

const userRouter = {
	"/TTMS-v3/api/userAll": empty,
	"/TTMS-v3/api/userEdit":userEditRule,
	"/TTMS-v3/api/userMain":empty,
	"/TTMS-v3/api/userChange":userChangeRule
}

module.exports = {
	userRouter
}
