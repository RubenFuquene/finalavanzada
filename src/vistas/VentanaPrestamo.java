/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.ControladorGlobal;
import controladores.ControladorVentanaPrestamo;
import configuracion.VariablesConexion;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import negocio.entidades.Cliente;
import negocio.entidades.Copia;

/**
 *
 * @author Rubén
 */
public class VentanaPrestamo extends javax.swing.JFrame
{
    private ControladorVentanaPrestamo controlador;
    private ArrayList<Copia> copiasParaPrestamo;
    private Cliente elClientedelPrestamo;
    
    /**
     * Creates new form VentanaPrestamo
     */
    public VentanaPrestamo(ControladorVentanaPrestamo control)
    {
        this.controlador = control;
        initComponents();
        this.inicializarTabla();
        setLocationRelativeTo(null);
        labelNombreEmpleado.setText(control.getSesionActual().getEmpleadoAsociadoSesion().getNombre()
                + " " + control.getSesionActual().getEmpleadoAsociadoSesion().getApellido());
        copiasParaPrestamo = new ArrayList<Copia>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtValorPrestamo = new javax.swing.JTextField();
        labelCliente = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFiltroPeliculas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtActor = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMembresiaCliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        labelNombreEmpleado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/escudo_UD.jpeg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel2.setText("Préstamo de títulos");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel4.setText("Detalle de Préstamo");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CÓDIGO", "TÍTULO", "FORMATO", "QUITAR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jScrollPane1.setViewportView(jScrollPane2);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Valor");

        txtValorPrestamo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtValorPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorPrestamoActionPerformed(evt);
            }
        });

        labelCliente.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        labelCliente.setText("Cliente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtValorPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(labelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtValorPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel3.setText("Búsqueda de título");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Película");

        txtFiltroPeliculas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFiltroPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroPeliculasActionPerformed(evt);
            }
        });
        txtFiltroPeliculas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AccionFiltroPelicula(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Actor");

        txtActor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActorActionPerformed(evt);
            }
        });
        txtActor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                filtroActor(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtFiltroPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(63, 63, 63)
                        .addComponent(txtActor, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFiltroPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtActor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel8.setText("Búsqueda de cliente");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Membresía cliente");

        txtMembresiaCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMembresiaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMembresiaClienteActionPerformed(evt);
            }
        });
        txtMembresiaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AccionMembresia(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtMembresiaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(69, 69, 69)))
                .addGap(31, 31, 31))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtMembresiaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel10.setText("Bienvenido");

        labelNombreEmpleado.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNombreEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelNombreEmpleado))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFiltroPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroPeliculasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroPeliculasActionPerformed

    private void txtActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtActorActionPerformed

    private void txtMembresiaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMembresiaClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMembresiaClienteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(this.controlador.realizarPrestamo(copiasParaPrestamo, elClientedelPrestamo,
                Double.parseDouble(txtValorPrestamo.getText())))
        {
            /*JOptionPane.showMessageDialog(null, "Prestamo realizado con éxito");
            txtFiltroPeliculas.setText("");
            txtActor.setText("");
            txtMembresiaCliente.setText("");
            labelCliente.setText(VariablesConexion.CABEZA_CLIENTE_PRESTAMO);
            copiasParaPrestamo = new ArrayList<Copia>();
            this.agregarCintaAlPrestamo(0);
            txtValorPrestamo.setText("");*/
        }else
        {
            JOptionPane.showMessageDialog(null, "no se pudo procesar su solicitud de préstamo");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtValorPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorPrestamoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorPrestamoActionPerformed

    private void AccionFiltroPelicula(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AccionFiltroPelicula
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            controlador.getCintasDisponiblesPorTitulo(txtFiltroPeliculas.getText());
        }
    }//GEN-LAST:event_AccionFiltroPelicula

    private void filtroActor(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroActor
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            controlador.getPeliculasPorActor(txtActor.getText());
        }
    }//GEN-LAST:event_filtroActor

    private void AccionMembresia(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AccionMembresia
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            Cliente elCliente;
            
            elCliente = controlador.getClientePorID(Integer.parseInt(txtMembresiaCliente.getText()));
            
            labelCliente.setText(labelCliente.getText() + ": " + elCliente.getNombre()
                    + " " + elCliente.getApellido() + VariablesConexion.CREDITO_CLIENTE_PRESTAMO
                    + elCliente.getCredito());
            
            this.elClientedelPrestamo = elCliente;
        }
    }//GEN-LAST:event_AccionMembresia

    
    
    private void inicializarTabla()
    {
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
    }
    
    public void agregarCintaAlPrestamo(int id)
    {
        if(id > 0)
            copiasParaPrestamo.add(this.controlador.getCopiaPorID(id));
        
        DefaultTableModel modeloTabla = new DefaultTableModel(null,
            new String[] {
                "Código", "Título", "Formato", "Añadir"
            }
            ){
                boolean[] columnEditables = new boolean[] {
                    false, false, false, false
                };
                public boolean isCellEditable(int row, int column) {
                    return columnEditables[column];
                }
            };
        
        JButton btn_agregar = new JButton("Agregar");
	btn_agregar.setName("AGREGAR");
	Object registros[] = new Object[4];
	for(Copia cadaCopia : this.copiasParaPrestamo)
        {
            registros[0] = cadaCopia.getId();
            registros[1] = cadaCopia.getPelicula().getTitulo();
            registros[2] = cadaCopia.getFormato().getDescripcion();
            registros[3] = "QUITAR";
            //registros.add(nuevoCheck);

            modeloTabla.addRow(registros);
        }
        
        jTable1.setModel(modeloTabla);
        
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }
    }
    
    int clic_tabla = 0;

    private int intas = 0;
    private void tablaMouseClicked(java.awt.event.MouseEvent evt)
    {
        clic_tabla = this.jTable1.rowAtPoint(evt.getPoint());
        
        String id = jTable1.getValueAt(clic_tabla, 0).toString();
        
        boolean revisar = true;
        int cadaCopia = 0;
        do
        {
            System.out.println(copiasParaPrestamo.get(cadaCopia).getId() + " == "
                    + Integer.parseInt(id) + " -> " + (copiasParaPrestamo.get(cadaCopia).getId() == Integer.parseInt(id)));
            
            if(copiasParaPrestamo.get(cadaCopia).getId() == Integer.parseInt(id))
            {
                revisar = false;
                copiasParaPrestamo.remove(cadaCopia);
            }
            cadaCopia++;
        } while (revisar);
        
        this.agregarCintaAlPrestamo(0);
    }                                  
    
    public JTextField getTxtFiltroPeliculas() {
        return txtFiltroPeliculas;
    }

    public JTextField getTxtActor() {
        return txtActor;
    }

    public void setElClientedelPrestamo(Cliente elClientedelPrestamo) {
        this.elClientedelPrestamo = elClientedelPrestamo;
    }

    public ArrayList<Copia> getCopiasParaPrestamo() {
        return copiasParaPrestamo;
    }
    
    public void mensajePrestamoExitoso()
    {
        JOptionPane.showMessageDialog(null, "Prestamo realizado con éxito");
    }
    
    public void mensajeNoSeRealizaPrestamo()
    {
        JOptionPane.showMessageDialog(null, "no se pudo procesar su solicitud de préstamo");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelNombreEmpleado;
    private javax.swing.JTextField txtActor;
    private javax.swing.JTextField txtFiltroPeliculas;
    private javax.swing.JTextField txtMembresiaCliente;
    private javax.swing.JTextField txtValorPrestamo;
    // End of variables declaration//GEN-END:variables
}
