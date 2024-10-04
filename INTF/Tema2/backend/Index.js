// Crea una variable express
const express = require('express');

// Crea una variable app en la que se ejecutará la api
const app = express();
const port = 3000;

app.get('/', (req, res) => {
    res.send("hola mundo");
})

app.listen(3000, () => {
    console.log(`Listening on http://localhost:${port}`);
})