const accountRule = require("./accountRule.js").accountRouter;
const userRule = require("./userRule.js").userRouter;
const playRule = require("./playRule.js").playRouter;
const reportTypeRule = require("./reportTypeRule.js").reportTypeRouter;
const roomRule = require("./roomRule.js").roomRouter;
const planRule = require("./planRule.js").planRouter;
const saleRule = require("./saleRule.js").saleRouter;
const reportRule = require("./reportRule.js").reportRouter;

module.exports = {
	router: Object.assign({},
		accountRule,
		userRule,
		playRule,
		reportTypeRule,
		roomRule,
		planRule,
		saleRule,
		reportRule
	)
}
