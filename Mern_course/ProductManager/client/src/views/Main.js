import React, {useEffect, useState} from 'react';
import axios from 'axios';
import ProductForm from '../components/productForm';
import ProductList from '../components/productList';


const Main = (props) => {
    const [product, setProduct] = useState([]); 
    useEffect(()=>{
        axios.get('http://localhost:8000/api/product')
        .then(res=>{
            setProduct(res.data);
        })
        .catch(err => console.error(err))
    })

    const removeFromDom = productId => {
        setProduct(product.filter(product => product._id != productId));
    }
    return (
        <div>
            <h1>Product Manager</h1>
           <ProductForm/>
           <hr/>
           <ProductList product={product} removeFromDom={removeFromDom}/>
        </div>
    )
}

export default Main;