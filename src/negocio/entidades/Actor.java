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
public class Actor
{
    private int id;
    private String nombre;
    private String fragamentoNobre;
    private LocalDate fechaNacimiento;
    private String apodo;
    private ArrayList<Pelicula> peliculas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFragamentoNobre() {
        return fragamentoNobre;
    }

    public void setFragamentoNobre(String fragamentoNobre) {
        this.fragamentoNobre = fragamentoNobre;
    }

    
    
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
    
    
}
