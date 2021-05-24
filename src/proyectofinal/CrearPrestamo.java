package proyectofinal;

import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author gerardo, Julio, Adriel
 */
public class CrearPrestamo extends javax.swing.JFrame {

    private ArrayList<Cliente> clientes;
    private final String clientesDB = "sql5407871";
    private final String usuarioDB = "sql5407871";
    private final String contrasenaDB = "Mt1I2E9GtN";
    private MenuPrincipal parent;
    public CrearPrestamo(ArrayList<Cliente> clientes, MenuPrincipal parent) {
        initComponents();
        // this.setAlwaysOnTop(true);
        this.parent = parent;
        this.clientes = clientes;
        this.setLocationRelativeTo(null);
        AsyncMainTableRefresh.recargardb();
        iniciarlizarInterfaz();
    }
    private void iniciarlizarInterfaz() {
        for (Cliente cliente : clientes) {
            cbxClientes.addItem(cliente.getNombre());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPrestamo = new javax.swing.JLabel();
        cbxClientes = new javax.swing.JComboBox<>();
        lblCliente = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        btnPrestar = new javax.swing.JButton();
        lblTiempoPrestamo = new javax.swing.JLabel();
        cbxTiempoPrestamo = new javax.swing.JComboBox<>();
        tbxCantidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        lblPrestamo.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lblPrestamo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrestamo.setText("Conceder prestamo");

        lblCliente.setText("Cliente");

        lblCantidad.setText("Cantidad");

        btnPrestar.setText("Prestar");
        btnPrestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestarActionPerformed(evt);
            }
        });

        lblTiempoPrestamo.setText("Tiempo de prestamo");

        cbxTiempoPrestamo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 mes", "2 meses", "6 meses", "12 meses" }));

        tbxCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbxCantidadActionPerformed(evt);
            }
        });
        tbxCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbxCantidadKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPrestamo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTiempoPrestamo)
                    .addComponent(lblCantidad)
                    .addComponent(lblCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxTiempoPrestamo, 0, 115, Short.MAX_VALUE)
                    .addComponent(cbxClientes, 0, 115, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btnPrestar))
                    .addComponent(tbxCantidad))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblPrestamo)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCliente))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxTiempoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTiempoPrestamo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantidad)
                    .addComponent(tbxCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(btnPrestar)
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestarActionPerformed
        if (clientes.get(cbxClientes.getSelectedIndex()).getdeudaTotal() > 0.1f) {
            JOptionPane.showMessageDialog(this, "Este cliente ya tiene un prestamo en curso", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int tiempoDePrestamo;
        switch (cbxTiempoPrestamo.getSelectedIndex()) {
            case 0:
                tiempoDePrestamo = 1;
                break;
            case 1:
                tiempoDePrestamo = 2;
                break;
            case 2:
                tiempoDePrestamo = 6;
                break;
            case 3:
                tiempoDePrestamo = 12;
                break;
            default:
                tiempoDePrestamo = 0;
                break;
        }
        try {
            Float.parseFloat(tbxCantidad.getText());
        } catch(java.lang.NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Introduce la cantidad a prestar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        float intereses = Math.round(Float.parseFloat(tbxCantidad.getText())*0.10*tiempoDePrestamo);
        float deuda = Float.parseFloat(tbxCantidad.getText())+intereses;
        BaseDeDatos db = new BaseDeDatos();
        try {
            db.conectar(clientesDB, usuarioDB, contrasenaDB);
            String consulta = "UPDATE clientes" + " SET tiempo_prestamo = " + tiempoDePrestamo
                    + ", deuda_total = " + deuda + ", monto_restante = " + deuda + " WHERE nombre = " 
                    + "\'" + clientes.get(cbxClientes.getSelectedIndex()).getNombre() + "\'";
            db.modificar(consulta);
            JOptionPane.showMessageDialog(this, "Prestamo creado correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            parent.setVisible(true);
            this.dispose();
            AsyncMainTableRefresh.recargardb();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al otorgar el prestamo", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnPrestarActionPerformed

    private void tbxCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbxCantidadActionPerformed
        btnPrestarActionPerformed(null);
    }//GEN-LAST:event_tbxCantidadActionPerformed

    private boolean esFloat(char c) {
        try {
            Float.parseFloat(String.valueOf(c));
        } catch (java.lang.NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    private void tbxCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbxCantidadKeyTyped
        //Si el caracter introducido no es un numero no se permite colocarlo
        if ( !(esFloat(evt.getKeyChar()))) {
            evt.consume();
        }
    }//GEN-LAST:event_tbxCantidadKeyTyped

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        parent.setVisible(true);
        parent.setEnabled(true);
        // parent.setAlwaysOnTop(true);
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrestar;
    private javax.swing.JComboBox<String> cbxClientes;
    private javax.swing.JComboBox<String> cbxTiempoPrestamo;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblPrestamo;
    private javax.swing.JLabel lblTiempoPrestamo;
    private javax.swing.JTextField tbxCantidad;
    // End of variables declaration//GEN-END:variables
}
