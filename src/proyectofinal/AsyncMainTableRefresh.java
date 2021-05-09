package proyectofinal;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author gerardo
 */
public class AsyncMainTableRefresh extends Thread {
   private static boolean parametros = false;
   private static String consulta;
   private static String nombre;
   private static String usuario;
   private static String contra;
   private static MenuPrincipal menu;
   private static ResultSet respuesta;
   private static JProgressBar progreso;
   private static ArrayList<Cliente> clientes;

    public AsyncMainTableRefresh() {
    }
    public AsyncMainTableRefresh(String consulta, String nombre, String usuario, String contra, MenuPrincipal menu, JProgressBar progreso, ArrayList<Cliente> clientes) {
        parametros = true;
        this.consulta = consulta;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contra = contra;
        this.menu = menu;
        this.progreso = progreso;
        this.clientes = clientes;
    }
    @Override
    public void run() {
        BaseDeDatos db = new BaseDeDatos();
        try {
            progreso.setValue(25);
            db.conectar(nombre, usuario, contra);
            progreso.setValue(50);
            respuesta = db.cosultar(consulta);
            progreso.setValue(75);
            menu.borrarTabla();
            clientes.removeAll(clientes);
            while(respuesta.next()) {
                int id = respuesta.getInt("id");
                int encargado_id = respuesta.getInt("encargado_id");
                String nombre = respuesta.getString("nombre");
                int mesesPagados = respuesta.getInt("meses_pagados");
                int tiempoPrestamo = respuesta.getInt("tiempo_prestamo");
                float totalPrestado = respuesta.getFloat("total_prestado");
                float montoRestante = respuesta.getFloat("monto_restante");
                Cliente cliente = new Cliente(id, nombre, mesesPagados, tiempoPrestamo, encargado_id, totalPrestado, montoRestante);
                menu.addCliente(cliente); //Es importante que se
                clientes.add(cliente);    //añadan en el mismo orden
            }
            db.desconectar();
            progreso.setValue(100);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectarse con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        menu.finalRellenoTabla();
  }
    
    public static void recargardb() {
        BaseDeDatos db = new BaseDeDatos();
        try {
            db.conectar(nombre, usuario, contra);
            respuesta = db.cosultar(consulta);
            menu.borrarTabla();
            clientes.removeAll(clientes);
            while(respuesta.next()) {
                int id = respuesta.getInt("id");
                int encargado_id = respuesta.getInt("encargado_id");
                String nombre = respuesta.getString("nombre");
                int mesesPagados = respuesta.getInt("meses_pagados");
                int tiempoPrestamo = respuesta.getInt("tiempo_prestamo");
                float totalPrestado = respuesta.getFloat("total_prestado");
                float montoRestante = respuesta.getFloat("monto_restante");
                Cliente cliente = new Cliente(id, nombre, mesesPagados, tiempoPrestamo, encargado_id, totalPrestado, montoRestante);
                menu.addCliente(cliente); //Es importante que se
                clientes.add(cliente);    //añadan en el mismo orden
            }
            db.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectarse con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        menu.finalRellenoTabla();
  }
        public static void busquedadb(int encargadoId, String busqueda) {
        BaseDeDatos db = new BaseDeDatos();
        try {
            db.conectar(nombre, usuario, contra);
            respuesta = db.cosultar("SELECT * FROM clientes WHERE encargado_id LIKE '"+encargadoId+"' AND nombre LIKE '%"+busqueda+"%' ORDER BY monto_restante DESC");
            menu.borrarTabla();
            clientes.removeAll(clientes);
            while(respuesta.next()) {
                int id = respuesta.getInt("id");
                int encargado_id = respuesta.getInt("encargado_id");
                String nombre = respuesta.getString("nombre");
                int mesesPagados = respuesta.getInt("meses_pagados");
                int tiempoPrestamo = respuesta.getInt("tiempo_prestamo");
                float totalPrestado = respuesta.getFloat("total_prestado");
                float montoRestante = respuesta.getFloat("monto_restante");
                Cliente cliente = new Cliente(id, nombre, mesesPagados, tiempoPrestamo, encargado_id, totalPrestado, montoRestante);
                menu.addCliente(cliente); //Es importante que se
                clientes.add(cliente);    //añadan en el mismo orden
            }
            db.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectarse con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        menu.finalRellenoTabla();
  }
}