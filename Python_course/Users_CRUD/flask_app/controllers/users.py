from flask import Flask, render_template, request, redirect
from flask_app import app
from flask_app.models.user import Users

@app.route("/")
def user():
    return redirect("/users")

@app.route("/users")
def users():
    return render_template("All_Users.html", one_user=Users.get_all())

@app.route('/users/new')
def new():
    return render_template("create_users.html")

@app.route('/users/create', methods=['POST'])
def create():
    print(request.form)
    Users.save(request.form)
    return redirect('/users')

@app.route('/users/<int:id>')
def show_user(id):
    data = {
        "id": id
    }
    selected_user = Users.get_one(data)
    return render_template("show_users.html", one_user=selected_user)

@app.route('/users/<int:id>/edit', methods=["GET","POST"])
def edit_user(id):
    if(request.method == "POST"):
        data = request.form
        print(data)
        Users.update(data)
        return redirect('/users')
    data = {
        "id": id
    }
    selected_user = Users.get_one(data)
    return render_template("edit_users.html", one_user=selected_user)

@app.route('/users/<int:id>/delete')
def delete_user(id):
    data = {
        "id": id
    }
    selected_user = Users.destroy(data)
    return redirect('/users')