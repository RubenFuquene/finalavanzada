/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import negocio.entidades.Cliente;
import negocio.entidades.Copia;
import negocio.entidades.Empleado;
import negocio.entidades.Pelicula;
import negocio.logica.Sesion;

/**
 *
 * @author Rubén
 */
public class Controlador implements ActionListener
{
    private Sesion sesionActual;
    private VentanaPrestamo laVentanaPrestamo;

    public Controlador()
    {
        sesionActual = new Sesion();
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
                Controlador controlador = new Controlador();
                
                controlador.lanzarVentanaInicial(controlador);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void lanzarVentanaRegistro()
    {
        new VentanaRegistro(this).setVisible(true);
    }
    
    public void lanzarVentanaInicial(Controlador control)
    {
        new VentanaBienvenida(control).setVisible(true);
    }
    
    public boolean crearSesion(String usuario, String password)
    {
        return sesionActual.iniciarSesion(usuario, password);
    }
    
    public boolean registrarEmpleado(String nombre, String apellido, String usuario, String password)
    {
        return sesionActual.crearNuevoEmpleado(nombre, apellido, usuario, password);
    }

    public Sesion getSesionActual()
    {
        return sesionActual;
    }
    
    public void getCintasDisponiblesPorTitulo(String fragmentoTitulo)
    {
        ArrayList<Copia> copiasEncontradas = sesionActual.copiasDisponiblesPorTitulo(fragmentoTitulo);
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
    
    public Copia getCopiaPorID(int idCopia)
    {
        return this.sesionActual.copiaPorID(idCopia);
    }

    public void lanzarVentanaPrestamo()
    {
        this.laVentanaPrestamo = new VentanaPrestamo(this);
        this.laVentanaPrestamo.setVisible(true);
    }
    
    public void getPeliculasPorActor(String fragmentoNombreActor)
    {
        ArrayList<Pelicula> peliculasEncontradas = sesionActual.peliculasPorActor(fragmentoNombreActor);
        
        if(peliculasEncontradas != null && peliculasEncontradas.size() > 0)
        {
            new ListaPeliculas(peliculasEncontradas, this.laVentanaPrestamo, this).setVisible(true);
        }
    }
    
    public void getCintasDisponiblesPorID(int idPelicula)
    {
        ArrayList<Copia> copiasEncontradas = sesionActual.copiasDisponiblesPorId(idPelicula);
        
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
    
    public Cliente getClientePorID(int idCliente)
    {
        return this.sesionActual.getClientePorID(idCliente);
    }
    
    public boolean realizarPrestamo(ArrayList<Copia> copiasPrestamo, Cliente clientePrestamo,
            double valorPrestamo)
    {
        return this.sesionActual.crearPrestamo(copiasPrestamo, clientePrestamo, valorPrestamo);
    }
}
