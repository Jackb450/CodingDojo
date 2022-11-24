import './App.css';
import Person from './Component/People';
import Index from './Component/Index';
import Planet from './Component/Planet';
import Error from './Component/Error';
import {Routes, Route} from "react-router-dom"

function App() {
  return (
    <div className="App">
      <h1>TV show-walker</h1>
      <Index/>
      <Routes>
        <Route path="/" element={null}/>
        <Route path="*" element={<Error/>}/>
        <Route path="/people/:id" element={<Person/>}/>
        <Route path="/planet/:id" element={<Planet/>}/>
      </Routes>
    </div>
  );
}

export default App;