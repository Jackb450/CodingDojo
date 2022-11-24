from flask_app import app
from flask import render_template, redirect, request, flash, session
from flask_app.models.model_user import User
from flask_app.models.model_game import Game

@app.route('/game/create')
def game_form():
    if not 'user_id' in session:
        return redirect ('/')
    user = User.get_one_by_id({'id':session['user_id']})
    return render_template('new_game.html', user=user)

@app.route('/game/new', methods=['POST'])
def new_form():
    if not 'user_id' in session:
        return redirect ('/')
    if not Game.validator(request.form):
        return redirect('/game/create')
    data = {
        **request.form,
        'user_id':session['user_id']
    }
    Game.create(data)
    return redirect('/welcome')

@app.route('/game/<int:id>/edit', methods=["GET", "POST"])
def edit_game(id):
    if not 'user_id' in session:
        return redirect ('/')
    if(request.method == "POST"):
        data = request.form
        print(data)
        Game.update(data)
        return redirect('/')
    data = {
        "id": id
    }
    selected_game = Game.get_one(data)
    return render_template("edit_game.html", game=selected_game)

@app.route('/game/<int:id>/verify', methods=['GET', 'POST'])
def verify_edit(id):
    if not 'user_id' in session:
        return redirect ('/')
    if not Game.validator(request.form):
        return redirect(f'/game/{id}/edit')
    data = {
        **request.form,
        'user_id':session['user_id'],
        "id": id
    }
    Game.update(data)
    return redirect('/welcome')

@app.route('/game/<int:id>')
def game_info(id):
    if not 'user_id' in session:
        return redirect ('/')
    data = {
        "id": id
    }
    user = User.get_one_by_id({'id':session['user_id']})
    selected_game = Game.get_by_id(data)
    return render_template("game_info.html", game=selected_game, user=user)

@app.route('/game/<int:id>/delete')
def delete_game(id):
    if not 'user_id' in session:
        return redirect ('/')
    data = {
        'id': id
    }
    delete = Game.get_by_id(data)
    if not session['user_id'] == delete.user_id:
        flash("Don't delete other people's info")
        return redirect('/')
    Game.destroy(data)
    return redirect ('/welcome')
