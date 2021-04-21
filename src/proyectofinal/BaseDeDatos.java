package proyectofinal;
/**
 *
 * @author Gerardo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class BaseDeDatos {
    private String url = "jdbc:mysql://127.0.0.1/";
    private Connection conexion;
    private boolean conectado;
    
    public BaseDeDatos() {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void conectar(String nombre, String usuario, String contra) {
        if (nombre.isEmpty() || usuario.isEmpty()) {
        }
        try {
            conexion = DriverManager.getConnection(url + nombre, usuario, contra);
            Statement s = conexion.createStatement();
            conectado = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR AL CONECTARSE A LA BASE DE DATOS");
        }
    }
    public ResultSet cosultar(String consulta){
        if (conectado) {
            try {
                return conexion.createStatement().executeQuery(consulta);
            }   catch(SQLException e) {
                e.printStackTrace();
                System.out.println("No se puedo realizar la consulta");
                return null;
            }
        } else {
            System.out.println("No se encuentra conectado");
            return null;
        }
    }
    public Object getCampo()  {
        return null;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
