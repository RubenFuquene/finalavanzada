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
import java.time.LocalDate;
import negocio.entidades.Prestamo;

/**
 *
 * @author Rubén
 */
public class PrestamoDAO
{
    private String consultaSQL;
    private Connection conexionLocal;
    private PreparedStatement sentenciaAPreparar;
    
    public boolean crearPrestamo(Prestamo elPrestamo)
    {
        boolean resultado = false;
        
        try
        {
            consultaSQL = "INSERT INTO prestamos (empleado_id, cliente_id, fecha_prestamo, valor)";
            consultaSQL += "VALUES(?, ?, ?, ?)";

            conexionLocal = GestorConexionBD.obtenerInstancia().tomarConexion();
            sentenciaAPreparar = conexionLocal.prepareCall(consultaSQL);

            sentenciaAPreparar.setInt(1, elPrestamo.getEmpleado().getIdentificador());
            sentenciaAPreparar.setInt(2, elPrestamo.getCliente().getId());
            sentenciaAPreparar.setObject(3, LocalDate.now());
            sentenciaAPreparar.setDouble(4, elPrestamo.getValor());

            sentenciaAPreparar.executeUpdate();
            sentenciaAPreparar.close();

            GestorConexionBD.obtenerInstancia().commit();
            resultado = true;
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            resultado = false;
            //throw new Exception("No se pudo crear el afiliado en " + this.getClass().toString());
        }finally
        {
            GestorConexionBD.obtenerInstancia().dejarConexion();
            return resultado;
        }
    }
    
    public int otenerIDUltimoPrestamo(Prestamo prestamo)
    {
        ResultSet respuestaIterativa;
        int elId = 0;

        try
        {
            consultaSQL = "SELECT max(id)";
            consultaSQL += " FROM prestamos";
            
            conexionLocal = GestorConexionBD.obtenerInstancia().tomarConexion();
            
            sentenciaAPreparar = conexionLocal.prepareStatement(consultaSQL);
            
            respuestaIterativa = sentenciaAPreparar.executeQuery();
            
            respuestaIterativa.next();
                    
            elId = respuestaIterativa.getInt(1);
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage() + " " + e.getCause());
            //throw new Exception("Error en la consulta en " + this.getClass().toString());
        } finally {
            GestorConexionBD.obtenerInstancia().dejarConexion();
            return elId;
        }
    }
}
