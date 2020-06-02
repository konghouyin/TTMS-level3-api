const recommendAdd = {
	"playId": {
		type: "int"
	},
	"type": {
		type: "int"
	},
	"msg": {
		type: "string",
		max:200
	}
}

const empty = {}

const recommendRouter = {
	"/TTMS-v3/api/recommend/get": empty,
	"/TTMS-v3/api/link/get": empty,
	"/TTMS-v3/api/recommend/add": recommendAdd,
}

module.exports = {
	recommendRouter
}
