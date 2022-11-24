const productController = require('../controllers/product.controller');

module.exports = function(app){
    app.post('/api/product', productController.createProduct);
    app.get('/api/product', productController.getAllProducts);
    app.get('/api/product/:id', productController.getOneProduct);
    app.put('/api/product/:id', productController.updateProduct);
    app.delete('/api/product/:id', productController.deleteProduct);
}