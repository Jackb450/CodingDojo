import React from "react";
import '../App.css'

const Display = (props) => {
    return (
        <div>
            <h1>Info</h1>
            <p>First Name: {props.FName}</p>
            <p>Last Name: {props.LName}</p>
            <p>Email: {props.email}</p>
            <p>Password: {props.password}</p>
            <p>Confirm Password: {props.Confirm}</p>
        </div>
    )
}

export default Display;