from flask import render_template,redirect,request
from flask_app import app
from flask_app.models import dojo

@app.route('/')
def index():
    return redirect('/dojos')

@app.route('/dojos')
def dojos():
    context = {
        'dojos' : dojo.Dojo.get_all()
    }
    return render_template("dojo.html", **context)

@app.route('/dojos/create',methods=['POST'])
def create():
    dojo.Dojo.save(request.form)
    return redirect('/dojos')

@app.route('/dojo/<int:id>')
def show(id):
    data ={
        "id":id
    }
    context = {
        'dojo' : dojo.Dojo.dojo_with_members(data)
    }
    return render_template("members.html", **context)