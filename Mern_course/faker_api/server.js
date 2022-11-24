const express = require("express");
const {faker} = require('@faker-js/faker');
const app = express();

class createUser {
    fakeUser() {
        this.password = faker.internet.password();
        this.email = faker.internet.email();
        this.phoneNum = faker.phone.phoneNum();
        this.LName = faker.name.LName();
        this.FName = faker.name.FName();
        this.id = faker.random.id();
    }
}
const newUser = new createUser();
console.log(newUser);

class createAddress {
    fakeAddress() {
        this.street = faker.address.street();
        this.city = faker.address.city();
        this.state = faker.address.state();
        this.zipCode = faker.address.zipCode();
        this.country = faker.address.country();
    }
}
const newAddress = new createAddress();

class createCompany {
    fakeCompany() {
        this.id = faker.random.id();
        this.name = faker.company.name();
        this.address = newAddress;
    }
}
const newCompany = new createCompany();
console.log(newCompany);


app.get("/api/users/new", (req, res) => {
    res.send(`First Name: ${newUser.FName}; Last Name: ${newUser.LName}`)
});

app.get("/api/companies/new", (req, res) => {
    res.send(`Company name: ${newCompany.name}`)
});

app.get("/api/user/company", (req, res) => {
    res.send(`First Name: ${newUser.FName}; Last Name: ${newUser.LName}; Company name: ${newCompany.name}`)
});

const server = app.listen(8000, () =>
    console.log(`Server in Action on ${server.address().port}!`)
);