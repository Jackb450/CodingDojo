from flask_app.config.mysqlconnection import connectToMySQL

class Users:
    def __init__(self, data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
    
    @classmethod
    def get_all(cls):
        query = "SELECT * FROM names;"
        results = connectToMySQL('users_schema').query_db(query)
        names = []

        for users in results:
            names.append(cls(users))
        return names

    @classmethod
    def get_one(cls, data):
        query = "SELECT * FROM names WHERE id=%(id)s;"
        results = connectToMySQL('users_schema').query_db(query, data)
        return cls(results[0])

    @classmethod
    def save(cls, data):
        query = "INSERT INTO names (first_name, last_name, email, created_at, updated_at) VALUES (%(fname)s, %(lname)s, %(email)s, NOW(), NOW());"
        return connectToMySQL('users_schema').query_db(query, data)

    @classmethod
    def update(cls,data):
        query = "UPDATE names SET first_name=%(first_name)s, last_name=%(last_name)s, email=%(email)s, updated_at=NOW() WHERE id = %(id)s;"
        return connectToMySQL('users_schema').query_db(query,data)

    @classmethod
    def destroy(cls,data):
        query  = "DELETE FROM names WHERE id = %(id)s;"
        return connectToMySQL('users_schema').query_db(query,data)