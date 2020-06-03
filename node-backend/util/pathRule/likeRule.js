const idRule = {
	playId: {
		type: "int",
	}
}

const empty = {}

const likeRouter = {
	"/TTMS-v3/api//userwant/get": idRule,
	"/TTMS-v3/api/userwant/add": idRule,
	"/TTMS-v3/api/userwant/del": idRule,
	"/TTMS-v3/api/userwant/getAll": empty

}

module.exports = {
	likeRouter
}
