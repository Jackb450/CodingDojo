const express = require('express');
const cors = require('cors')
const app = express();
require('./server/config/mongoose.config');
app.use(cors())
const port = 8000;
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
require('./server/route/person.route')(app);

app.listen(port, () => console.log(`Server in Action on: ${port}!`) );
