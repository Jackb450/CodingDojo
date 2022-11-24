import React, {useEffect, useState} from 'react'
import axios from 'axios';
import {useParams, Link} from "react-router-dom";

const ProductDetails = (props) => {
    const [product, setProduct] = useState({})
    const {id} = useParams();
    
    useEffect(() => {
        axios.get('http://localhost:8000/api/product/' +id)
        .then(res => setProduct(res.data))
        .catch(err => console.error(err));
    })
    
    return (
        <div>
            <p>Title: {product.title}</p>
            <p>Price: ${product.price}</p>
            <p>Description: {product.description}</p>
            <Link to={"/product/edit/" +product._id}>Edit</Link>
        </div>
    )
}
    
export default ProductDetails;

