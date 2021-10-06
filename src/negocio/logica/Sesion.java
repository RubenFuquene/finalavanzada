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
public class Sesion
{
    private boolean sesionIniciada;
    private EmpleadoDAO empleadoDAO;
    private CopiaDAO copiaDAO;
    private PeliculasDAO peliculasDAO;
    private ClienteDAO clienteDAO;
    private PrestamoDAO prestamoDAO;
    private Empleado empleadoAsociadoSesion;
    
    public Sesion()
    {
        empleadoDAO = new EmpleadoDAO();
        copiaDAO = new CopiaDAO();
        peliculasDAO = new PeliculasDAO();
        clienteDAO = new ClienteDAO();
        prestamoDAO = new PrestamoDAO();
        empleadoAsociadoSesion = new Empleado();
        sesionIniciada = false;
    }
    
    public boolean iniciarSesion(String usuario, String password)
    {
        empleadoAsociadoSesion.setUsuario(usuario);
        empleadoAsociadoSesion.setPassword(password);
        
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
    
    public ArrayList<Copia> copiasDisponiblesPorTitulo(String fragmentoTitulo)
    {
        Pelicula peliculaABuscar = new Pelicula();
        peliculaABuscar.setFragmentoTitulo(fragmentoTitulo);
                
        return copiaDAO.copiasDisponiblesPorTituloPelicula(peliculaABuscar);
    }
    
    public ArrayList<Copia> copiasDisponiblesPorId(int idPelicula)
    {
        Pelicula peliculaABuscar = new Pelicula();
        peliculaABuscar.setId(idPelicula);
                
        return copiaDAO.copiasDisponiblesPorIdPelicula(peliculaABuscar);
    }

    public EmpleadoDAO getEmpleadoDAO()
    {
        return empleadoDAO;
    }

    public Empleado getEmpleadoAsociadoSesion()
    {
        return empleadoAsociadoSesion;
    }

    public void setSesionIniciada(boolean sesionIniciada)
    {
        this.sesionIniciada = sesionIniciada;
    }
    
    public Copia copiaPorID(int idCopia)
    {
        Copia nuevaCopia = new Copia();
        nuevaCopia.setId(idCopia);
        
        return copiaDAO.buscarCopiaPorID(nuevaCopia);
    }
    
    public ArrayList<Pelicula> peliculasPorActor(String fragmentoNombreActor)
    {
        Actor nuevoActor = new Actor();
        nuevoActor.setFragamentoNobre(fragmentoNombreActor);
        
        return peliculasDAO.peliculasPorActor(nuevoActor);
    }
    
    public Cliente getClientePorID(int idCliente)
    {
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setId(idCliente);
        
        return clienteDAO.buscarClientePorID(nuevoCliente);
    }
    
    public boolean crearPrestamo(ArrayList<Copia> copiasAPrestar,
            Cliente clientePrestamo, double valorPrestamo)
    {
        boolean resusltado = false;
        
        Prestamo nuevoPrestamo = new Prestamo();
        nuevoPrestamo.setCopias(copiasAPrestar);
        nuevoPrestamo.setCliente(clienteDAO.buscarClientePorID(clientePrestamo));
        nuevoPrestamo.setEmpleado(empleadoAsociadoSesion);
        nuevoPrestamo.setValor(valorPrestamo);
        nuevoPrestamo.getCliente().setCredito(nuevoPrestamo.getCliente().getCredito() - valorPrestamo);
        
        if(prestamoDAO.crearPrestamo(nuevoPrestamo))
        {
            nuevoPrestamo.setId(prestamoDAO.otenerIDUltimoPrestamo(nuevoPrestamo));
            copiaDAO.prestarCopias(nuevoPrestamo);
            clienteDAO.actualizarCliente(nuevoPrestamo.getCliente());
            resusltado = true;
        }
        
        return resusltado;
    }
}
