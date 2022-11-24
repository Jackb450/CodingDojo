const express = require("express");
const app = express();
app.use(express.json());

require("./server/routes/jokes.routes")(app)
require("./server/config/mongoose.config")

const server = app.listen(8000, () => {
    console.log(`Server in Action on ${server.address().port}!`)
});