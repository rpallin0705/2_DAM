require("dotenv").config({ path: "./gesaca/.env" });
const mysql = require("mysql2");

// conexion a base de datos
const db = mysql.createConnection({
  host: process.env.MYSQL_HOST || "localhost",
  port: process.env.MYSQL_PORT || 33307,
  user: process.env.MYSQL_USERNAME || root,
  password: process.env.MYSQL_PASSWORD,
  database: process.env.MYSQL_DATABASE,
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