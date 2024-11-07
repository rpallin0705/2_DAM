const express = require('express');
const router = express.Router();
const alumnoController = require('../controllers/alumnoController');


router.get('/', alumnoController.alumnos);

router.get('/add', alumnoController.alumnoAddFormulario);

router.post('/add', alumnoController.alumnoAdd);

router.get('/del/:id', alumnoController.alumnoDelFormulario);

router.post('/del/:id', alumnoController.alumnoDel);

router.get('/edit/:id', alumnoController.alumnoEditFormulario);

router.post('/edit/:id', alumnoController.alumnoEdit);

module.exports = router;