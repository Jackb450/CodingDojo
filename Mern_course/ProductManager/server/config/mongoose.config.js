const mongoose = require('mongoose');

mongoose.connect("mongodb://localhost/ProductManager", {
    useNewUrlParser: true,
    useUnifiedTopology: true,
})
    .then(() => console.log("Connected to ProductManager DB"))
    .catch(err => console.log("Cant connect to DB", err));