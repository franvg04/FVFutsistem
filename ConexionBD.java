import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexionBD {
    public static Connection conectarBD() {
        try {
            String url = "jdbc:mysql://localhost:3306/fvfutsistem";
            String usuario = "root";
            String contrasena = "";
            Connection con = DriverManager.getConnection(url, usuario, contrasena);
            return con;
        } catch (SQLException e) {
            System.out.println("Error en la conexión" + e.getMessage());
            return null;
        }
    }
}
