const Product = require("../models/product.model");

module.exports = {
    createProduct: function(req, res){
        console.log("Create Product");
        Product.create(req.body)
        .then(product => res.json(product))
        .catch(err => res.json(err));
    },
    getAllProducts(req, res){
        console.log("All Products");
        Product.find()
        .then(product => res.json(product))
        .catch(err => res.json(err));
    },
    getOneProduct(req, res){
        console.log("product Details");
        Product.findOne({_id:req.params.id})
        .then(product => res.json(product))
        .catch(err => res.json(err));
    },
    updateProduct(req, res){
        console.log("Update Product");
        Product.findByIdAndUpdate({_id:req.params.id})
        .then(product => res.json(product))
        .catch(err => res.json(err));
    },
    deleteProduct(req, res){
        console.log("Delete Product");
        Product.findByIdAndDelete({_id:req.params.id})
        .then(product => res.json(product))
        .catch(err => res.json(err));
    }
}
