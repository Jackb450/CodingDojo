const mongoose = require("mongoose");

mongoose.connect("mongodb://localhost/Joke", {
	useNewUrlParser: true,
	useUnifiedTopology: true,
})
	.then(() => console.log("Connected to Joke DB"))
	.catch(err => console.log("Cant connect to DB", err));