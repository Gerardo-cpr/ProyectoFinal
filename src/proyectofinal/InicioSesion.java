package proyectofinal;

import javax.swing.JOptionPane;	
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gerardo
 */
public class InicioSesion extends javax.swing.JFrame {

    private final String usuariosDB = "sql5407871";
    private final String usuarioDB = "sql5407871";
    private final String contrasenaDB = "Mt1I2E9GtN";
    private int usuarioID = 0;
    public InicioSesion() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txfUsuario = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        lblContra = new javax.swing.JLabel();
        btnIniciarSesion = new javax.swing.JButton();
        btnCrearUsuario = new javax.swing.JButton();
        txfContra = new javax.swing.JPasswordField();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        txfUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfUsuarioKeyTyped(evt);
            }
        });

        lblUsuario.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblUsuario.setText("Usuario");

        lblContra.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblContra.setText("Contraseña");

        btnIniciarSesion.setText("Inciar sesion");
        btnIniciarSesion.setEnabled(false);
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        btnCrearUsuario.setText("Crear usuario");
        btnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });

        txfContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfContraActionPerformed(evt);
            }
        });
        txfContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfContraKeyTyped(evt);
            }
        });

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal/logo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsuario)
                            .addComponent(lblContra))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txfUsuario)
                            .addComponent(txfContra)
                            .addComponent(btnIniciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(btnCrearUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(logo))
                .addGap(124, 124, 124))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(logo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContra)
                    .addComponent(txfContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCrearUsuario)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
            
    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed
        this.setEnabled(false);
        new CrearUsuario(this).setVisible(true);
    }//GEN-LAST:event_btnCrearUsuarioActionPerformed

    private void txfUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfUsuarioKeyTyped
        /// Si el campo usuario o contraseña esta vacio desactiva el boton, si los dos tienen algun valor lo activa
        if (txfUsuario.getText().isEmpty() || txfContra.getPassword().length == 0) {
            btnIniciarSesion.setEnabled(false);
        } else {
            btnIniciarSesion.setEnabled(true);
        }
    }//GEN-LAST:event_txfUsuarioKeyTyped

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        int id = 0;
        BaseDeDatos b = new BaseDeDatos();
        try {
            if (!b.conectar(usuariosDB, usuarioDB, contrasenaDB)){
                JOptionPane.showMessageDialog(this, "Error al conectarse con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
           
            ///Aqui se busca en la base de datos si existe un campo con el mismo usuario y contraseña, de ser asi guarda su id
            ResultSet r = b.cosultar("SELECT* FROM usuarios "
                    + "WHERE contrasena=\"" + new String(txfContra.getPassword()) 
                    + "\" AND usuario=\"" + txfUsuario.getText() + "\"");
            
            if (r != null&& r.next()) {
                id = r.getInt(1);
                usuarioID = id;
            }
            b.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        ///En caso de que el usuario y contraseña concuerden se abre el form principal, si no muestra un mensage de error
        if (id > 0) {
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal(usuarioID).setVisible(true);
            }
        });
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña invalidos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void txfContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfContraActionPerformed
        btnIniciarSesionActionPerformed(null);
    }//GEN-LAST:event_txfContraActionPerformed

    private void txfContraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfContraKeyTyped
         /// Si el campo usuario o contraseña esta vacio desactiva el boton, si los dos tienen algun valor lo activa
        if (txfUsuario.getText().isEmpty() || txfContra.getPassword().length == 0) {
            btnIniciarSesion.setEnabled(false);
        } else {
            btnIniciarSesion.setEnabled(true);
        }
    }//GEN-LAST:event_txfContraKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearUsuario;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JLabel lblContra;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel logo;
    private javax.swing.JPasswordField txfContra;
    private javax.swing.JTextField txfUsuario;
    // End of variables declaration//GEN-END:variables
}
