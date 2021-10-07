/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.ArrayList;
import negocio.entidades.Cliente;
import negocio.entidades.Copia;
import negocio.entidades.Pelicula;
import negocio.logica.GestorEmpleados;
import negocio.logica.GestorPeliculas;
import vistas.ListaCopias;
import vistas.ListaPeliculas;
import vistas.VentanaPrestamo;

/**
 *
 * @author Rubén
 */
public class ControladorVentanaPrestamo extends ControladorGlobal
{
    private VentanaPrestamo laVentanaPrestamo;
    private ArrayList<GestorPeliculas> poolGestorPeliculas;
    private ArrayList<VentanaPrestamo> poolVentanasPrestamo;

    public ControladorVentanaPrestamo() {
        this.poolGestorPeliculas = new ArrayList<GestorPeliculas>();
        this.poolVentanasPrestamo = new ArrayList<VentanaPrestamo>();
    }
    
    @Override
    public void lanzarVentana()
    {
        laVentanaPrestamo = new VentanaPrestamo(this);
        laVentanaPrestamo.setVisible(true);
    }

    public void setGestorEmpleados(GestorEmpleados gestorEmpleados) {
        this.gestorEmpleados = gestorEmpleados;
    }
    
    public boolean realizarPrestamo(ArrayList<Copia> copiasPrestamo, Cliente clientePrestamo,
            double valorPrestamo)
    {
        this.gestorPeliculas.setEmpleadoAsociadoSesion(gestorEmpleados.getEmpleadoAsociadoSesion());
        this.poolGestorPeliculas.add(this.gestorPeliculas);
        this.poolVentanasPrestamo.add(laVentanaPrestamo);
        int posicionNuevoHilo = this.poolGestorPeliculas.size() - 1;
        this.poolGestorPeliculas.get(posicionNuevoHilo).setVentanaPrestamoHilo(this.poolVentanasPrestamo.get(posicionNuevoHilo));
        this.poolGestorPeliculas.get(posicionNuevoHilo).setCopiasAPrestar(copiasPrestamo);
        this.poolGestorPeliculas.get(posicionNuevoHilo).setClientePrestamo(clientePrestamo);
        this.poolGestorPeliculas.get(posicionNuevoHilo).setValorPrestamo(valorPrestamo);
        this.gestorPeliculas = new GestorPeliculas();
        this.lanzarVentana();
        new Thread(this.poolGestorPeliculas.get(posicionNuevoHilo)).start();        
        return true;
    }
    
    public void getCintasDisponiblesPorTitulo(String fragmentoTitulo)
    {
        ArrayList<Copia> copiasEncontradas = gestorPeliculas.copiasDisponiblesPorTitulo(fragmentoTitulo);
        ArrayList<Copia> copiasAMostrar = new ArrayList<Copia>();
        boolean mostrarCopia = true; 
        
        if(this.laVentanaPrestamo.getCopiasParaPrestamo().size() > 0)
        {
            for(Copia cadaCopiaEncontrada : copiasEncontradas)
            {
                mostrarCopia = true;
                
                for(Copia cadaCopiaExistente : this.laVentanaPrestamo.getCopiasParaPrestamo())
                {
                    if(cadaCopiaEncontrada.getId() == cadaCopiaExistente.getId())
                        mostrarCopia = false;
                }
                
                if(mostrarCopia)
                {
                    copiasAMostrar.add(cadaCopiaEncontrada);
                }
            }
        }else
        {
            copiasAMostrar = copiasEncontradas;
        }
        
        if(copiasAMostrar != null && copiasAMostrar.size() > 0)
        {
            new ListaCopias(copiasAMostrar, this.laVentanaPrestamo).setVisible(true);
        }
    }
    
    public void getPeliculasPorActor(String fragmentoNombreActor)
    {
        ArrayList<Pelicula> peliculasEncontradas = gestorPeliculas.peliculasPorActor(fragmentoNombreActor);
        
        if(peliculasEncontradas != null && peliculasEncontradas.size() > 0)
        {
            new ListaPeliculas(peliculasEncontradas, this.laVentanaPrestamo, this).setVisible(true);
        }
    }
    
    public Cliente getClientePorID(int idCliente)
    {
        return this.gestorClientes.getClientePorID(idCliente);
    }
    
    public Copia getCopiaPorID(int idCopia)
    {
        return this.gestorPeliculas.copiaPorID(idCopia);
    }
    
    public void getCintasDisponiblesPorID(int idPelicula)
    {
        ArrayList<Copia> copiasEncontradas = gestorPeliculas.copiasDisponiblesPorId(idPelicula);
        
        ArrayList<Copia> copiasAMostrar = new ArrayList<Copia>();
        boolean mostrarCopia = true; 
        
        if(this.laVentanaPrestamo.getCopiasParaPrestamo().size() > 0)
        {
            for(Copia cadaCopiaEncontrada : copiasEncontradas)
            {
                mostrarCopia = true;
                
                for(Copia cadaCopiaExistente : this.laVentanaPrestamo.getCopiasParaPrestamo())
                {
                    if(cadaCopiaEncontrada.getId() == cadaCopiaExistente.getId())
                        mostrarCopia = false;
                }
                
                if(mostrarCopia)
                {
                    copiasAMostrar.add(cadaCopiaEncontrada);
                }
            }
        }else
        {
            copiasAMostrar = copiasEncontradas;
        }
        
        if(copiasAMostrar != null && copiasAMostrar.size() > 0)
        {
            new ListaCopias(copiasAMostrar, this.laVentanaPrestamo).setVisible(true);
        }
    }
}
