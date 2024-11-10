require("dotenv").config({ path: "./gesaca/.env" });
const mysql = require("mysql2");

// conexion a base de datos
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

// Exportar módulo para usarlos en cuaquier parte del proyect
module.exports = db