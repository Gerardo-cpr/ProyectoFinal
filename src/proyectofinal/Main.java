package proyectofinal;

public class Main {

    public static void main(String[] args) {
            System.out.println("Working Directory = " + System.getProperty("user.dir"));

         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
                System.out.println("No se encontro el tema de windows");
                if ("Mac OS X".equals(info.getName())) {
                     javax.swing.UIManager.setLookAndFeel(info.getClassName());
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormatoDeDeudaLiquidada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormatoDeDeudaLiquidada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormatoDeDeudaLiquidada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormatoDeDeudaLiquidada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
	new InicioSesion().setVisible(true);
    }
}
