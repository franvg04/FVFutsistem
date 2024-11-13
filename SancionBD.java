import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SancionBD {
     public boolean registrarSancion (Sancion sancion) {
         Connection con = ConexionBD.conectarBD();
         String sql = "INSERT INTO sancion (sancion_id, sancion_duracion, sancion_fechaInicio, sancion_fechaFin, sancion_jugadorDNI) VALUES (?, ?, ?, ?, ?)";
         try {
             PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setInt(1, sancion.getSancionID());
             stmt.setInt(2, sancion.getSancionDuracion());
             stmt.setString(3, sancion.getSancionFechaInicio());
             stmt.setString(4, sancion.getSancionFechaFin());
             stmt.setInt(5, sancion.getJugador().getJugadorDNI());

             int filasInsertadas = stmt.executeUpdate();
             return filasInsertadas > 0;
         } catch (SQLException e) {
             System.out.println("Error al cargar la sancion: " + e.getMessage());
             return false;
         }
     }

    public List<Sancion> buscarSancion(int dniJugador) {
        List<Sancion> sanciones = new ArrayList<>();
        Connection con = ConexionBD.conectarBD();
        String sql = "SELECT * FROM sancion WHERE sancion_jugadorDNI = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, dniJugador);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Sancion sancion = new Sancion(
                        rs.getInt("sancion_id"),
                        rs.getInt("sancion_duracion"),
                        rs.getString("sancion_fechaInicio"),
                        rs.getString("sancion_fechaFin"),
                        null
                );
                sanciones.add(sancion);
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar las sanciones del jugador: " + e.getMessage());
        }
        return sanciones;
    }
}
