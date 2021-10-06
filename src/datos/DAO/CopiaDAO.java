/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.DAO;

import configuracion.VariablesConexion;
import datos.conexion.GestorConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.entidades.Copia;
import negocio.entidades.Pelicula;
import negocio.entidades.Prestamo;

/**
 *
 * @author Rubén
 */
public class CopiaDAO
{
    private String consultaSQL;
    private Connection conexionLocal;
    private PreparedStatement sentenciaAPreparar;
    
    public ArrayList<Copia> copiasDisponiblesPorTituloPelicula(Pelicula pelicula)
    {
        ResultSet respuestaIterativa;
        ArrayList<Copia> copiasEncontradas = new ArrayList<Copia>();

        try
        {
            consultaSQL = "SELECT formatos.descripcion, copias.id, peliculas.titulo";
            consultaSQL += " FROM copias, peliculas, formatos, estados";
            consultaSQL += " WHERE copias.pelicula_id = peliculas.id" +
                " AND copias.formato_id = formatos.id" +
                " AND copias.estado_id = estados.id" +
                " AND copias.estado_id = 1 AND upper(peliculas.titulo) LIKE upper(?) ESCAPE '!'" + 
                " ORDER BY peliculas.titulo";
            
            conexionLocal = GestorConexionBD.obtenerInstancia().tomarConexion();
            
            sentenciaAPreparar = conexionLocal.prepareStatement(consultaSQL);
            sentenciaAPreparar.setString(1, "%" + pelicula.getFragmentoTitulo().replace("!", "!!")
                .replace("%", "!%")
                .replace("_", "!_")
                .replace("[", "![") + "%");
            
            respuestaIterativa = sentenciaAPreparar.executeQuery();
            
            while (respuestaIterativa.next())
            {
                Copia copiaEncontrada = new Copia();
                
                copiaEncontrada.getFormato().setDescripcion(respuestaIterativa.getString(1));
                copiaEncontrada.setId(respuestaIterativa.getInt(2));
                copiaEncontrada.getPelicula().setTitulo(respuestaIterativa.getString(3));
                
                copiasEncontradas.add(copiaEncontrada);
            }
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage() + " " + e.getCause());
            //throw new Exception("Error en la consulta en " + this.getClass().toString());
        } finally {
            GestorConexionBD.obtenerInstancia().dejarConexion();
            return copiasEncontradas;
        }
    }
    
    public ArrayList<Copia> copiasDisponiblesPorIdPelicula(Pelicula pelicula)
    {
        ResultSet respuestaIterativa;
        ArrayList<Copia> copiasEncontradas = new ArrayList<Copia>();

        try
        {
            consultaSQL = "SELECT formatos.descripcion, copias.id, peliculas.titulo";
            consultaSQL += " FROM copias, peliculas, formatos, estados";
            consultaSQL += " WHERE copias.pelicula_id = peliculas.id" +
                " AND copias.formato_id = formatos.id" +
                " AND copias.estado_id = estados.id" +
                " AND copias.estado_id = 1 AND peliculas.id = ?";
            
            conexionLocal = GestorConexionBD.obtenerInstancia().tomarConexion();
            
            sentenciaAPreparar = conexionLocal.prepareStatement(consultaSQL);
            sentenciaAPreparar.setInt(1, pelicula.getId());
            
            respuestaIterativa = sentenciaAPreparar.executeQuery();
            
            while (respuestaIterativa.next())
            {
                Copia copiaEncontrada = new Copia();
                
                copiaEncontrada.getFormato().setDescripcion(respuestaIterativa.getString(1));
                copiaEncontrada.setId(respuestaIterativa.getInt(2));
                copiaEncontrada.getPelicula().setTitulo(respuestaIterativa.getString(3));
                
                copiasEncontradas.add(copiaEncontrada);
            }
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage() + " " + e.getCause());
            //throw new Exception("Error en la consulta en " + this.getClass().toString());
        } finally {
            GestorConexionBD.obtenerInstancia().dejarConexion();
            return copiasEncontradas;
        }
    }
    
    public Copia buscarCopiaPorID(Copia copia)
    {
        ResultSet respuestaIterativa;

        try
        {
            consultaSQL = "SELECT formatos.descripcion, copias.id, peliculas.titulo";
            consultaSQL += " FROM copias, peliculas, formatos, estados";
            consultaSQL += " WHERE copias.pelicula_id = peliculas.id" +
                " AND copias.formato_id = formatos.id" +
                " AND copias.estado_id = estados.id" +
                " AND copias.estado_id = 1 AND copias.id = ?";
            
            conexionLocal = GestorConexionBD.obtenerInstancia().tomarConexion();
            
            sentenciaAPreparar = conexionLocal.prepareStatement(consultaSQL);
            sentenciaAPreparar.setInt(1, copia.getId());
            
            respuestaIterativa = sentenciaAPreparar.executeQuery();
            
            respuestaIterativa.next();
                    
            copia.getFormato().setDescripcion(respuestaIterativa.getString(1));
            copia.setId(respuestaIterativa.getInt(2));
            copia.getPelicula().setTitulo(respuestaIterativa.getString(3));
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage() + " " + e.getCause());
            //throw new Exception("Error en la consulta en " + this.getClass().toString());
        } finally {
            GestorConexionBD.obtenerInstancia().dejarConexion();
            return copia;
        }
    }
    
    public boolean prestarCopias(Prestamo elPrestamo)
    {
        boolean resultado = false;
        
        try
        {
            for(Copia cadaCopia : elPrestamo.getCopias())
            {
                System.out.println(cadaCopia.getId());
                
                consultaSQL = "UPDATE copias SET prestamo_id = ?, estado_id = " + VariablesConexion.CINTA_PRESTADA;
                consultaSQL += "WHERE id = ?";

                conexionLocal = GestorConexionBD.obtenerInstancia().tomarConexion();
                sentenciaAPreparar = conexionLocal.prepareStatement(consultaSQL);

                sentenciaAPreparar.setInt(1, elPrestamo.getId());
                sentenciaAPreparar.setInt(2, cadaCopia.getId());
                sentenciaAPreparar.executeUpdate();
                sentenciaAPreparar.close();
                GestorConexionBD.obtenerInstancia().commit();
                GestorConexionBD.obtenerInstancia().dejarConexion();
            }
                      
            resultado = true;
        } catch (Exception e)
        {
            System.out.println("Error");
            System.out.println(e.getMessage() + " en CopiaDAO::prestarCopias");
            resultado = false;
            //throw new Exception("No se pudo actualizar el afiliado en " + this.getClass().toString());
        }finally
        {
            return resultado;
        }
    }
}
