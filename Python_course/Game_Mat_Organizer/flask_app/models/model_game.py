from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import DATABASE
from flask import flash
from flask_app.models import model_user

class Game:
    def __init__(self, data):
            self.id = data['id']
            self.user_id = data['user_id']
            self.title = data['title']
            self.description = data['description']
            self.publish = data['publish']
            self.creator = data['creator']
            self.company = data['company']
            self.genre = data['genre']
            self.playing = data['playing']
            self.created_at = data['created_at']
            self.updated_at = data['updated_at']

    @classmethod
    def create(cls, data):
        query = "INSERT INTO games (user_id, title, description, publish, creator, company, genre, playing) VALUES(%(user_id)s, %(title)s, %(description)s, %(publish)s, %(creator)s, %(company)s, %(genre)s, %(playing)s);"
        return connectToMySQL(DATABASE).query_db(query, data)

    @classmethod
    def update(cls, data):
        query = "UPDATE games SET title = %(title)s, description = %(description)s, publish = %(publish)s, creator = %(creator)s, company = %(company)s, genre = %(genre)s, playing = %(playing)s WHERE id = %(id)s;"
        return connectToMySQL(DATABASE).query_db(query, data)

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM games JOIN users on users.id = games.user_id;"
        results = connectToMySQL(DATABASE).query_db(query)
        if results:
            all_games = []
            for row in results:
                this_game = cls(row)
                user_data = {
                    **row,
                    'id':row['users.id'],
                    'created_at':row['users.created_at'],
                    'updated_at':row['users.updated_at']
                }
                this_user = model_user.User(user_data)
                this_game.play = this_user
                all_games.append(this_game)
            return all_games
        return results

    @classmethod
    def get_by_id(cls, data):
        query = "SELECT * FROM games JOIN users on users.id = games.user_id WHERE games.id = %(id)s;"
        results = connectToMySQL(DATABASE).query_db(query, data)
        if len(results) < 1:
            return False
        row = results[0]
        this_game = cls(row)
        user_data = {
            **row,
            'id':row['users.id'],
            'created_at':row['users.created_at'],
            'updated_at':row['users.updated_at']
        }
        fun = model_user.User(user_data)
        this_game.broadcast = fun
        return this_game

    @classmethod
    def destroy(cls, data):
        query  = "DELETE FROM games WHERE id = %(id)s;"
        return connectToMySQL(DATABASE).query_db(query, data)

    @classmethod
    def get_one(cls, data):
        query = "SELECT * FROM games WHERE id = %(id)s;"
        results = connectToMySQL(DATABASE).query_db(query, data)
        return cls(results[0])

    @staticmethod
    def validator(form_data):
        is_valid = True
        if len(form_data['title']) < 3:
            flash("Title required", 'err_title')
            is_valid = False
        if len(form_data['description']) < 3:
            flash("Description required", 'err_description')
            is_valid = False
        if len(form_data['publish']) < 1:
            flash("When was it first released globally?", 'err_publish')
            is_valid = False
        if len(form_data['creator']) < 3:
            flash("who created the game?", 'err_creator')
            is_valid = False
        if len(form_data['company']) < 3:
            flash("which company has the IP rights?", 'err_company')
            is_valid = False
        if len(form_data['genre']) < 2:
            flash("what are the games genre?", 'err_genre')
            is_valid = False
        if 'playing' not in form_data:
            flash("Are you playing the game?", 'err_playing')
            is_valid = False
        return is_valid
