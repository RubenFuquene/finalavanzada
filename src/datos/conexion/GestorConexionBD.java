/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import configuracion.VariablesConexion;
import java.sql.SQLException;

/**
 * Control de la conexión a la base de datos por medio de la aplicación.
 * 
 * @author Rubén Fúquene
 */
public class GestorConexionBD
{
    private static GestorConexionBD gestor = null;
    private Connection conexion = null;
    private boolean conexionLibre = true;
    
    public static GestorConexionBD obtenerInstancia()
    {
        if (gestor == null)
        {
            try
            {
                gestor = new GestorConexionBD();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        
        return gestor;
    }
    
    private GestorConexionBD() throws Exception
    {
        try
        {
            Class.forName("org.postgresql.Driver").newInstance();
            conexion = DriverManager.getConnection(VariablesConexion.URLBD, VariablesConexion.USUARIODB, VariablesConexion.CONTRASENADB);
            conexion.setAutoCommit(false);
        } catch (Exception e)
        {
            throw new Exception("Error en la conexión a la base de datos en " + this.getClass().toString());
        }
    }
    
    public synchronized Connection tomarConexion()
    {
        while (!conexionLibre)
        {
            try
            {
                wait();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        
        conexionLibre = false;
        notify();
        return conexion;
    }
    
    public synchronized void dejarConexion()
    {
        while (conexionLibre)
        {
            try
            {
                wait();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        
        conexionLibre = true;
        notify();
    }
    
    public void cerrarSesionBD()
    {
        try
        {
            conexion.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public void commit()
    {
        try
        {
            conexion.commit();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public void rollback()
    {
        try
        {
            conexion.rollback();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
