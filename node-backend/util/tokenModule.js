const jwt = require("jsonwebtoken");
const secret = "woshiyigeqianming"; //签名


//验证token
const verifyTokenMiddle = (token) => {
	back = {
		style: true
	};
	try {
		back.info = jwt.verify(token, secret).info;

	} catch (e) {
		back.style = false;
	}
	return back
}

//创建token
const createToken = (data) => {
	const payload = {
		info: data
	}
	return jwt.sign(payload, secret, {
		expiresIn: '2days'
	});
}


module.exports = {
	createToken,
	verifyTokenMiddle
}
