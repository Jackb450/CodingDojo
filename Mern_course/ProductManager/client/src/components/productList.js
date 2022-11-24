import React from 'react'
import axios from 'axios';
    
const productList = (props) => {
    const {removeFromDom} = props;
    
    const deleteProduct = (productId) => {
        axios.delete('http://localhost:8000/api/product/' +productId)
            .then(res => {removeFromDom(productId)})
            .catch(err => console.error(err));
    }

    return (
        <>
        <h1>All Products:</h1>
        <div>
            {props.product.map((product, i) =>
                <><p><a key={i} href={'/product/' + product._id}>{product.title}</a></p>
                <button onClick={(e) => { deleteProduct(product._id); } }>Delete</button></>
            )}
        </div>
        </>
    )
}

export default productList;