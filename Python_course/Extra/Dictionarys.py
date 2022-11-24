print("---------------------------------------")

x = [[5, 2, 3], [15, 8, 9]] 
print(x)

students = [
     {'first_name': 'Michael', 'last_name': 'Jordan'},
     {'first_name': 'John', 'last_name': 'Rosales'}
]
print(students)

sports_directory = {
    'basketball': ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer': ['Messi', 'Ronaldo', 'Rooney']
}
print(sports_directory)

z = [{'x': 10, 'y': 30}]
print(z)

print("---------------------------------------")

students2 = [
        {'first_name':  'Michael', 'last_name': 'Jordan'},
        {'first_name': 'John', 'last_name': 'Rosales'},
        {'first_name': 'Mark', 'last_name': 'Guillen'},
        {'first_name': 'KB', 'last_name': 'Tonel'}
]

def iterateDictionary(students2):
    for num in students2:
        print(num["first_name"], num["last_name"])

iterateDictionary(students2)

print("---------------------------------------")

def iterateDictionary2(students2):
    for num2 in students2:
        print(num2["first_name"])

iterateDictionary2(students2)

print("---------------------------------------")

def iterateDictionary3(students2):
    for num3 in students2:
        print(num3["last_name"])

iterateDictionary3(students2)

print("---------------------------------------")

dojo = {
   'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
   'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}

def printinfo(dojo):
    for key in dojo:
        print(str(len(dojo[key])) + ' ' + key.upper())
        for i in range(len(dojo[key])):
            print(dojo[key][i])

printinfo(dojo)