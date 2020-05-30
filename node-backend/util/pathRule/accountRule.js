const accountRule = {
	name: {
		type: "string",
		max: 32
	},
	password: {
		type: "string",
		max: 32
	}
}

const accountRouter = {
	"/TTMS-v3/account/reg": accountRule,
	"/TTMS-v3/account/login": accountRule,
}

module.exports = {
	accountRouter
}