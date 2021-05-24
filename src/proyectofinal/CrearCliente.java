package proyectofinal;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author Gerardo, Julio y Adriel
 */
public class CrearCliente extends javax.swing.JFrame {

    private final String clientesDB = "sql5407871";
    private final String usuarioDB = "sql5407871";
    private final String contrasenaDB = "Mt1I2E9GtN";
    private MenuPrincipal menuPrincipal;
    private ArrayList<Cliente> clientes;
    private int encargadoID;
    private JProgressBar barraDeProgreso;   
    public CrearCliente(javax.swing.JFrame parent, int encargadoID, ArrayList<Cliente> clientes, MenuPrincipal menuPrincipal ,JProgressBar barraDeProgreso) {
        initComponents();
        this.clientes = clientes;
        setLocationRelativeTo(null);
        this.parent = parent;
        this.encargadoID = encargadoID;
        this.barraDeProgreso = barraDeProgreso;
        this.menuPrincipal = menuPrincipal;
    }
    private javax.swing.JFrame parent;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCrear = new javax.swing.JButton();
        lblNombreCliente = new javax.swing.JTextField();
        lblCrearUsuario = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        lblNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblNombreClienteActionPerformed(evt);
            }
        });

        lblCrearUsuario.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblCrearUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCrearUsuario.setText("Crear usuario");

        lblNombre.setText("Nombre:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCrearUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNombre)
                        .addGap(18, 18, 18)
                        .addComponent(lblNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblCrearUsuario)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre))
                .addGap(40, 40, 40)
                .addComponent(btnCrear)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        parent.setEnabled(true);
        //parent.setAlwaysOnTop(true);
        parent.setVisible(true);
    }//GEN-LAST:event_formWindowClosed
    private boolean existeCliente(String nombre) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }
    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        if (lblNombreCliente.getText().length() < 1 || lblNombreCliente.getText().charAt(0) == ' ') {
            JOptionPane.showMessageDialog(this, "Nombre invalido", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (existeCliente(lblNombreCliente.getText())) {
            JOptionPane.showMessageDialog(this, "Ya existe un cliente con el mismo nombre", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            BaseDeDatos db = new BaseDeDatos();
            db.conectar(clientesDB, usuarioDB, contrasenaDB);
            String consulta = "INSERT INTO clientes" + " (encargado_id, nombre, meses_pagados, tiempo_prestamo, deuda_total, monto_restante"
                    + ") VALUES (" + encargadoID + ", " + "'" + lblNombreCliente.getText() + "'"  + ", 0, 0, 0, 0)";
            db.modificar(consulta);
            db.desconectar();
            consulta = "SELECT* FROM clientes WHERE encargado_id = \"" + encargadoID + "\" " + "ORDER BY monto_restante DESC";
            new AsyncMainTableRefresh(consulta, clientesDB, usuarioDB, contrasenaDB, menuPrincipal, barraDeProgreso, clientes).start();
            JOptionPane.showMessageDialog(this, "Cliente creado correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            this.setAlwaysOnTop(false);
            parent.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar al cliente", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void lblNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblNombreClienteActionPerformed
        btnCrearActionPerformed(null);
    }//GEN-LAST:event_lblNombreClienteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JLabel lblCrearUsuario;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField lblNombreCliente;
    // End of variables declaration//GEN-END:variables
}
