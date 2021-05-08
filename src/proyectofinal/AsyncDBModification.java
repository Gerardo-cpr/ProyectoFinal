/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public AsyncDBModification(String consulta, MenuPrincipal menuPrincipal, String nombre, String usuario, String contra) {
        this.consulta = consulta;
        this.menuPrincipal = menuPrincipal;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contra = contra;
    }
  
    public void run() {
        try {
            BaseDeDatos db = new BaseDeDatos();
            db.conectar(nombre, usuario, contra);
            db.modificar(consulta);
            menuPrincipal.actualizarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(AsyncDBModification.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
