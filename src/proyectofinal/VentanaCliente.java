/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gerardo
 */
public class VentanaCliente extends javax.swing.JFrame {
    private final String clientesDB = "sql5407871";
    private final String usuarioDB = "sql5407871";
    private final String contrasenaDB = "Mt1I2E9GtN";
    Cliente cliente;
    javax.swing.JFrame parent;
    MenuPrincipal menuPrincipal;
    
    public VentanaCliente(javax.swing.JFrame parent, Cliente cliente, MenuPrincipal menuPrincipal) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //this.setAlwaysOnTop(true);
        this.parent = parent;
        this.cliente = cliente;
        this.menuPrincipal = menuPrincipal;
        llenarDatosCliente();
        inicializarAbonar();
    }
    //Inicializa la parte de cliente
    void llenarDatosCliente() {
        lblNombre.setText("Cliente: " + cliente.getNombre());
        lblMontoPrestado.setText("Monto de la deuda: " + cliente.getdeudaTotal());
        lblTiempoPrestamo.setText("Tiempo de prestamo: " + cliente.getTiempoDePrestamo());
        float totalPagado = cliente.getMesesPagados() * (cliente.getdeudaTotal() / cliente.getTiempoDePrestamo());
        lblTotalPagado.setText("Total pagado: " + totalPagado + " (" + cliente.getMesesPagados() + " meses)");
        int mesesRestantes = cliente.getTiempoDePrestamo() - cliente.getMesesPagados();
        lblRestante.setText("Restante: " + (cliente.getMontoRestante()) + " (" + mesesRestantes + " meses)");
    }
    //Inicializa la parte de Abonar
    void inicializarAbonar() {
        if (cliente.getMontoRestante() > 0) {
            int mesesRestantes = cliente.getTiempoDePrestamo() - cliente.getMesesPagados();
            for(int i = 1; i <= mesesRestantes; i++) {
                cbMesesAbonar.addItem(i + " meses");
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblMontoPrestado = new javax.swing.JLabel();
        lblTiempoPrestamo = new javax.swing.JLabel();
        lblTotalPagado = new javax.swing.JLabel();
        lblRestante = new javax.swing.JLabel();
        pAbonar = new javax.swing.JPanel();
        lblRestanteConAbono = new javax.swing.JLabel();
        btnPagar = new javax.swing.JToggleButton();
        cbMesesAbonar = new javax.swing.JComboBox<>();
        lblMesesAPagar = new javax.swing.JLabel();
        lblAbonar = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cliente");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("Cliente:");

        lblMontoPrestado.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lblMontoPrestado.setText("Monto de la deuda: ");

        lblTiempoPrestamo.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblTiempoPrestamo.setText("Tiempo de prestamo: ");

        lblTotalPagado.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblTotalPagado.setText("Total pagado: x (n meses)");

        lblRestante.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblRestante.setText("Restante: x (n meses)");

        lblRestanteConAbono.setText("Con el abono quedarian: n xxxx (nmeses)");

        btnPagar.setText("Pagar n ");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        cbMesesAbonar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMesesAbonarItemStateChanged(evt);
            }
        });

        lblMesesAPagar.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblMesesAPagar.setText("Meses a pagar");

        javax.swing.GroupLayout pAbonarLayout = new javax.swing.GroupLayout(pAbonar);
        pAbonar.setLayout(pAbonarLayout);
        pAbonarLayout.setHorizontalGroup(
            pAbonarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAbonarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRestanteConAbono)
                .addGap(84, 84, 84))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pAbonarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMesesAPagar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbMesesAbonar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPagar, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addContainerGap())
        );
        pAbonarLayout.setVerticalGroup(
            pAbonarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAbonarLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pAbonarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMesesAbonar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMesesAPagar)
                    .addComponent(btnPagar))
                .addGap(28, 28, 28)
                .addComponent(lblRestanteConAbono)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        lblAbonar.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        lblAbonar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAbonar.setText("Abonar");

        jButton1.setText("Borrar cliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTotalPagado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRestante)
                            .addComponent(lblTiempoPrestamo)
                            .addComponent(lblMontoPrestado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(83, 83, 83))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pAbonar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblAbonar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNombre)
                .addGap(24, 24, 24)
                .addComponent(lblMontoPrestado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTiempoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalPagado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRestante)
                .addGap(18, 18, 18)
                .addComponent(lblAbonar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pAbonar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        parent.setVisible(true);
        parent.setEnabled(true);
        // parent.setAlwaysOnTop(true);
    }//GEN-LAST:event_formWindowClosed

    private void cbMesesAbonarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMesesAbonarItemStateChanged
        int mesesAPagar = cbMesesAbonar.getSelectedIndex() + 1;
        float montoPorMes = (float)cliente.getdeudaTotal() / (float)cliente.getTiempoDePrestamo();
        float montoAPagar = (int)(montoPorMes * mesesAPagar);
        btnPagar.setText("Pagar: " + montoAPagar);
        float montoRestanteConElAbono = cliente.getMontoRestante() - montoAPagar;
        lblRestanteConAbono.setText("Con el abono quedarian: " + (montoRestanteConElAbono < 0 ? 0 : montoRestanteConElAbono));
        
    }//GEN-LAST:event_cbMesesAbonarItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            BaseDeDatos db = new BaseDeDatos();
            int id=cliente.getId();
            db.conectar(clientesDB, usuarioDB, contrasenaDB);
            String consulta = "DELETE FROM clientes WHERE id = "+id;
            db.modificar(consulta);
            db.desconectar();
            AsyncMainTableRefresh.recargardb();
            JOptionPane.showMessageDialog(this, "Cliente borrado exitosamente", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            this.setAlwaysOnTop(false);
            this.dispose();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al borrar cliente", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        int mesesAPagar = cbMesesAbonar.getSelectedIndex() + 1;
        int montoPorMes = Math.round(cliente.getdeudaTotal() / cliente.getTiempoDePrestamo() + 1);
        int montoAPagar = (int)montoPorMes * mesesAPagar;
        int mesesPagados = cliente.getMesesPagados() + mesesAPagar;
        int montoRestante = (int)cliente.getMontoRestante() - montoAPagar;
        String consulta;
        if (montoRestante > 2) {
            consulta = "UPDATE clientes SET meses_pagados = " + String.valueOf(mesesPagados) 
                + ", monto_restante = " + montoRestante + " WHERE Id = " + cliente.getId();
        } else {
            consulta = "UPDATE clientes SET deuda_total = 0, meses_pagados = 0"
                + ", monto_restante = 0, tiempo_prestamo = 0" + " WHERE Id = " + cliente.getId();;
        }
        new AsyncDBModification(consulta, menuPrincipal, clientesDB, usuarioDB, contrasenaDB).start();
        this.dispose();
    }//GEN-LAST:event_btnPagarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnPagar;
    private javax.swing.JComboBox<String> cbMesesAbonar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblAbonar;
    private javax.swing.JLabel lblMesesAPagar;
    private javax.swing.JLabel lblMontoPrestado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRestante;
    private javax.swing.JLabel lblRestanteConAbono;
    private javax.swing.JLabel lblTiempoPrestamo;
    private javax.swing.JLabel lblTotalPagado;
    private javax.swing.JPanel pAbonar;
    // End of variables declaration//GEN-END:variables
}
