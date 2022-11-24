import React, { useState, useEffect } from 'react';
import './App.css';
import Form from './Component/Index';
import Tasks from './Component/Tasks';

function App() {
  const [tasks, setTasks] = useState([]);
  return (
    <>
      <Form tasks={tasks} setTasks={setTasks}></Form>
      <ul>
        {tasks.map((task, idx) => {
          return (<li key={idx}><Tasks value={idx} task={task} tasks={tasks} setTasks={setTasks}></Tasks></li>);
        })}
      </ul>
    </>
  );
};

export default App;