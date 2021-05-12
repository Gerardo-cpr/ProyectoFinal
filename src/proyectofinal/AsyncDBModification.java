/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gerardo
 */
public class AsyncDBModification extends Thread{
    
    private String consulta;
    private MenuPrincipal menuPrincipal;
    private String nombre;
    private String usuario;
    private String contra;
    private CrearUsuario crearUsuario;

    public AsyncDBModification(String consulta, MenuPrincipal menuPrincipal, String nombre, String usuario, String contra) {
        this.consulta = consulta;
        this.menuPrincipal = menuPrincipal;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contra = contra;
    }
     public AsyncDBModification(String consulta, CrearUsuario crearUsuario, String nombre, String usuario, String contra) {
        this.consulta = consulta;
        this.crearUsuario = crearUsuario;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contra = contra;
    }
  
    public void run() {
        try {
            BaseDeDatos db = new BaseDeDatos();
            db.conectar(nombre, usuario, contra);
            db.modificar(consulta);
            if (menuPrincipal != null) {
                menuPrincipal.actualizarTabla();
            } else {
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(AsyncDBModification.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
