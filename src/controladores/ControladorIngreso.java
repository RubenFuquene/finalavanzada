/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import negocio.logica.GestorEmpleados;
import vistas.VentanaBienvenida;
import vistas.VentanaIngreso;
import vistas.VentanaPrestamo;

/**
 *
 * @author Rubén
 */
public class ControladorIngreso extends ControladorGlobal
{
    private ControladorGlobal controladorPrincipal;
    
    @Override
    public void lanzarVentana()
    {
        new VentanaIngreso(this).setVisible(true);
    }
    
    public boolean crearSesion(String usuario, String password)
    {
        return this.gestorEmpleados.iniciarSesion(usuario, password);
    }
    
    public void lanzarVentanaPrestamo()
    {
        ControladorVentanaPrestamo controladorVentanaPrestamo = new ControladorVentanaPrestamo();
        controladorVentanaPrestamo.setGestorEmpleados(this.gestorEmpleados);
        controladorVentanaPrestamo.lanzarVentana();
    }
    public void lanzarVentanaInicial()
    {
        new VentanaBienvenida(this.controladorPrincipal).setVisible(true);
    }
    
    public void setControladorPrincipal(ControladorGlobal controladorPrincipal)
    {
        this.controladorPrincipal = controladorPrincipal;
    }
}
