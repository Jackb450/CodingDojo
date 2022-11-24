from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import DATABASE
from flask import flash
from flask_app.models import model_user
from flask_app.models import model_game

class Material:
    def __init__(self, data):
            self.id = data['id']
            self.user_id = data['user_id']
            self.game_id = data['game_id']
            self.material = data['material']
            self.amount = data['amount']
            self.description = data['description']
            self.created_at = data['created_at']
            self.updated_at = data['updated_at']

    @classmethod
    def create(cls, data):
        query = "INSERT INTO materials (user_id, game_id, material, amount, description) VALUES(%(user_id)s, %(game_id)s, %(material)s, %(amount)s, %(description)s);"
        return connectToMySQL(DATABASE).query_db(query, data)

    @classmethod
    def update(cls, data):
        query = "UPDATE materials SET material = %(material)s, amount = %(amount)s, description = %(description)s WHERE id = %(id)s;"
        return connectToMySQL(DATABASE).query_db(query, data)
    
    @classmethod
    def get_all(cls, data):
        query = "SELECT * FROM materials JOIN games JOIN users ON materials.game_id = games.user_id = materials.user_id = users.id WHERE games.user_id = %(id)s;"
        results = connectToMySQL(DATABASE).query_db(query, data)
        if results:
            all_materials = []
            for row in results:
                this_material = cls(row)
                user_data = {
                    **row,
                    'id':row['games.id'],
                    'created_at':row['games.created_at'],
                    'updated_at':row['games.updated_at']
                }
                this_game = model_game.Game(user_data)
                this_material.play = this_game
                all_materials.append(this_material)
            return all_materials
        return results