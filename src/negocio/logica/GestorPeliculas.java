/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.logica;

import datos.DAO.ClienteDAO;
import datos.DAO.CopiaDAO;
import datos.DAO.PeliculasDAO;
import datos.DAO.PrestamoDAO;
import java.util.ArrayList;
import negocio.entidades.Actor;
import negocio.entidades.Cliente;
import negocio.entidades.Copia;
import negocio.entidades.Pelicula;
import negocio.entidades.Prestamo;
import vistas.VentanaPrestamo;

/**
 *
 * @author Rubén
 */
public class GestorPeliculas extends GestorGlobal implements Runnable
{
    private final CopiaDAO copiaDAO;
    private final ClienteDAO clienteDAO;
    private final PrestamoDAO prestamoDAO;
    private final PeliculasDAO peliculasDAO;
    private ArrayList<Copia> copiasAPrestar;
    private Cliente clientePrestamo;
    private double valorPrestamo;
    private VentanaPrestamo ventanaPrestamoHilo;

    public GestorPeliculas()
    {
        this.copiaDAO = new CopiaDAO();
        this.clienteDAO = new ClienteDAO();
        this.prestamoDAO = new PrestamoDAO();
        this.peliculasDAO = new PeliculasDAO();
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
    
    public Copia copiaPorID(int idCopia)
    {
        Copia nuevaCopia = new Copia();
        nuevaCopia.setId(idCopia);
        
        return copiaDAO.buscarCopiaPorID(nuevaCopia);
    }
    
    public boolean crearPrestamo(ArrayList<Copia> copiasAPrestar,
            Cliente clientePrestamo, double valorPrestamo)
    {
        boolean resusltado = false;
        
        Prestamo nuevoPrestamo = new Prestamo();
        nuevoPrestamo.setCopias(copiasAPrestar);
        nuevoPrestamo.setCliente(clienteDAO.buscarClientePorID(clientePrestamo));
        nuevoPrestamo.setEmpleado(this.empleadoAsociadoSesion);
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
    
    public ArrayList<Pelicula> peliculasPorActor(String fragmentoNombreActor)
    {
        Actor nuevoActor = new Actor();
        nuevoActor.setFragamentoNobre(fragmentoNombreActor);
        
        return peliculasDAO.peliculasPorActor(nuevoActor);
    }

    public void setCopiasAPrestar(ArrayList<Copia> copiasAPrestar) {
        this.copiasAPrestar = copiasAPrestar;
    }

    public void setClientePrestamo(Cliente clientePrestamo) {
        this.clientePrestamo = clientePrestamo;
    }

    public void setValorPrestamo(double valorPrestamo) {
        this.valorPrestamo = valorPrestamo;
    }

    public void setVentanaPrestamoHilo(VentanaPrestamo ventanaPrestamoHilo) {
        this.ventanaPrestamoHilo = ventanaPrestamoHilo;
    }
    
    @Override
    public void run()
    {
        if(this.crearPrestamo(this.copiasAPrestar, this.clientePrestamo, this.valorPrestamo))
        {
            this.ventanaPrestamoHilo.mensajePrestamoExitoso();
            this.ventanaPrestamoHilo.dispose();
        }else
        {
            this.ventanaPrestamoHilo.mensajeNoSeRealizaPrestamo();
        }
    }
}
