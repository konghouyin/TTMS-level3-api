

const planAddRule = {
	plan: {
		type: "array",
		max: 64
	}
}

const planGetRule = {
	time: {
		type: "string",
		max: 15
	}
}



const planRouter = {
	"/TTMS-v3/api/planAdd": planAddRule,
	"/TTMS-v3/api/planGet": planGetRule,
}

module.exports = {
	planRouter
}