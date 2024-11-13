package com.iesvdc.acceso.app.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {

    private static Connection conn;

    private Conexion() {
    }

    public static Connection getConnection() {
        conn = null;

        try (FileInputStream input = new FileInputStream("database.properties")) {

            Properties prop = new Properties();

            prop.load(input);

            conn = DriverManager.getConnection(
                    prop.getProperty("db.url"),
                    prop.getProperty("db.username"),
                    prop.getProperty("db.password"));

        } catch (FileNotFoundException fnfe) {
            System.out.println("No se pudo encontrar el archivo database.properties");
        } catch (IOException ioe) {
            System.out.println("Hubo un error de E/S");
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }

        System.out.println("Conexion con la base de datos establecida");

        return conn;
    }

    public static void destroy() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
