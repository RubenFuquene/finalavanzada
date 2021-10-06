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
import negocio.entidades.Cliente;
import negocio.entidades.Copia;

/**
 *
 * @author Rubén
 */
public class ClienteDAO
{
    private String consultaSQL;
    private Connection conexionLocal;
    private PreparedStatement sentenciaAPreparar;
    
    public Cliente buscarClientePorID(Cliente cliente)
    {
        ResultSet respuestaIterativa;

        try
        {
            consultaSQL = "SELECT clientes.nombre, clientes.apellido, clientes.telefono, clientes.direccion, clientes.credito";
            consultaSQL += " FROM clientes";
            consultaSQL += " WHERE clientes.id = ?";
            
            conexionLocal = GestorConexionBD.obtenerInstancia().tomarConexion();
            
            sentenciaAPreparar = conexionLocal.prepareStatement(consultaSQL);
            sentenciaAPreparar.setInt(1, cliente.getId());
            
            respuestaIterativa = sentenciaAPreparar.executeQuery();
            
            respuestaIterativa.next();
                    
            cliente.setNombre(respuestaIterativa.getString(1));
            cliente.setApellido(respuestaIterativa.getString(2));
            cliente.setTelefono(respuestaIterativa.getString(3));
            cliente.setDireccion(respuestaIterativa.getString(4));
            cliente.setCredito(respuestaIterativa.getDouble(5));
            
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage() + " " + e.getCause());
            //throw new Exception("Error en la consulta en " + this.getClass().toString());
        } finally {
            GestorConexionBD.obtenerInstancia().dejarConexion();
            return cliente;
        }
    }
    
    public boolean actualizarCliente(Cliente cliente)
    {
        boolean resultado = false;
        
        try
        {
            consultaSQL = "UPDATE clientes SET nombre = ?, apellido = ?, telefono = ?, direccion = ?, credito = ?";
            consultaSQL += "WHERE id = ?";

            conexionLocal = GestorConexionBD.obtenerInstancia().tomarConexion();
            sentenciaAPreparar = conexionLocal.prepareStatement(consultaSQL);

            sentenciaAPreparar.setString(1, cliente.getNombre());
            sentenciaAPreparar.setString(2, cliente.getApellido());
            sentenciaAPreparar.setString(3, cliente.getTelefono());
            sentenciaAPreparar.setString(4, cliente.getDireccion());
            sentenciaAPreparar.setDouble(5, cliente.getCredito());
            sentenciaAPreparar.setInt(6, cliente.getId());
            sentenciaAPreparar.executeUpdate();
            sentenciaAPreparar.close();
            GestorConexionBD.obtenerInstancia().commit();
            GestorConexionBD.obtenerInstancia().dejarConexion();
                      
            resultado = true;
        } catch (Exception e)
        {
            System.out.println("Error");
            System.out.println(e.getMessage() + " en ClienteDAO::actualizarCliente()");
            resultado = false;
            //throw new Exception("No se pudo actualizar el afiliado en " + this.getClass().toString());
        }finally
        {
            return resultado;
        }
    }
}
