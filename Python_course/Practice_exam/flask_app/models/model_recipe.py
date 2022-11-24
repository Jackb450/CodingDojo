from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import DATABASE
from flask import flash
from flask_app.models import model_user

class Recipe:
    def __init__( self , data ):
            self.id = data['id']
            self.name = data['name']
            self.description = data['description']
            self.instruction = data['instruction']
            self.date = data['date']
            self.cook = data['cook']
            self.created_at = data['created_at']
            self.updated_at = data['updated_at']
            self.user_id = data['user_id']

    @classmethod
    def create(cls, data):
        query = "INSERT INTO recipe (name, description, instruction, date, cook, user_id) VALUES(%(name)s, %(description)s, %(instruction)s, %(date)s, %(cook)s, %(user_id)s);"
        return connectToMySQL(DATABASE).query_db(query, data)

    @classmethod
    def update(cls, data):
        query = "UPDATE recipe SET name = %(name)s, description = %(description)s, instruction = %(instruction)s, date = %(date)s, cook = %(cook)s WHERE id = %(id)s;"
        return connectToMySQL(DATABASE).query_db(query, data)

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM recipe JOIN users on users.id = recipe.user_id;"
        results = connectToMySQL(DATABASE).query_db(query)
        if results:
            all_recipe = []
            for row in results:
                this_recipe = cls(row)
                user_data = {
                    **row,
                    'id':row['users.id'],
                    'created_at':row['users.created_at'],
                    'updated_at':row['users.updated_at']
                }
                this_user = model_user.User(user_data)
                this_recipe.food = this_user
                all_recipe.append(this_recipe)
            return all_recipe
        return results

    @classmethod
    def get_by_id(cls, data):
        query = "SELECT * FROM recipe JOIN users on users.id = recipe.user_id WHERE recipe.id = %(id)s;"
        results = connectToMySQL(DATABASE).query_db(query, data)
        if len(results) < 1:
            return False
        row = results[0]
        this_recipe = cls(row)
        user_data = {
            **row,
            'id':row['users.id'],
            'created_at':row['users.created_at'],
            'updated_at':row['users.updated_at']
        }
        food = model_user.User(user_data)
        this_recipe.chef = food
        return this_recipe

    @classmethod
    def destroy(cls, data):
        query  = "DELETE FROM recipe WHERE id = %(id)s;"
        return connectToMySQL(DATABASE).query_db(query, data)

    @classmethod
    def get_one(cls, data):
        query = "SELECT * FROM recipe WHERE id=%(id)s;"
        results = connectToMySQL(DATABASE).query_db(query, data)
        return cls(results[0])

    @staticmethod
    def validator(form_data):
        is_valid = True
        if len(form_data['name']) < 3:
            flash("name required", 'err_name')
            is_valid = False
        if len(form_data['description']) < 4:
            flash("description required", 'err_description')
            is_valid = False
        if len(form_data['instruction']) < 4:
            flash("instruction required", 'err_instruction')
            is_valid = False
        if len(form_data['date']) < 1:
            flash("date required", 'err_date')
            is_valid = False
        if 'cook' not in form_data:
            flash("under 30 minutes not checked", 'err_cook')
            is_valid = False
        return is_valid
