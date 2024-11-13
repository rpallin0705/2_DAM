package com.iesvdc.acceso.app.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.iesvdc.acceso.app.db.Conexion;
import com.iesvdc.acceso.app.model.Vehiculo;
import com.iesvdc.acceso.app.repository.VehiculoRepository;

public class VehiculoService implements VehiculoRepository {

    private static final String SAVE_QUERY = "INSERT INTO Vehiculo (Marca, Modelo, Anio, Precio, Combustible) VALUES (?, ?, ?, ?, ?)";
    private static final String FIND_ALL_QUERY = "SELECT * FROM Vehiculo";

    private Connection conn;

    public VehiculoService() {
        this.conn = Conexion.getConnection();
    }

    @Override
    public Vehiculo save(Vehiculo vehiculo) {
        String query = "INSERT INTO Vehiculo (Marca, Modelo, Anio, Precio, Combustible) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            // Asignamos los parámetros del PreparedStatement con los datos del objeto vehiculo
            ps.setString(1, vehiculo.getMarca());
            ps.setString(2, vehiculo.getModelo());
            ps.setInt(3, vehiculo.getAnio());
            ps.setDouble(4, vehiculo.getPrecio());
            ps.setString(5, vehiculo.getCombustible());
    
            // Ejecutamos la consulta
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                // Si se insertó al menos una fila, obtenemos el ID generado
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        vehiculo.setIdVehiculo(generatedKeys.getInt(1));
                    }
                }
                System.out.println("Se insertaron " + rowsAffected + " filas.");
            } else {
                System.out.println("No se insertó ningún vehículo.");
            }
    
            // Retornamos el vehículo guardado con el ID asignado
            return vehiculo;
    
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    

    @Override
    public List<Vehiculo> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}
