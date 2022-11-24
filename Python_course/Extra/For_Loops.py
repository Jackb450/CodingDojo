print("Task 1---------------------------------")

for i in range(0, 151):
    print(i)

print("Task 2---------------------------------")

for i in range(5, 1000, 5):
    print(i)

print("Task 3---------------------------------")

for i in range(1, 100):
    if i % 10 == 0:
        print("Coding Dojo")
    elif i % 5 == 0:
        print("Coding")
    else:
        print(i)

print("Task 4---------------------------------")

sum = 0
for i in range(0, 500000):
    if i % 2 != 0:
        sum += i 
print(sum)

print("Task 5---------------------------------")

for i in range(2018, 0, -4):
    print(i)

print("Task 6---------------------------------")

lowNum = 2
highNum = 9
mult = 3

for i in range(lowNum, highNum, mult):
    i = i + mult - lowNum
    print(i)