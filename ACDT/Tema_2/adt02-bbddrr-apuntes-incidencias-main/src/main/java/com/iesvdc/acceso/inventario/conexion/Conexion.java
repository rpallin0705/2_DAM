/*
 */
package com.iesvdc.acceso.inventario.conexion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 *
 * @author juangu
 */
public class Conexion {

    Connection conn;
    Properties prop;

    /**
     * 
     */
    public Conexion() {
        // Vía JDBC
        if (conn == null) {
            try (FileInputStream fis = new FileInputStream("db.properties")) {
                prop = new Properties();
                prop.load(fis);
                this.conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:33306/inventario",
                        prop);
            } catch (ClassCastException | IOException e) {
                Logger.getLogger(Conexion.class.getName()).severe(e.getLocalizedMessage());
            } catch (SQLException sqle) {
                System.out.println(sqle.getErrorCode());
            }
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void destroy() {
        if (this.conn != null) {
            try {
                this.conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean createDatabase() {
        boolean solucion = true;
        try (FileInputStream fis = new FileInputStream("db.properties")) {

            prop = new Properties();
            prop.load(fis);
            this.conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:33306/inventario",
                    prop);
            String sql = "CREATE DATABASE IF NOT EXISTS inventario";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (FileNotFoundException e) {
            solucion = false;
            System.out.println("NO SE PUDO ENCONTRAR EL ARCHIVO DB.PROPERTIES");
            e.printStackTrace();
        } catch (SQLException sqe) {
            System.out.println("NO SE PUDO CONECTAR CON LA BASE DE DATOS");
            sqe.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("PROBLEMA CON LA LECTURA DEL FICHERO");
            ioe.printStackTrace();
        }
        return solucion;
    }

    public boolean dropDatabase() {
        boolean solucion = true;
        try {
            String sql = "DROP DATABASE `inventario`";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            solucion = false;
        }
        return solucion;
    }

    public void leerArchivoDatabase() {
        File file = new File("src\\main\\sql\\database.sql");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            StringBuilder comando = new StringBuilder();
            String comandoFormado = "";

            while ((line = br.readLine()) != null) {

                if (line.startsWith("--") || line.isEmpty())
                    continue;

                comando.append(line);

                if (line.endsWith(";")) {
                    comandoFormado = comando.toString();

                    executeCommand(comandoFormado);

                    comando.delete(0, comando.length());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private void executeCommand(String comandoFormado) {
        try (PreparedStatement ps = this.conn.prepareStatement(comandoFormado);) {
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
