const express = require('express');
const router = express.Router();
const asignaturaController = require('../controllers/asignaturaController');


router.get('/', asignaturaController.asignaturas);

router.get('/add', asignaturaController.asignaturaAddFormulario);
router.post('/add', asignaturaController.asignaturaAdd);

router.get('/del/:id', asignaturaController.asignaturaDelFormulario);
router.post('/del/:id', asignaturaController.asignaturaDel);

router.get('/edit/:id', asignaturaController.asignaturaEditFormulario);
router.post('/edit/:id', asignaturaController.asignaturaEdit);

// Listar los alumnos matriculados de esa asignatura
router.get('/:id/matriculas', asignaturaController.matriculas);
// Formulario para matricular un alumno de una asignatura
router.get('/:id/matriculas/add', asignaturaController.matriculaAddFormulario);
// Matricula un alumno de una asignatura con ID
router.post('/:id/matriculas/add', asignaturaController.matriculaAdd);
// Formulario para desmatricular un alumno de una asignatura con ese ID
router.get('/:id/matriculas/del', asignaturaController.matriculaDelFormulario);
// Desmatricula un alumno de esa asignatura con ese ID
router.post('/:id/matriculas/del', asignaturaController.matriculaDel);


module.exports = router;
