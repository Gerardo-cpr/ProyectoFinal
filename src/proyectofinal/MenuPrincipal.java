/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
/**
 *
 * @author Gerardo
 */
public class MenuPrincipal extends javax.swing.JFrame {

    //nombre del usuario que previamente inicio sesion
    private final int encargadoId;
    private final String clientesDB = "sql5407871";
    private final String usuarioDB = "sql5407871";
    private final String contrasenaDB = "Mt1I2E9GtN";
    private ArrayList<Cliente> clientes;
    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal(int encargadoId) {
        initComponents();
        this.setLocationRelativeTo(null);
        pnlBuscar.setVisible(false);
        this.encargadoId = encargadoId;
        clientes = new ArrayList<>();
    }
    
    public void borrarTabla() {
        DefaultTableModel model = (DefaultTableModel) tablaDeudores.getModel();
        model.setRowCount(0);
    }
    //Esta funcion añade una fila a la tabla de clientes
    public void addCliente(Cliente cliente) {
        int montoDelSiguientePago = (cliente.getTiempoDePrestamo() > 0 ? cliente.getdeudaTotal() / cliente.getTiempoDePrestamo() : 0 );
        DefaultTableModel model = (DefaultTableModel) tablaDeudores.getModel();
        model.addRow(new Object[]{cliente.getId(), cliente.getNombre(), cliente.getdeudaTotal(), 
            cliente.getTiempoDePrestamo() - cliente.getMesesPagados()
                , montoDelSiguientePago, 
               cliente.getMontoRestante()});
    }
    //Esta funcion obtiene los datos de la base de datos que contiene informacion de los deudores y la llena
    public final void actualizarTabla() {
        lblCargando.setText("Cargando");
        String consulta = "SELECT* FROM clientes WHERE encargado_id = \"" + encargadoId + "\" " + "ORDER BY monto_restante DESC";
        new AsyncMainTableRefresh(consulta, clientesDB, usuarioDB, contrasenaDB, this, barraDeProgreso, clientes).start();
    }
    public void finalRellenoTabla() {
       lblCargando.setText("Da click en el cliente para mas informacion");
    }
    
    public void mostrarCliente(Cliente cliente) {
         new VentanaCliente(this, cliente, this).setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        lblPrestamos = new javax.swing.JLabel();
        lblCargando = new javax.swing.JLabel();
        pnlTabla = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDeudores = new javax.swing.JTable();
        barraDeProgreso = new javax.swing.JProgressBar();
        btnGuardarPDF = new javax.swing.JButton();
        pnlBuscar = new javax.swing.JPanel();
        txfBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        mnuOpciones = new javax.swing.JMenuBar();
        mniSesion = new javax.swing.JMenu();
        menuCerrarSesion = new javax.swing.JMenuItem();
        mniPrestamos = new javax.swing.JMenu();
        mnuCrearPrestamo = new javax.swing.JMenuItem();
        mniCliente = new javax.swing.JMenu();
        mbxBuscar = new javax.swing.JCheckBoxMenuItem();
        mniCrear = new javax.swing.JMenuItem();
        mniActualizar = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("jMenu5");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenuItem3.setText("jMenuItem3");

        jMenu8.setText("File");
        jMenuBar3.add(jMenu8);

        jMenu9.setText("Edit");
        jMenuBar3.add(jMenu9);

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblPrestamos.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblPrestamos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrestamos.setText("Prestamos");

        lblCargando.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCargando.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCargando.setText("Da click en el cliente para mas informacion");

        tablaDeudores.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        tablaDeudores.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        tablaDeudores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente", "Deuda Total", "Tiempo restante de prestamo", "Monto del siguiente pago", "Monto total deuda restante"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDeudores.setToolTipText("");
        tablaDeudores.setGridColor(new java.awt.Color(51, 153, 255));
        tablaDeudores.setRowHeight(48);
        tablaDeudores.getTableHeader().setResizingAllowed(false);
        tablaDeudores.getTableHeader().setReorderingAllowed(false);
        tablaDeudores.setVerifyInputWhenFocusTarget(false);
        tablaDeudores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDeudoresMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaDeudores);

        btnGuardarPDF.setText("Guardar tabla en pdf");
        btnGuardarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTablaLayout = new javax.swing.GroupLayout(pnlTabla);
        pnlTabla.setLayout(pnlTablaLayout);
        pnlTablaLayout.setHorizontalGroup(
            pnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1049, Short.MAX_VALUE)
            .addGroup(pnlTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardarPDF)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTablaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(barraDeProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        pnlTablaLayout.setVerticalGroup(
            pnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTablaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(barraDeProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btnGuardarPDF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        txfBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfBuscarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBuscarLayout = new javax.swing.GroupLayout(pnlBuscar);
        pnlBuscar.setLayout(pnlBuscarLayout);
        pnlBuscarLayout.setHorizontalGroup(
            pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(txfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnBuscar)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        pnlBuscarLayout.setVerticalGroup(
            pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(btnBuscar))
                .addContainerGap())
        );

        mniSesion.setText("Sesión");
        mniSesion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        menuCerrarSesion.setText("Cerrar sesión");
        menuCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCerrarSesionActionPerformed(evt);
            }
        });
        mniSesion.add(menuCerrarSesion);

        mnuOpciones.add(mniSesion);

        mniPrestamos.setText("Prestamos");
        mniPrestamos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        mnuCrearPrestamo.setText("Crear nuevo prestamo");
        mnuCrearPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCrearPrestamoActionPerformed(evt);
            }
        });
        mniPrestamos.add(mnuCrearPrestamo);

        mnuOpciones.add(mniPrestamos);

        mniCliente.setText("Cliente");
        mniCliente.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        mbxBuscar.setText("Buscar");
        mbxBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbxBuscarActionPerformed(evt);
            }
        });
        mniCliente.add(mbxBuscar);

        mniCrear.setText("Crear");
        mniCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCrearActionPerformed(evt);
            }
        });
        mniCliente.add(mniCrear);

        mniActualizar.setText("Actualizar");
        mniActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniActualizarActionPerformed(evt);
            }
        });
        mniCliente.add(mniActualizar);

        mnuOpciones.add(mniCliente);

        setJMenuBar(mnuOpciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPrestamos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblCargando, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblPrestamos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCargando, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuCrearPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCrearPrestamoActionPerformed
        this.setEnabled(false);
        new CrearPrestamo(clientes, this).setVisible(true);
    }//GEN-LAST:event_mnuCrearPrestamoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       actualizarTabla();
    }//GEN-LAST:event_formWindowOpened

    private void mniCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCrearActionPerformed
        this.setEnabled(false);
        this.setAlwaysOnTop(false);
        new CrearCliente(this, encargadoId, clientes, this, barraDeProgreso).setVisible(true);
    }//GEN-LAST:event_mniCrearActionPerformed

    private void menuCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCerrarSesionActionPerformed
        this.dispose();
        new InicioSesion().setVisible(true);
    }//GEN-LAST:event_menuCerrarSesionActionPerformed

    private void tablaDeudoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDeudoresMouseClicked
        int numeroFila = (int)Math.floor(evt.getY() / 48);
        Cliente clienteSeleccionado = clientes.get(numeroFila);
        if (clienteSeleccionado.getdeudaTotal() > 0.1f) {
            this.setEnabled(false);
            this.setAlwaysOnTop(false);
            mostrarCliente(clienteSeleccionado);
        } else {
            if (JOptionPane.showConfirmDialog(this, "Este cliente no debe nada, ¿Desea borrarlo?", "", JOptionPane.YES_NO_OPTION) == 0) {
                String consulta = "DELETE FROM clientes WHERE id = " + clienteSeleccionado.getId();
                new AsyncDBModification(consulta, this, clientesDB, usuarioDB, contrasenaDB).start();
            }
        }
    }//GEN-LAST:event_tablaDeudoresMouseClicked

    private void txfBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfBuscarActionPerformed
        btnBuscarActionPerformed(null);
    }//GEN-LAST:event_txfBuscarActionPerformed

    private void btnGuardarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPDFActionPerformed
        new ElegirUbicacion(this, tipoDeOperacion.GUARDAR_EN_TABLA).setVisible(true);
    }//GEN-LAST:event_btnGuardarPDFActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String busqueda =txfBuscar.getText();
        AsyncMainTableRefresh.busquedadb(encargadoId, busqueda);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void mbxBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbxBuscarActionPerformed
        if(mbxBuscar.getState() == true){
            pnlBuscar.setVisible(true);
        }else{
            pnlBuscar.setVisible(false);
        }
    }//GEN-LAST:event_mbxBuscarActionPerformed

    private void mniActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniActualizarActionPerformed
        AsyncMainTableRefresh.recargardb();
        txfBuscar.setText("");
    }//GEN-LAST:event_mniActualizarActionPerformed
    public void guardarTablaEnPdf(String nombreDelArchivo) {
        if (PDF.guardarEnArchivo(nombreDelArchivo, clientes)) {
        } else {
            new JOptionPane("Error al guardar el archivo");
        }
    }
    public void guardarFormatoDeudaLiquidadaPdf(String nombreArchivo, Cliente cliente) {
        if (PDF.guardarFormatoDeudaLiquidada(nombreArchivo, cliente)) {
        } else {
            new JOptionPane("Error al guardar el archivo");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JProgressBar barraDeProgreso;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardarPDF;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCargando;
    private javax.swing.JLabel lblPrestamos;
    private javax.swing.JCheckBoxMenuItem mbxBuscar;
    private javax.swing.JMenuItem menuCerrarSesion;
    private javax.swing.JMenuItem mniActualizar;
    private javax.swing.JMenu mniCliente;
    private javax.swing.JMenuItem mniCrear;
    private javax.swing.JMenu mniPrestamos;
    private javax.swing.JMenu mniSesion;
    private javax.swing.JMenuItem mnuCrearPrestamo;
    private javax.swing.JMenuBar mnuOpciones;
    private javax.swing.JPanel pnlBuscar;
    private javax.swing.JPanel pnlTabla;
    private javax.swing.JTable tablaDeudores;
    private javax.swing.JTextField txfBuscar;
    // End of variables declaration//GEN-END:variables
}
