const jokeController = require("../controllers/jokes.controller");

module.exports = (app) => {
    app.get("/api/jokes", jokeController.getAll);
    app.get("/api/jokes/random", jokeController.getRandom);
    app.get("/api/jokes/:id", jokeController.getOne);
    app.post("/api/jokes/new", jokeController.create);
    app.put("/api/jokes/update/:id", jokeController.update);
    app.delete("/api/jokes/delete/:id", jokeController.delete);
}