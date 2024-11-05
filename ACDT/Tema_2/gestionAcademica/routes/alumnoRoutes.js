const express = require('express')
const router = express.Router()     // Enrutador de express

const alumnosController = require('../controllers/alumnoController')




router.get("/", alumnosController.listarAlumnos);

router.get("/add", alumnosController.alumnoAdded); 

router.post("/add", (req, res) => {
  
});

// Borrar

router.delete("/alumnos/del/:id",alumnosController.deleteAlumno);

router.post("/del/:id", (req, res) => {
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
        else res.redirect("");
      }
    );
  }
});

// Editar
router.get("/edit/:id", (req, res) => {
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

router.post("/edit/:id", (req, res) => {
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
        else res.redirect("");
      }
    );
  }
});

module.exports = alumnoController