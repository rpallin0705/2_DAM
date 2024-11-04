/**
 * Aplicación Node.js Express
 * Gestión academica
 */
const express = require("express");
const session = require("express-session");
const mysql = require("mysql2");
const bodyParser = require("body-parser");
const path = require("path");

const alumnoRouter = require('./routes/alumnoRoutes')

// Crear el servidor web
const app = express();
const port = process.env.SERVICE_PORT || 8000;

require('dotenv').config({path: './gesaca/.env'})

// Indica a express que el motor de vistas es pug
app.set("view engine", "pug");
/*
 * Indica en que carpeta se guardan las vistas, si es "views" no hace falta esta linea
 * pero si es otra carpeta si haría falta
 */
app.set("views", path.join(__dirname, "views"));
app.use(bodyParser.urlencoded({ extended: true }));

// 
app.use('/alumnos')

// Iniciamos la aplicación en el puerto designado
app.listen(port, () => {
  console.log(`Servidor iniciado en http://localhost:${port}`);
});

// req y res son dos parametros preestablecidos que corresponden a request y response
app.get("/", (req, res) => {
  res.render("index");
});