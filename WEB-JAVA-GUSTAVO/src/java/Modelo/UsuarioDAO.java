/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DesarrolloWeb
 */
public class UsuarioDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public void agregar(Usuario c) {

        String sql = "insert into usuarios(nombre,apellido,dni,Profesor/Alumnos,sexo,telefono,mail,edad,contraseña)values(?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getApellido());
            ps.setString(4, Integer.toString(c.getDni()));
            ps.setString(5, c.isProfAlum());
            ps.setString(6, c.getSexo());
            ps.setString(7, Integer.toString(c.getTelefono()));
            ps.setString(8, c.getMail());
            ps.setString(9, Integer.toString(c.getEdad()));
            ps.setString(10, c.getContraseña());

            ps.executeUpdate();
        } catch (Exception e) {
        }

    }

    public List listar() {
        String sql = "select * from usuarios";
        List<Usuario> resultados = new ArrayList<>();
  

        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setapellido(rs.getString(3));
                u.setDni(rs.getInt(4));
                u.setProfAlum(rs.getString(5));
                u.setSexo(rs.getString(6));
                u.setTelefono(rs.getInt(7));
                u.setMail(rs.getString(8));
                u.setEdad(rs.getInt(9));
                u.setContraseña(rs.getString(10));
                u.setUsuario(rs.getString(11));
                resultados.add(u);
            }
        } catch (Exception e) {
        }
        return resultados;
    }

    public Usuario listarId(int id) {
        Usuario emp = new Usuario();
        String sql = "select * from empleado where IdEmpleado =" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                emp.setId(rs.getInt(1));
                emp.setNombre(rs.getString(2));
                emp.setapellido(rs.getString(3));
                emp.setDni(rs.getInt(4));
                emp.setProfAlum(rs.getString(5));
                emp.setSexo(rs.getString(6));
                emp.setTelefono(rs.getInt(7));
                emp.setMail(rs.getString(8));
                emp.setEdad(rs.getInt(9));
                emp.setContraseña(rs.getString(10));
                emp.setUsuario(rs.getString(11));
            }
        } catch (Exception e) {
        }
        return emp;
    }

    public int actualizar(Usuario em) {
        String sql = "update usuarios(nombre,apellido,dni,Profesor/Alumnos,sexo,telefono,mail,edad,contraseña)values(?,?,?,?,?,?,?,?,?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            em.setId(rs.getInt(1));
            em.setNombre(rs.getString(2));
            em.setapellido(rs.getString(3));
            em.setDni(rs.getInt(4));
            em.setProfAlum(rs.getString(5));
            em.setSexo(rs.getString(6));
            em.setTelefono(rs.getInt(7));
            em.setMail(rs.getString(8));
            em.setEdad(rs.getInt(10));

            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public void delete(int id) {
        String sql
                = "delete from Usuarios where IdEmpleado =" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }
    
   public Usuario validar(String nombreUsuario, String PassUsuario) {
        String sql = "select * from usuarios where usuario='" + nombreUsuario + "' and contraseña='" + PassUsuario + "'";
        Usuario usuario;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                usuario =new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setapellido(rs.getString(3));
                usuario.setDni(rs.getInt(4));
                usuario.setProfAlum(rs.getString(5));
                usuario.setSexo(rs.getString(6));
                usuario.setTelefono(rs.getInt(7));
                usuario.setMail(rs.getString(8));
                usuario.setEdad(rs.getInt(9));
                usuario.setContraseña(rs.getString(10));
               usuario.setUsuario(rs.getString(11));
            return usuario;
            }

        } catch (SQLException ex) {

            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
 
    
    
    
    
}
