import React, {useState} from 'react';
import '../App.css'
import Display from './Index';

const UserForm = () => {
  const [FName, setFName] = useState("");
  const [LName, setLName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [Confirm, setConfirm] = useState("");
  const [FNameErr, setFNameErr] = useState("");
  const [LNameErr, setLNameErr] = useState("");
  const [emailErr, setEmailErr] = useState("");
  const [passwordErr, setPasswordErr] = useState("");
  const [ConfirmErr, setConfirmErr] = useState("");
  const [hasBeenSubmitted, setHasBeenSubmitted] = useState(false);
  
  const createUser = (e) => {
    e.preventDefault();
    const newUser = {FName, LName, email, password};
    console.log("Welcome", newUser);
    setHasBeenSubmitted(true);
  };
  const Fname = (e) => {
    setFName(e.target.value);
    if (e.target.value.length<2) {
      setFNameErr("First name must at least be 2 characters");
    }
    else {
      setFNameErr("");
    }
  }
  const Lname = (e) => {
    setLName(e.target.value);
    if (e.target.value.length<2) {
      setLNameErr("Last name must at least be 2 characters");
    }
    else {
      setLNameErr("");
    }
  }
  const Email = (e) => {
    setEmail(e.target.value);
    if (e.target.value.length<5) {
      setEmailErr("Email must be 5 characters or longer");
    }
    else {
      setEmailErr("");
    }
  }
  const Password = (e) => {
    setPassword(e.target.value);
    if (e.target.value.length<8) {
      setPasswordErr("Password must be 8 characters or longer");
    }
    else {
      setPasswordErr("");
    }
  }
  const Verify = (e) => {
    setConfirm(e.target.value);
    if (e.target.value !== password) {
      setConfirmErr("password and Confirm does not match");
    }
    else {
      setConfirmErr("");
    }
  }
  const formMessage = () => {
    if(hasBeenSubmitted) {
  return "Thank you for submitting the form!";
  }
  else {
    return "Welcome, please submit the form";
  }
};

  return (
    <>
      <form onSubmit={createUser}>
        <h3>{formMessage()}</h3>
      <div>
        <label>First name: </label> 
        <input type="text" onChange={Fname}/>
        <span style={{color: "red"}}>{FNameErr}</span>
      </div>
      <div>
        <label>Last name: </label> 
        <input type="text" onChange={Lname}/>
        <span style={{color: "red"}}>{LNameErr}</span>
      </div>
      <div>
        <label>Email Address: </label> 
        <input type="text" onChange={Email}/>
        <span style={{color: "red"}}>{emailErr}</span>
      </div>
      <div>
        <label>Password: </label>
        <input type="text" onChange={Password}/>
        <span style={{color: "red"}}>{passwordErr}</span>
      </div>
      <div>
        <label>Confirm Password: </label>
        <input type="text" onChange={Verify}/>
        <span style={{color: "red"}}>{ConfirmErr}</span>
      </div>
      <input type="submit" value="Create User" disabled={FName<=2 || LName<=2 || email<=5 || password<=8 || Confirm !== password} />
      </form>
      <Display FName={FName} LName={LName} email={email} password={password} Confirm={Confirm}/>
    </>
  );
};

  export default UserForm;

