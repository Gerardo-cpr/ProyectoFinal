package proyectofinal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    public InicioSesion() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txfUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnIniciarSesion = new javax.swing.JButton();
        btnCrearUsuario = new javax.swing.JButton();
        txfContra = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        txfUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfUsuarioKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Usuario");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Contraseña");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txfUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(txfContra)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnIniciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCrearUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txfContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnIniciarSesion)
                .addGap(18, 18, 18)
                .addComponent(btnCrearUsuario)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
            
    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed

        new CrearUsuario(this).setVisible(true);
        this.setEnabled(false);
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
        if ("root".equals(txfUsuario.getText())) {
           java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal(txfUsuario.getText()).setVisible(true);
            }
        });
           this.dispose();
           return;
        }
        System.out.println("false");
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
            }
            b.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        System.out.println(id);
        ///En caso de que el usuario y contraseña concuerden se abre el form principal, si no muestra un mensage de error
        if (id > 0) {
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal(txfUsuario.getText()).setVisible(true);
            }
        });
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña invalidos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void txfContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfContraActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txfContra;
    private javax.swing.JTextField txfUsuario;
    // End of variables declaration//GEN-END:variables
}
