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
public class Prestamo
{
    private int id;
    private Empleado empleado;
    private Cliente cliente;
    private LocalDate fechaPrestamo;
    private double valor;
    private ArrayList<Copia> copias;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public ArrayList<Copia> getCopias() {
        return copias;
    }

    public void setCopias(ArrayList<Copia> copias) {
        this.copias = copias;
    }
    
    
}
