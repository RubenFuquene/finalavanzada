/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.logica;

import datos.DAO.ClienteDAO;
import datos.DAO.CopiaDAO;
import datos.DAO.EmpleadoDAO;
import datos.DAO.PeliculasDAO;
import datos.DAO.PrestamoDAO;
import java.util.ArrayList;
import negocio.entidades.Actor;
import negocio.entidades.Cliente;
import negocio.entidades.Copia;
import negocio.entidades.Empleado;
import negocio.entidades.Pelicula;
import negocio.entidades.Prestamo;

/**
 *
 * @author Rubén
 */
public class GestorGlobal
{
    protected boolean sesionIniciada;
    protected Empleado empleadoAsociadoSesion;
    
    public GestorGlobal()
    {
        empleadoAsociadoSesion = new Empleado();
        sesionIniciada = false;
    }

    public void setEmpleadoAsociadoSesion(Empleado empleadoAsociadoSesion) {
        this.empleadoAsociadoSesion = empleadoAsociadoSesion;
    }
    
    public Empleado getEmpleadoAsociadoSesion()
    {
        return empleadoAsociadoSesion;
    }

    public void setSesionIniciada(boolean sesionIniciada)
    {
        this.sesionIniciada = sesionIniciada;
    }
}
