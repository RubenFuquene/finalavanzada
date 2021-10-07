/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.DAO;

import datos.conexion.GestorConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.entidades.Empleado;
import negocio.logica.GestorGlobal;

/**
 *
 * @author Rubén
 */
public class EmpleadoDAO
{
    private String consultaSQL;
    private Connection conexionLocal;
    private PreparedStatement sentenciaAPreparar;
    
    public void iniciarSesion(GestorGlobal sesion)
    {
        ResultSet respuesta;
        
        try
        {
            consultaSQL = "SELECT id, nombre, apellido";
            consultaSQL += " FROM empleados";
            consultaSQL += " WHERE usuario = ? AND password = md5(?)";
            
            conexionLocal = GestorConexionBD.obtenerInstancia().tomarConexion();

            sentenciaAPreparar = conexionLocal.prepareStatement(consultaSQL);
            
            sentenciaAPreparar.setString(1, sesion.getEmpleadoAsociadoSesion().getUsuario());
            sentenciaAPreparar.setString(2, sesion.getEmpleadoAsociadoSesion().getPassword());
            
            respuesta = sentenciaAPreparar.executeQuery();
            
            if(respuesta.next())
            {
                sesion.getEmpleadoAsociadoSesion().setIdentificador(respuesta.getInt("id"));
                sesion.getEmpleadoAsociadoSesion().setNombre(respuesta.getString("nombre"));
                sesion.getEmpleadoAsociadoSesion().setApellido(respuesta.getString("apellido"));
                sesion.setSesionIniciada(true);
            }else
            {
                sesion.setSesionIniciada(false);
            }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
            sesion.setSesionIniciada(false);
            //throw new Exception("No se pudo comprobar el inicio de sesion en " + this.getClass().toString());
        }finally
        {
            GestorConexionBD.obtenerInstancia().dejarConexion();
        }
    }
    
    public boolean crearEmpleado(Empleado empleadoNuevo)
    {
        boolean resultado = false;
                
        try
        {
            consultaSQL = "INSERT INTO empleados (nombre, apellido, usuario, password)";
            consultaSQL += "VALUES(?, ?, ?, md5(?))";
            
            conexionLocal = GestorConexionBD.obtenerInstancia().tomarConexion();
            sentenciaAPreparar = conexionLocal.prepareCall(consultaSQL);
            
            sentenciaAPreparar.setString(1, empleadoNuevo.getNombre());
            sentenciaAPreparar.setString(2, empleadoNuevo.getApellido());
            sentenciaAPreparar.setString(3, empleadoNuevo.getUsuario());
            sentenciaAPreparar.setString(4, empleadoNuevo.getPassword());
            
            sentenciaAPreparar.executeUpdate();
            sentenciaAPreparar.close();
            
            GestorConexionBD.obtenerInstancia().commit();
            resultado = true;
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            resultado = false;
            //throw new Exception("No se pudo crear el empleado en " + this.getClass().toString());
        }finally
        {
            GestorConexionBD.obtenerInstancia().dejarConexion();
            return resultado;
        }
    }
}
