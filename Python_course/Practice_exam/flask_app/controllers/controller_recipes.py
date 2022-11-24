from flask_app import app
from flask import render_template, redirect, request, flash, session
from flask_app.models.model_user import User
from flask_app.models.model_recipe import Recipe

@app.route('/recipe/create')
def recipe_form():
    if not 'user_id' in session:
        return redirect ('/')
    user = User.get_one_by_id({'id':session['user_id']})
    return render_template('new_recipe.html', user=user)

@app.route('/recipe/new', methods=['POST'])
def new_form():
    if not 'user_id' in session:
        return redirect ('/')
    if not Recipe.validator(request.form):
        return redirect('/recipe/create')
    data = {
        **request.form,
        'user_id':session['user_id']
    }
    Recipe.create(data)
    return redirect('/welcome')

@app.route('/recipe/<int:id>/edit', methods=["GET", "POST"])
def edit_recipe(id):
    if not 'user_id' in session:
        return redirect ('/')
    if(request.method == "POST"):
        data = request.form
        print(data)
        Recipe.update(data)
        return redirect('/')
    data = {
        "id": id
    }
    selected_recipe = Recipe.get_one(data)
    return render_template("edit_recipe.html", recipe=selected_recipe)

@app.route('/recipe/<int:id>')
def show_user(id):
    if not 'user_id' in session:
        return redirect ('/')
    data = {
        "id": id
    }
    user = User.get_one_by_id({'id':session['user_id']})
    selected_recipe = Recipe.get_by_id(data)
    return render_template("recipe_info.html", recipe=selected_recipe, user=user)

@app.route('/recipe/<int:id>/delete')
def delete_recipe(id):
    if not 'user_id' in session:
        return redirect ('/')
    data = {
        'id': id
    }
    delete = Recipe.get_by_id(data)
    if not session['user_id'] == delete.user_id:
        flash("Don't delete other people's recipe")
        return redirect('/')
    Recipe.destroy(data)
    return redirect ('/welcome')
