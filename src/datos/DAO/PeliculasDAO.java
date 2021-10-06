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
import java.util.ArrayList;
import negocio.entidades.Actor;
import negocio.entidades.Copia;
import negocio.entidades.Pelicula;

/**
 *
 * @author Rubén
 */
public class PeliculasDAO
{
    private String consultaSQL;
    private Connection conexionLocal;
    private PreparedStatement sentenciaAPreparar;
    
    public ArrayList<Pelicula> peliculasPorActor(Actor actor)
    {
        ResultSet respuestaIterativa;
        ArrayList<Pelicula> peliculasEncontradas = new ArrayList<Pelicula>();

        try
        {
            consultaSQL = "SELECT peliculas.id, peliculas.titulo, actores.nombre";
            consultaSQL += " FROM peliculas, actor_pelicula, actores";
            consultaSQL += " WHERE peliculas.id = actor_pelicula.pelicula_id" +
                " AND actor_pelicula.actor_id = actores.id" +
                " AND (upper(actores.nombre) LIKE upper(?) OR upper(actores.apodo) LIKE upper(?) ESCAPE '!')" + 
                " ORDER BY peliculas.titulo";
            
            conexionLocal = GestorConexionBD.obtenerInstancia().tomarConexion();
            
            sentenciaAPreparar = conexionLocal.prepareStatement(consultaSQL);
            sentenciaAPreparar.setString(1, "%" + actor.getFragamentoNobre().replace("!", "!!")
                .replace("%", "!%")
                .replace("_", "!_")
                .replace("[", "![") + "%");
            sentenciaAPreparar.setString(2, "%" + actor.getFragamentoNobre().replace("!", "!!")
                .replace("%", "!%")
                .replace("_", "!_")
                .replace("[", "![") + "%");
            
            respuestaIterativa = sentenciaAPreparar.executeQuery();
            
            while (respuestaIterativa.next())
            {
                Pelicula peliculaEncontrada = new Pelicula();
                
                peliculaEncontrada.setId(respuestaIterativa.getInt(1));
                peliculaEncontrada.setTitulo(respuestaIterativa.getString(2));
                
                Actor nuevoActor = new Actor();
                nuevoActor.setNombre(respuestaIterativa.getString(3));
                
                peliculaEncontrada.getActores().add(nuevoActor);
                
                peliculasEncontradas.add(peliculaEncontrada);
            }
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage() + " " + e.getCause());
            //throw new Exception("Error en la consulta en " + this.getClass().toString());
        } finally {
            GestorConexionBD.obtenerInstancia().dejarConexion();
            return peliculasEncontradas;
        }
    }
}
