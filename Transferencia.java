public class Transferencia {
    private int transferenciaID;
    private Jugador jugador;
    private int equipoAntId;
    private int equipoActId;
    private String fechaTransferencia;

    public Transferencia (int transferenciaID, Jugador jugador, int equipoAntId, int equipoActId, String fechaTransferencia) {
        this.transferenciaID = transferenciaID;
        this.jugador = jugador;
        this.equipoAntId = equipoAntId;
        this.equipoActId = equipoActId;
        this.fechaTransferencia = fechaTransferencia;
    }

    public int getTransferenciaID() {
        return transferenciaID;
    }
    public void setTransferenciaID(int transferenciaID) {
        this.transferenciaID = transferenciaID;
    }

    public Jugador getJugador() {
        return jugador;
    }
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public int getEquipoAntId() {
        return equipoAntId;
    }
    public void setEquipoAntId(int equipoAntId) {
        this.equipoAntId = equipoAntId;
    }

    public int getEquipoActId() {
        return equipoActId;
    }
    public void setEquipoActId(int equipoActId) {
        this.equipoActId = equipoActId;
    }

    public String getFechaTransferencia() {
        return fechaTransferencia;
    }
    public void setFechaTransferencia(String fechaTransferencia) {
        this.fechaTransferencia = fechaTransferencia;
    }
    public int getDniJugador() {
        return jugador.getJugadorDNI();
    }
}
