/**
 * Aplicación full-stack gestión académica.
 */

const express = require('express');
const session = require('express-session');
const mysql = require('mysql2');
const bodyParser = require('body-parser');
const path = require('path');

// Carpeta de contenido estático
//app.use(express.static('public'))

const alumnoRouter = require('./routes/alumnoRouter');
const asignaturaRouter = require('./routes/asignaturaRouter');

require('dotenv').config({ path: './gesaca/.env' });

/**
 * Crea el servidor Web
 */
const app = express();
const port = 8000;
;
/**
 * Configuramos el motor de plantillas 
 * 
 */
app.set('view engine', 'pug');
app.set('views', path.join(__dirname, 'views'));
app.use(bodyParser.urlencoded({ extended: true }));

/**
 * Delegamos todas las rutas que comienzan por alumnos, asignaturas, etc.
 * al enrutador correspondiente
 */
app.use('/alumnos', alumnoRouter);
app.use('/asignaturas', asignaturaRouter);

app.get('/', (req, res) => {
    res.render('index')
});



/**
 * Siempre lo último que hacemos
 */
app.listen(
    port, () => {
        console.log(`Servidor iniciado en http://localhost:${port}`);
    });
