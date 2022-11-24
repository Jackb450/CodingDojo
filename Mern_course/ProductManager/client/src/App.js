import React from 'react';
import {Routes, Route} from 'react-router-dom';
import Main from './views/Main';
import ProductDetails from './components/ProductDetails'
import Edit from './components/editProduct';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route element={<Main/>} path="/product"/>
        <Route element={<ProductDetails/>} path="/product/:id"/>
        <Route element={<Edit/>} path="/product/edit/:id"/>
      </Routes>
    </div>
  );
}
export default App;