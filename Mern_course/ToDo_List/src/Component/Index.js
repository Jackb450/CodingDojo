import React, { useState, useEffect } from 'react';

const Form = (props) => {
    const {tasks, setTasks} = props;
    const [input, setInput] = useState({ text: '' });
    const typing = (event) => {
        setInput({ ...input, text: event.target.value });
    }
    const handleSubmit = (event) => {
        event.preventDefault();
        setTasks([...tasks, { task: input.text, completed: false }]);
        setInput({ ...input, text: "" });
    }
    return (
        <>
            <form onSubmit={handleSubmit}>
                <label htmlFor="task">Add a task here:</label>
                <input type="text" name="task" id="task" onChange={typing} value={input.text} />
                <button>Add Task</button>
            </form>
        </>
    );
}

export default Form;