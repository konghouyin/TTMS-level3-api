
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


const queryRule = {
	url:{
		type:"string",
		max:500
	}
}

const judgeOptions = {
		name: {
			type:"string",
			length: 64
		},
		director: {
			type:"string",
			length: 32
		},
		actor: {
			type:"string",
			length: 128
		},
		type: {
			type:"string",
			length: 32
		},
		timelong: {
			type: "int",
			length: 32
		},
		country: {
			type:"string",
			length: 32
		},
		language: {
			type:"string",
			length: 32
		},
		status: {
			type: "only",
			main: ["已上映", "即将上映", "已下线"],
			length: 32
		},
		pic: {
			type:"string",
			length: 200
		},
		link: {
			type:"string",
			length: 200
		},
		url: {
			type:"string",
			length: 200
		}
	}

const router = {
	"/TTMS-v3/account/reg":accountRule,
	"/TTMS-v3/account/login":accountRule,
	"/TTMS-v3/api/userAll":empty,
	"/TTMS-v3/api/query":queryRule,
	"/TTMS-v3/api/playAdd":judgeOptions,
}

module.exports = {
	router
}
