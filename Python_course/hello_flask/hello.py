from flask import Flask, render_template
app = Flask(__name__)

@app.route('/')
def hello_world():
    return render_template('index.html', phrase = "hello", times = 5)

@app.route('/Success')
def success():
    return 'Success'

@app.route('/Dojo')
def dojo():
    return 'Dojo!'

@app.route('/Flask')
def flash():
    return 'Flask!'

@app.route('/Say/<name>')
def hi(name):
    return f'Hi {name.capitalize()}!'

@app.route('/repeat/<int:num>/<string:word>')
def repeat(num, word):
    output = ' '
    for i in range (0, num):
        output += f'<p>{word}</p>'
    return output

if __name__=="__main__":  
    app.run(debug=True)