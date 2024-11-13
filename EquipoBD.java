import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipoBD {

    // Método para registrar un equipo
    public boolean registrarEquipo(Equipo equipo) {
        Connection con = ConexionBD.conectarBD();
        String sql = "INSERT INTO equipo (equipo_id, equipo_nombre, equipo_localidad) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, equipo.getEquipoID());
            stmt.setString(2, equipo.getEquipoNombre());
            stmt.setString(3, equipo.getEquipoLocalidad());

            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al registrar el equipo: " + e.getMessage());
            return false;
        }
    }

    public String buscarEquipo (int idEquipo) {

        Connection con = ConexionBD.conectarBD();
        String sql = "SELECT equipo_nombre FROM equipo WHERE equipo_id = ?";
        String nombreEquipo = null;
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idEquipo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                nombreEquipo = rs.getString("equipo_nombre");
            }
        } catch (SQLException e) {
            System.out.println("SIN EQUIPO");
        }
        return nombreEquipo;
    }
}
