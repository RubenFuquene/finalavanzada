/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.ArrayList;
import negocio.logica.GestorClientes;
import negocio.logica.GestorEmpleados;
import negocio.entidades.Cliente;
import negocio.entidades.Copia;
import negocio.entidades.Pelicula;
import negocio.logica.GestorGlobal;
import negocio.logica.GestorPeliculas;
import vistas.ListaCopias;
import vistas.ListaPeliculas;
import vistas.VentanaBienvenida;
import vistas.VentanaPrestamo;

/**
 *
 * @author Rubén
 */
public class ControladorGlobal implements Controlador
{
    protected GestorGlobal sesionActual;
    protected GestorEmpleados gestorEmpleados;
    protected GestorPeliculas gestorPeliculas;
    protected GestorClientes gestorClientes;
    private VentanaPrestamo laVentanaPrestamo;

    public ControladorGlobal()
    {
        sesionActual = new GestorGlobal();
        gestorEmpleados = new GestorEmpleados();
        gestorPeliculas = new GestorPeliculas();
        this.gestorClientes = new GestorClientes();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaBienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaBienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaBienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaBienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run()
            {
                ControladorGlobal controlador = new ControladorGlobal();
                
                controlador.lanzarVentana();
            }
        });
    }

    @Override
    public void lanzarVentana()
    {
        new VentanaBienvenida(this).setVisible(true);
    }
    
    public void lanzarVentanaRegistro()
    {
        ControladorRegistro controladorRegistro = new ControladorRegistro();
        controladorRegistro.setControladorPrincipal(this);
        controladorRegistro.lanzarVentana();
    }
    
    public void lanzarVentanaIngreso()
    {
        ControladorIngreso controladorIngreso = new ControladorIngreso();
        controladorIngreso.setControladorPrincipal(this);
        controladorIngreso.lanzarVentana();
    }
    
    public void lanzarVentanaInicial(ControladorGlobal control)
    {
        new VentanaBienvenida(control).setVisible(true);
    }

    public GestorGlobal getSesionActual()
    {
        return sesionActual;
    }
}
