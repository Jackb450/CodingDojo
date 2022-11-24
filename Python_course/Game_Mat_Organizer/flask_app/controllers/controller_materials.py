from flask_app import app
from flask import render_template, redirect, request, flash, session
from flask_app.models.model_user import User
from flask_app.models.model_game import Game
from flask_app.models.model_material import Material

@app.route('/game/<int:id>/materials')
def material_list(id):
    if not 'user_id' in session:
        return redirect ('/')
    data = {
        "id": id
    }
    user = User.get_one_by_id({'id':session['user_id']})
    all_materials = Material.get_all(data)
    selected_game = Game.get_by_id(data)
    return render_template('Materials.html', user=user, all_materials=all_materials, game=selected_game)