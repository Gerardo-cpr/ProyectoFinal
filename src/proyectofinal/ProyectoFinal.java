package proyectofinal;

/**
 *
 * @author Gerardo, Julio y Adriel
 */
public class ProyectoFinal {
    public static void main(String[] args) {
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioSesion().setVisible(true);
            }
        });
    }
}
