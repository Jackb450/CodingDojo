import React, {useState, useEffect} from "react";
import {useParams, useNavigate} from "react-router-dom";
import axios from "axios"

const Planet = () => {
    const [planet, setPlanet] = useState("");
    const {id} = useParams()
    const navi = useNavigate();

    useEffect(()=>{
        axios.get(`https://swapi.dev/api/planets/${id}`)
        .then(response=> setPlanet(response.data))
        .catch(err=>navi('/error'))
    })
    return (
        <fieldset>
            <legend>Planet.jsx</legend>
            <div>
                <h2>{planet.name}</h2>
                Climate: {planet.climate} <br />
                Terrain: {planet.terrain} <br />
                Surface water: {planet.surface_water} <br />
                Population: {planet.population}
            </div>
        </fieldset>
    )
}

export default Planet