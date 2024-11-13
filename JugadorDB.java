import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JugadorDB {
    public boolean registrarJugador (Jugador jugador) {

        Connection con = ConexionBD.conectarBD();
        String sqlJugador = "INSERT INTO jugador (jugador_dni, jugador_nombre, jugador_apellido, jugador_edad, jugador_goles, jugador_equipo, jugador_tarjetasAmarillas, jugador_tarjetasRojas, jugador_sancionActiva) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sqlJugador);
            stmt.setInt(1, jugador.getJugadorDNI());
            stmt.setString(2, jugador.getJugadorNombre());
            stmt.setString(3, jugador.getJugadorApellido());
            stmt.setInt(4, jugador.getJugadorEdad());
            stmt.setInt(5, jugador.getJugadorGoles());
            stmt.setInt(6, jugador.getIdEquipo());
            stmt.setInt(7, jugador.getTarjetasAmarillas());
            stmt.setInt(8, jugador.getTarjetasRojas());
            stmt.setBoolean(9, jugador.sancionado());
            int filasAgregadas = stmt.executeUpdate();
            return filasAgregadas > 0;
            } catch (SQLException e) {
                System.out.println("Error al registrar jugador: " + e.getMessage());
                return false;
            }
        }

    public Jugador buscarJugador(int dniJugador) {
        Connection con = ConexionBD.conectarBD();
        String sqlBusqueda = "SELECT * FROM jugador WHERE jugador_dni = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sqlBusqueda);
            stmt.setInt(1, dniJugador);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Jugador jugador = new Jugador(
                        rs.getInt("jugador_dni"),
                        rs.getString("jugador_nombre"),
                        rs.getString("jugador_apellido"),
                        rs.getInt("jugador_edad"),
                        rs.getInt("jugador_equipo")
                );
                jugador.setJugadorGoles(rs.getInt("jugador_goles"));
                jugador.setTarjetasAmarillas(rs.getInt("jugador_tarjetasAmarillas"));
                jugador.setTarjetasRojas(rs.getInt("jugador_tarjetasRojas"));

                SancionBD sancionBD = new SancionBD();
                jugador.getSanciones().addAll(sancionBD.buscarSancion(dniJugador));

                return jugador;
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar jugador: " + e.getMessage());
        }
        return null;
    }
    }

