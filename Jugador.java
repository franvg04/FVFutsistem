import com.sun.source.tree.ReturnTree;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private int jugadorDNI;
    private String jugadorNombre;
    private String jugadorApellido;
    private int jugadorEdad;
    private int jugadorGoles;
    private int tarjetasAmarillas;
    private int tarjetasRojas;
    private int idEquipo;
    private List<Sancion> sanciones;

    public Jugador (int jugadorDNI, String jugadorNombre, String jugadorApellido, int jugadorEdad, int equipoID) {
        this.jugadorDNI = jugadorDNI;
        this. jugadorNombre = jugadorNombre;
        this.jugadorApellido = jugadorApellido;
        this.jugadorEdad = jugadorEdad;
        this.idEquipo = equipoID;
        this.jugadorGoles = 0;
        this.tarjetasAmarillas = 0;
        this.tarjetasRojas = 0;
        this.sanciones = new ArrayList<>();
    }

    public int getJugadorDNI() {
        return jugadorDNI;
    }
    public void setJugadorDNI(int jugadorDNI){
        this.jugadorDNI = jugadorDNI;
    }

    public String getJugadorNombre() {
        return jugadorNombre;
    }
    public void setJugadorNombre(String jugadorNombre){
        this.jugadorNombre = jugadorNombre;
    }
    public String getJugadorApellido(){
        return jugadorApellido;
    }
    public void setJugadorApellido(String jugadorApellido){
        this.jugadorApellido = jugadorApellido;
    }

    public int getJugadorEdad() {
        return jugadorEdad;
    }
    public void setJugadorEdad(int jugadorEdad){
        this.jugadorEdad = jugadorEdad;
    }

    public int getJugadorGoles(){
        return jugadorGoles;
    }
    public void setJugadorGoles (int jugadorGoles) {
        this.jugadorGoles = jugadorGoles;
    }

    public int getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }
    public void setTarjetasAmarillas(int tarjetasAmarillas) {
        this.tarjetasAmarillas = tarjetasAmarillas;
    }

    public int getTarjetasRojas() {
        return tarjetasRojas;
    }
    public void setTarjetasRojas(int tarjetasRojas) {
        this.tarjetasRojas = tarjetasRojas;
    }

    public int getIdEquipo() {
        return idEquipo;
    }
    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public boolean sancionado() {
        for (Sancion sancion : sanciones) {
            if (sancion.sancionActiva()) {
                return true;
            }
        }
        return false;
    }

    public List<Sancion> getSanciones() {
        return sanciones;
    }
}
