/**
 * Aplicación Node.js Express
 * Gestión academica
 */
const express = require("express");
const session = require("express-session");
const mysql = require("mysql2");
const bodyParser = require("body-parser");
const path = require("path");

const app = express();
const port = 8000;

// Indica a express que el motor de vistas es pug
app.set("view engine", "pug");
/*
 * Indica en que carpeta se guardan las vistas, si es "views" no hace falta esta linea
 * pero si es otra carpeta si haría falta
 */
app.set("views", path.join(__dirname, "views"));

// Iniciamos la aplicación en el puerto designado
app.listen(port, () => {
  console.log(`Servidor iniciado en http://localhost:${port}`);
});

// req y res son dos parametros preestablecidos que corresponden a request y response
app.get("/", (req, res) => {
  //res.send("Hola mundo");

  // Renderiza el archivo test.pug de la carpeta views o la indicada anteriormente
  res.render("test");
});

app.get("/hola", (req, res) => {
  const { nombre, apellido } = req.query;
  res.send(`Hola ${nombre} ${apellido}`);
});

app.post("/hola", (req, res) => {
  res.send(`Hola desde un post`);
});

app.post("/destino", (req, res) => {
    console.log(req);
    res.render("saluda", req.body);;
});
