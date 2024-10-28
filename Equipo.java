public class Equipo {
    private int equipoID;
    private String equipoNombre;
    private String equipoLocalidad;

    public Equipo (int equipoID, String equipoNombre, String equipoLocalidad) {
        this.equipoID = equipoID;
        this.equipoNombre = equipoNombre;
        this.equipoLocalidad = equipoLocalidad;
    }

    public int getEquipoID() {
        return equipoID;
    }
    public void setEquipoID(int equipoID) {
        this.equipoID = equipoID;
    }

    public String getEquipoNombre() {
        return equipoNombre;
    }
    public void setEquipoNombre(String equipoNombre) {
        this.equipoNombre = equipoNombre;
    }

    public String getEquipoLocalidad() {
        return equipoLocalidad;
    }
    public void setEquipoLocalidad(String equipoLocalidad) {
        this.equipoLocalidad = equipoLocalidad;
    }
}
