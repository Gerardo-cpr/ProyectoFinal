/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author gerardo
 */
public class AsyncDB extends Thread {
    boolean parametros = false;
    String consulta;
    String nombre;
    String usuario;
    String contra;
    MenuPrincipal menu;
    ResultSet respuesta;
    JProgressBar progreso;
    public AsyncDB(String consulta, String nombre, String usuario, String contra, MenuPrincipal menu, JProgressBar progreso) {
        parametros = true;
        this.consulta = consulta;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contra = contra;
        this.menu = menu;
        this.progreso = progreso;
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
            while(respuesta.next()) {
                int mesesPagados = respuesta.getInt("meses_pagados");
                int tiempoPrestamo = respuesta.getInt("tiempo_prestamo");
                float totalPrestado = respuesta.getFloat("total_prestado");
                float montoRestante = respuesta.getFloat("monto_restante");
                menu.addFilaTabla(respuesta.getString("nombre"), totalPrestado, tiempoPrestamo - mesesPagados, totalPrestado / tiempoPrestamo, 
                        totalPrestado - ((totalPrestado / tiempoPrestamo) * mesesPagados));
                }
            db.desconectar();
            progreso.setValue(100);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectarse con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        menu.finalRellenoTabla();
  }
}