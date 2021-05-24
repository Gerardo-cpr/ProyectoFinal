/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

/**
 *
 * @author gerardo
 */
public class FormatoDeDeudaLiquidada extends javax.swing.JFrame {
    private Cliente cliente;
    private MenuPrincipal menuPrincipal;
    public FormatoDeDeudaLiquidada(Cliente cliente, MenuPrincipal menuPrincipal) {
        this.setAlwaysOnTop(true);
        this.cliente = cliente;
        this.setLocationRelativeTo(null);
        this.menuPrincipal = menuPrincipal;
        initComponents();
        lblNombre.setText("Cliente: " + cliente.getNombre());
        lblTotalPrestamo.setText(lblTotalPrestamo.getText() + cliente.getdeudaTotal() + "$");
        lblPlazo.setText("Plazo de prestamo: " + cliente.getTiempoDePrestamo() + " meses");
        lblF.setText("El cliente " + cliente.getNombre() +  " ha liquidado toda su deuda.");
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblTotalPrestamo = new javax.swing.JLabel();
        lblPlazo = new javax.swing.JLabel();
        lblF = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNombre.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("Nombre");

        lblTotalPrestamo.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lblTotalPrestamo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalPrestamo.setText("Total prestado: ");

        lblPlazo.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lblPlazo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlazo.setText("Plazo de prestamo: ");

        lblF.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblF.setText("El cliente cliente ha liquidado toda su deuda.");

        jButton1.setText("Guardar en pdf");
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
            .addComponent(lblTotalPrestamo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblPlazo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblNombre)
                .addGap(35, 35, 35)
                .addComponent(lblTotalPrestamo)
                .addGap(42, 42, 42)
                .addComponent(lblPlazo)
                .addGap(48, 48, 48)
                .addComponent(lblF)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new ElegirUbicacion(menuPrincipal, tipoDeOperacion.GUARDAR_FORMATO_DEUDA_LIQUIDADA, cliente).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblF;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPlazo;
    private javax.swing.JLabel lblTotalPrestamo;
    // End of variables declaration//GEN-END:variables
}
