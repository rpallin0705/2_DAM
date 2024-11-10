const db = require('../db')

exports.alumnos = (req, res) => {
  db.query(
    'SELECT * FROM `alumno`',
    (err, response) => {
      if (err) res.send('ERROR al hacer la consulta')
      else res.render('alumnos/list', { alumnos: response })
    }
  );
};

exports.alumnoAddFormulario = (req, res) => {
  res.render('alumnos/add');
};

exports.alumnoAdd = (req, res) => {
  const { nombre, apellido } = req.body;
  db.query(
    'INSERT INTO alumno (nombre, apellido) VALUES (?,?)',
    [nombre, apellido],
    (error, respuesta) => {
      if (error) res.send('ERROR INSERTANDO ALUMNO' + req.body)
      else res.redirect('/alumnos')
    }
  );
};

exports.alumnoDelFormulario = (req, res) => {
  const { id } = req.params;
  if (isNaN(id)) res.send('PARAMETROS INCORRECTOS')
  else
    db.query(
      'SELECT * FROM alumno WHERE id=?',
      id,
      (error, respuesta) => {
        if (error) res.send('ERROR al INTENTAR BORRAR EL ALUMNO')
        else {
          if (respuesta.length > 0) {
            res.render('alumnos/del', { alumno: respuesta[0] })
          } else {
            res.send('ERROR al INTENTAR BORRAR EL ALUMNO, NO EXISTE')
          }
        }
      });

};

exports.alumnoDel = (req, res) => {

  const { id, nombre, apellido } = req.body;
  const paramId = req.params['id'];

  if (isNaN(id) || isNaN(paramId) || id !== paramId) {
    res.send('ERROR BORRANDO')
  } else {
    db.query(
      'DELETE FROM alumno WHERE id=?',
      id,
      (error, respuesta) => {
        if (error) res.send('ERROR BORRANDO ALUMNO' + req.body)
        else res.redirect('/alumnos')
      }
    );
  }
};

exports.alumnoEditFormulario = (req, res) => {
  const { id } = req.params;
  if (isNaN(id)) res.send('PARAMETROS INCORRECTOS')
  else
    db.query(
      'SELECT * FROM alumno WHERE id=?',
      id,
      (error, respuesta) => {
        if (error) res.send('ERROR al INTENTAR ACTUALIZAR EL ALUMNO')
        else {
          if (respuesta.length > 0) {
            res.render('alumnos/edit', { alumno: respuesta[0] })
          } else {
            res.send('ERROR al INTENTAR ACTUALIZAR EL ALUMNO, NO EXISTE')
          }
        }
      });
};

exports.alumnoEdit = (req, res) => {

  const { id, nombre, apellido } = req.body;
  const paramId = req.params['id'];

  if (isNaN(id) || isNaN(paramId) || id !== paramId) {
    res.send('ERROR ACTUALIZANDO')
  } else {
    db.query(
      'UPDATE `alumno` SET `nombre` = ?, `apellido` = ? ' +
      ' WHERE `id` = ?',
      [nombre, apellido, id],
      (error, respuesta) => {
        if (error) {
          res.send('ERROR ACTUALIZANDO ALUMNO' + error)
          console.log(error)
        }
        else res.redirect('/alumnos')
      }
    );
  }
};