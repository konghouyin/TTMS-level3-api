
const accountRule = {
	name:{
		type:"string",
		max:32
	},
	password:{
		type:"string",
		max:32
	}
}

const empty={}

const router = {
	"/TTMS-v3/account/reg":accountRule,
	"/TTMS-v3/account/login":accountRule,
	"/TTMS-v3/api/userAll":empty
}

module.exports = {
	router
}
