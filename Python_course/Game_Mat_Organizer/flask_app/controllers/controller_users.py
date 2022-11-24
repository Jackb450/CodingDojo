from flask_app import app
from flask import render_template, redirect, request, flash, session
from flask_bcrypt import Bcrypt
from flask_app.models.model_user import User
from flask_app.models.model_game import Game

Bcrypt = Bcrypt(app)

@app.route('/')
def index():
    if 'user_id' in session:
        return redirect ('/welcome')
    return render_template ('index.html')

@app.route('/welcome')
def welcome():
    if not 'user_id' in session:
        return redirect ('/')
    user = User.get_one_by_id({'id':session['user_id']})
    all_games = Game.get_all()
    return render_template ('dashboard.html', all_games=all_games, user=user)


@app.route('/logout')
def logout():
    del session['user_id']
    return redirect('/')

@app.route('/user/create', methods= ['post'])
def create_user():
    is_valid = User.is_valid(request.form)
    if is_valid == False:
        return redirect ('/')
    hash_pw = Bcrypt.generate_password_hash(request.form['password'])
    data = {
        **request.form, 
        'password': hash_pw
    }
    id = User.create(data)
    return redirect('/welcome')

@app.route('/user/login', methods= ['post'])
def login():
    is_valid = User.is_valid_login(request.form)
    if not is_valid:
        return redirect('/')
    return redirect('/welcome')

