const express = require('express')
const db = require('../db');



exports.listarAlumnos = (req, res) => {
  db.query("Select * from `alumno`", (err, result) => {
    if (err) res.send("Error al hacer la consulta");
    else res.render("alumnos/alumnos", { alumnos: result });
  });
};

exports.alumnoAdd = (req, res) => {
  res.render("alumnos/add");
}

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
  const { id } = req.params.id;
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
    res.send("ERROS BORRANDO");
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
    res.send("ERROR ACTUALIZANDO");
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
