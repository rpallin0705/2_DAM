package com.iesvdc.acceso.inventario.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.iesvdc.acceso.inventario.conexion.Conexion;
import com.iesvdc.acceso.inventario.dao.IncidenciaDao;
import com.iesvdc.acceso.inventario.modelo.Estancia;
import com.iesvdc.acceso.inventario.modelo.Incidencia;
import com.iesvdc.acceso.inventario.modelo.Inventario;
import com.iesvdc.acceso.inventario.modelo.Usuario;

public class IncidenciaDaoImp implements IncidenciaDao {

    @Override
    public boolean create(Incidencia i) {
        boolean result = true;
        Conexion con = new Conexion();
        Connection connection = con.getConnection();
        String sql = "Insert Into " +
                "incidencia (asunto, descripcion, inventario, usuario, operario) " +
                "Values(?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, i.getAsunto());
            ps.setString(2, i.getDescripcion());
            ps.setInt(3, i.getInventario().getId());
            ps.setInt(4, i.getUsuario().getId());
            ps.setInt(5, i.getOperario().getId());

            result = (ps.executeUpdate(sql) > 0);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        con.destroy();
        return result;
    }

    @Override
    public Incidencia findById(int id) {
        Conexion conexion = new Conexion();
        Incidencia result = null;
        String sql = "SELECT asunto, descripcion, inventario, usuario, operario from `incidencia` WHERE `id`= ?;";
        Connection con = conexion.getConnection();
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                UsuarioDaoImp uDI = new UsuarioDaoImp();

                Usuario usuario = uDI.findById(rs.getInt("usuario"));
                Usuario operario = uDI.findById(rs.getInt("operario"));

                result = new Incidencia(
                        id,
                        rs.getString("asunto"),
                        rs.getString("descripcion"),
                        new Inventario(),
                        usuario,
                        operario);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        conexion.destroy();
        return result;
    }

    @Override
    public Incidencia findByNombre(String nombre) {
        Conexion conexion = new Conexion();
        Incidencia result = null;
        String sql = "SELECT i.id, i.asunto, i.descripcion, i.inventario, i.usuario, i.operario, u.nombre " +
                "from `incidencia` i, 'usuario' u " +
                "WHERE `u.nombre`= ?;";
        Connection con = conexion.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                UsuarioDaoImp uDI = new UsuarioDaoImp();

                Usuario usuario = uDI.findById(rs.getInt("usuario"));
                Usuario operario = uDI.findById(rs.getInt("operario"));

                result = new Incidencia(
                        rs.getInt("id"),
                        rs.getString("asunto"),
                        rs.getString("descripcion"),
                        new Inventario(),
                        usuario,
                        operario);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        conexion.destroy();
        return result;
    }

    @Override
    public Incidencia findByEstancia(Estancia e) {
        Conexion conexion = new Conexion();
        Incidencia result = null;
        String sql = "SELECT i.id, i.asunto, i.descripcion, i.inventario, i.usuario, i.operario, u.nombre " +
                "from `incidencia` i, 'usuario' u " +
                "WHERE `u.nombre`= ?;";
        Connection con = conexion.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, e.getNombre());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                UsuarioDaoImp uDI = new UsuarioDaoImp();

                Usuario usuario = uDI.findById(rs.getInt("usuario"));
                Usuario operario = uDI.findById(rs.getInt("operario"));

                result = new Incidencia(
                        rs.getInt("id"),
                        rs.getString("asunto"),
                        rs.getString("descripcion"),
                        new Inventario(),
                        usuario,
                        operario);
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }

        conexion.destroy();
        return result;
    }

    @Override
    public Incidencia findByOperario(Usuario o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByOperario'");
    }

    @Override
    public Incidencia findByUsuario(Usuario u) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByUsuario'");
    }

    @Override
    public boolean update(Incidencia o, Incidencia n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean update(int id, Incidencia n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Incidencia i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Incidencia> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public int count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

}
