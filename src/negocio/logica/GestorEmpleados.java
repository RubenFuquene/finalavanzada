/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.logica;

import datos.DAO.EmpleadoDAO;
import java.util.ArrayList;
import negocio.entidades.Actor;
import negocio.entidades.Empleado;
import negocio.entidades.Pelicula;

/**
 *
 * @author Rubén
 */
public class GestorEmpleados extends GestorGlobal
{
    private EmpleadoDAO empleadoDAO;

    public GestorEmpleados()
    {
        this.empleadoDAO = new EmpleadoDAO();
    }
    
    public boolean iniciarSesion(String usuario, String password)
    {
        this.empleadoAsociadoSesion.setUsuario(usuario);
        this.empleadoAsociadoSesion.setPassword(password);
        
        empleadoDAO.iniciarSesion(this);
        return this.sesionIniciada;
    }
    
    public boolean crearNuevoEmpleado(String nombre, String apellido, String usuario, String passwrod)
    {
        Empleado nuevoEmpleado = new Empleado();
        nuevoEmpleado.setNombre(nombre);
        nuevoEmpleado.setApellido(apellido);
        nuevoEmpleado.setUsuario(usuario);
        nuevoEmpleado.setPassword(passwrod);
        
        return empleadoDAO.crearEmpleado(nuevoEmpleado);
    }
}
