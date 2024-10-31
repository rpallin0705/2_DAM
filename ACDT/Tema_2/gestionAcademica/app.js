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
  host: "localhost",
  port: 33307,
  user: "root",
  password: "zx76wbz7FG89k",
  database: "gestion",
});

// Conexión a MySQL
db.connect((err) => {
  if (err) {
    console.error("Error al conectar a MySQL:", err);
    return;
  }
  console.log("Conexión exitosa a MySQL");
});

// req y res son dos parametros preestablecidos que corresponden a request y response
app.get("/", (req, res) => {
  res.render("index");
});

app.get("/alumnos", (req, res) => {
  db.query("Select * from `alumno`", (err, result) => {
    if (err) res.send("Error al hacer la consulta");
    else res.render("alumnos/alumnos", { alumnos: result });
  });
});

app.get("/alumnos/add", (req, res) => {
  res.render("alumnos/add");
});

app.post("/alumnos/add", (req, res) => {
  const { nombre, apellido } = req.body;
  db.query(
    "Insert Into alumno (nombre, apellido) Values (?,?)",
    [nombre, apellido],
    (error, result) => {
      if (error) res.send("ERROR INSERTANDO ALUMNOS");
      else res.redirect("/alumnos");
    }
  );
});

// Borrar

app.get("/alumnos/del/:id", (req, res) => {
  const { id } = req.params['id'];
  if (isNaN(id)) res.send("PARAMETROS INCORRECTOS");
  else {
    db.query("Select * From alumno Where id=?", id, (error, result) => {
      if (error) res.send("ERROR AL BORRAR");
      else if (result.length > 0) {
        res.render("alumnos/del", { alumnos: result[0] });
      } else {
        res.send("ERROR AL BORRAR EL ALUMNO, NO EXISTE");
      }
    });

    res.render("alumnos/del");
  }
});

app.post("/alumnos/del/:id", (req, res) => {
  const { id, nombre, apellido } = req.body;

  const { param } = req.params["id"];

  if (isNaN(id) || isNaN(param) || id !== param) {
    res.send('ERROS BORRANDO')
  } else {
    db.query(
      "Insert Into alumno (nombre, apellido) Values (?,?)",
      [nombre, apellido],
      (error, result) => {
        if (error) res.send("ERROR INSERTANDO ALUMNOS");
        else res.redirect("/alumnos");
      }
    );
  }
});

// Editar
app.get("/alumnos/edit/:id", (req, res) => {
  const { id } = req.params;
  if (isNaN(id)) res.send("PARAMETROS INCORRECTOS");
  else {
    db.query("Select * From alumno Where id=?", id, (error, result) => {
      if (error) res.send("ERROR AL ACTUALIZAR");
      else if (result.length > 0) {
        res.render("alumnos/del", { alumnos: result[0] });
      } else {
        res.send("ERROR AL ACTUALIZAR EL ALUMNO, NO EXISTE");
      }
    });

    res.render("alumnos/del");
  }
});

app.post("/alumnos/edit/:id", (req, res) => {
  const { id, nombre, apellido } = req.body;

  const { param } = req.params["id"];

  if (isNaN(id) || isNaN(param) || id !== param) {
    res.send('ERROR ACTUALIZANDO')
  } else {
    db.query(
      "Update alumno Set nombre = ?, apellido = ? Where id = ?",
      [nombre, apellido, id],
      (error, result) => {
        if (error) res.send("ERROR ACTUALIZANDO ALUMNOS");
        else res.redirect("/alumnos");
      }
    );
  }
});