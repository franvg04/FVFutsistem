public class Sancion {
    private int sancionID;
    private int sancionDuracion;
    private String sancionFechaInicio;
    private String sancionFechaFin;
    private Jugador jugador;

    public Sancion (int sancionID, int sancionDuracion, String sancionFechaInicio, String sancionFechaFin, Jugador jugador) {
        this.sancionID = sancionID;
        this.sancionDuracion = sancionDuracion;
        this.sancionFechaInicio = sancionFechaInicio;
        this.sancionFechaFin = sancionFechaFin;
        this.jugador = jugador;
    }

    public int getSancionID() {
        return sancionID;
    }
    public void setSancionID(int sancionID) {
        this.sancionID = sancionID;
    }

    public int getSancionDuracion() {
        return sancionDuracion;
    }
    public void setSancionDuracion(int sancionDuracion) {
        this.sancionDuracion = sancionDuracion;
    }

    public String getSancionFechaInicio() {
        return sancionFechaInicio;
    }
    public void setSancionFechaInicio(String sancionFechaInicio) {
        this.sancionFechaInicio = sancionFechaInicio;
    }

    public String getSancionFechaFin() {
        return sancionFechaFin;
    }
    public void setSancionFechaFin(String sancionFechaFin) {
        this.sancionFechaFin = sancionFechaFin;
    }

    public Jugador getJugador() {
        return jugador;
    }
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    public int getDniJugador() {
        return jugador.getJugadorDNI();
    }
}
