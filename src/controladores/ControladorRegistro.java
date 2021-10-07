/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import negocio.logica.GestorGlobal;
import vistas.VentanaBienvenida;
import vistas.VentanaRegistro;

/**
 *
 * @author Rubén
 */
public class ControladorRegistro extends ControladorGlobal
{    
    private ControladorGlobal controladorPrincipal;
            
    @Override
    public void lanzarVentana()
    {
        VentanaRegistro ventanaRegistro = new VentanaRegistro(this);
        ventanaRegistro.setVisible(true);
    }
    
    public boolean registrarEmpleado(String nombre, String apellido, String usuario, String password)
    {
        return this.gestorEmpleados.crearNuevoEmpleado(nombre, apellido, usuario, password);
    }
    
    public void lanzarVentanaInicial()
    {
        new VentanaBienvenida(controladorPrincipal).setVisible(true);
    }

    public void setControladorPrincipal(ControladorGlobal controladorPrincipal) {
        this.controladorPrincipal = controladorPrincipal;
    }
}
