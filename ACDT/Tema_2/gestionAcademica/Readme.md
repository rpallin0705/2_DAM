# Gestión académica

Inicializamos la BBDD y el contenedor Docker

```bash
npm install --save express express-session mysql2 pub body-parser
```

* **express**: Servidor web para NodeJs
* **express-session**: gestiona sesiones HTTP entre cliente y servidor
* **mysql2**: driver para conectar a mysql
* **pub**: motor HTML
* **body-parser**: para convertir los datos de un formulario (POST y GET) a JSON
  
Inicicializamos el repositorio

```bash
git init
git add .
git commit -m "Primer commit"
```

Constantes para el servidor node

```JavaScript
const express = require('express');
const session = require('express-session');
const mysql = require('mysql2');
const bodyParser = require('body-parser');
const path = require('path');

const app = express();
const port = 8000;
```

Iniciar servidor

```JavaScript
app.listen(port, () => {
    console.log(`Servidor iniciado en http://localhost:${port}`);
})
```

Comprobación

```JavaScript
app.get('/hola', (req, res) =>{
    res.send('Hola mundo');
})
```

### CRUD ALUMNOS
VERBO | RUTA | DESCRIPCION
------|------|------------
GET | /alumnos | Obtiene el listado de alumnos