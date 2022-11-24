import React, {useState, useEffect} from "react";
import {useParams, useNavigate} from "react-router-dom";
import axios from "axios"

const Person = () => {
    const [person, setPerson] = useState("");
    const {id} = useParams()
    const navi = useNavigate();

    useEffect(()=>{
        axios.get(`https://swapi.dev/api/people/${id}`)
        .then(response=> setPerson(response.data))
        .catch(err=>navi('/error'))
    })
    return (
        <fieldset>
            <legend>People.jsx</legend>
            <div>
                <h2>{person.name} </h2> <br />
                Height: {person.height}cm <br />
                Weight: {person.mass}kg <br />
                Hair Color: {person.hair_color} <br />
                Skin Color: {person.skin_color} <br />
            </div>
        </fieldset>
    )
}

export default Person