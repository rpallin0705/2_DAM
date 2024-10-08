# PROGRAMACION DE BASES DE DATOS REALCIONALES

## Martes 8 de octubre

`ResultSet` -> Iterable para almacenar datos de una consulta a la base de datos

```Java
public List<Producto> obtenerProductos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT id, nombre, precio FROM productos";
        try (Connection conn = obtenerConexion();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");

                Producto producto = new Producto(id, nombre, precio);
                productos.add(producto);
            }
        }
    }
```

`Conectores` -> una librería del lenguaje para facilitar la conexion a la base de datos, p.ej: jdbc:driver:host:puerto/basededatos

