const Joke = require("../models/jokes.model");

module.exports = {
    create: function( req, res){
        console.log("create method");
        Joke.create(req.body)
        .then((joke) => {res.json(joke);})
        .catch((err) => {res.json(err);})
    },

    getAll(req, res){
        console.log("getAll method");
        Joke.find()
        .then((jokes) => {res.json(jokes);})
        .catch((err) => {res.json(err);})
    },

    getOne(req,res){
        console.log("getOne method", "url params: ", req.params);
        Joke.findById(req.params.id)
        .then((joke) => {res.json(joke);})
        .catch((err) => {res.json(err);})
    },

    delete(req,res){
        console.log("delete method", "url params: ", req.params);
        Joke.findByIdAndDelete(req.params.id)
        .then((joke) => {res.json(joke);})
        .catch((err) => {res.json(err);})
    },

    update(req,res){
        console.log("update method", "url params: ", req.params);
        Joke.findByIdAndUpdate(req.params.id, req.body, {
            runValidators: true,
            new: true
        })
        .then((joke) => {res.json(joke);})
        .catch((err) => {res.json(err);})
    },

    getRandom(req,res){
        console.log("getRandom");
        Joke.count().exec((err, count) => {
        var random = Math.floor(Math.random() * count)
        Joke.findOne().skip(random).exec((err, result) => {
            if(err){return res.json(err)}
            return res.json(result);
        })
    })
    }
}
