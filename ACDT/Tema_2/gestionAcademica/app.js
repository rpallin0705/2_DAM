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
app.use(bodyParser.urlencoded({ extended: true }));

// Iniciamos la aplicación en el puerto designado
app.listen(port, () => {
  console.log(`Servidor iniciado en http://localhost:${port}`);
});

const db = mysql.createConnection({
  host: 'localhost',
  port: 33307,
  user: 'root',
  password: 'zx76wbz7FG89k',
  database: 'gestion',
});

// Conexión a MySQL
db.connect(err => {
  if (err) {
    console.error('Error al conectar a MySQL:', err);
    return;
  }
  console.log('Conexión exitosa a MySQL');
});

// req y res son dos parametros preestablecidos que corresponden a request y response
app.get("/", (req, res) => {
  res.render("index")
});

app.get("/alumnos", () => {
  db.query(
    'Select * from `alumnos`',
    (err, result) => {
      if (err) res.send("Error al hacer la consulta")
      else res.render('alumnos', {alumnos: result})
    }
  )
});