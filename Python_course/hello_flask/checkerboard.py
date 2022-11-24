from flask import Flask, render_template
app = Flask(__name__)

@app.route('/')
def chess():
    return render_template('chess.html', across = 8, down = 8)

@app.route('/<num>')
def callDown(num):
    return render_template('chess.html', across = 8, down = int(num))

@app.route('/<num1>/<num2>')
def acrossDown(num1,num2):
    return render_template('chess.html', across = int(num1), down = int(num2))

if __name__=="__main__":  
    app.run(debug=True)