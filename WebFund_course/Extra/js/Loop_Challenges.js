//1
for (var i = 1; i <= 20; i++) {
    if (i % 2 != 0) {
        console.log(i)
    }
}

//2
for (var x = 100; x > 0; x--) {
    if (x % 3 == 0) {
        console.log(x)
    }
}

//3
for (var y = 4; y > -4; y-=1.5) {
    console.log(y)
}

//4
var sum = 0;
for (var z = 1; z <= 100; z++) {
    sum = sum + z
}
console.log(sum)

//5
var product = 1;
for (var l = 1; l <= 12; l++) {
    product = product * l;
}
console.log(product)