const idRule = {
	playId: {
		type: "int",
	}
}

const empty = {}

const likeRouter = {
	"/TTMS-v3/api//userwant/get": planAddRule,
	"/TTMS-v3/api/userwant/add": planAddRule,
	"/TTMS-v3/api/userwant/del": planAddRule,
	"/TTMS-v3/api/userwant/getAll": empty

}

module.exports = {
	likeRouter
}
