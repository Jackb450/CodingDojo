import React, {useState} from "react";
import {useNavigate} from "react-router-dom";

const Index = () => {
    const [id, setId] = useState("");
    const [cat, setCat] = useState("");
    const navi = useNavigate();

    const Choose = (e) => {
        e.preventDefault()
        navi(`/${cat}/${id}`)
        Empty()
    }

    const Empty = () => {
        setId("");
        setCat("");
    }
    return (
        <fieldset>
            <legend>Index.jsx</legend>
            <form onSubmit={Choose}>
                Search for:
                <select name="category" onChange={e=>setCat(e.target.value)} value={cat}>
                    <option hidden>Category</option>
                    <option value="people">People</option>
                    <option value="planet">Planet</option>
                </select>
                <input type="text" name="id" value={id} onChange={e=>setId(e.target.value)}/>
                <button type="submit">Go!</button>
            </form>
        </fieldset>
    )
}

export default Index