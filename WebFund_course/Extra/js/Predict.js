// it will output nothing P1
function myBirthYearFunc(){
    console.log("I was born in " + 1980);
}

// it output nothing P1
function myBirthYearFunc(birthYearInput){
    console.log("I was born in " + birthYearInput);
}

//it output nothing due to num1 and num2 having no variable and we cant put in variables P1
function add(num1, num2){
    console.log("Summing Numbers!");
    console.log("num1 is: " + num1);
    console.log("num2 is: " + num2);
    var sum = num1 + num2;
    console.log(sum);
}

//It will not output
function displayContactInfo() {
    var auntContactInfo = ["Paula", "Smith", "1234 Main Street", "St. Louis", "MO", 12345];
    console.log(auntContactInfo);
}

//It will not output anything
function displayGrocerylist() {
    var produce = ["apples", "oranges"];
    var frozen = ["broccoli", "ice cream"];
    frozen.push("hashbrowns");
    console.log(frozen);
}

//It will ouput the array
var movieLibrary = ["Bambi", "E.T.", "Toy Story"];
movieLibrary.push("Zoro");
movieLibrary[1] = "Beetlejuice";
console.log(movieLibrary);