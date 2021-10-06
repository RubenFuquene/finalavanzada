/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.entidades;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Rubén
 */
public class Pelicula
{
    private int id;
    private String titulo;
    private String fragmentoTitulo;
    private LocalDate fechaEstreno;
    private ArrayList<Categoria> categorias;
    private ArrayList<Actor> actores;
    private ArrayList<Copia> copias;

    public Pelicula()
    {
        actores = new ArrayList<Actor>();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFragmentoTitulo() {
        return fragmentoTitulo;
    }

    public void setFragmentoTitulo(String fragmentoTitulo) {
        this.fragmentoTitulo = fragmentoTitulo;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    public ArrayList<Actor> getActores() {
        return actores;
    }

    public void setActores(ArrayList<Actor> actores) {
        this.actores = actores;
    }

    public ArrayList<Copia> getCopias() {
        return copias;
    }

    public void setCopias(ArrayList<Copia> copias) {
        this.copias = copias;
    }
    
    
}
