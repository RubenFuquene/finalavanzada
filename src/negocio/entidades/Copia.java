/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.entidades;

/**
 *
 * @author Rubén
 */
public class Copia
{
    private int id;
    private Formato formato;
    private Pelicula pelicula;
    private Estado estado;
    private Prestamo prestamo;

    public Copia()
    {
        formato = new Formato();
        pelicula = new Pelicula();
        estado = new Estado();
        prestamo = new Prestamo();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }
    
    
}
