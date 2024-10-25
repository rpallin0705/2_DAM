/**
 * Aplicación Node.js Express
 * Gestión academica
 */
const express = require('express');
const session = require('express-session');
const mysql = require('mysql2');
const bodyParser = require('body-parser');
const path = require('path');

const app = express();
const port = 8000;

// Iniciamos la aplicación en el puerto designado
app.listen(port, () => {
    console.log(`Servidor iniciado en http://localhost:${port}`);
})

// req y res son dos parametros preestablecidos que corresponden a request y response
app.get('/hola', (req, res) =>{
    res.send('Hola mundo');
})