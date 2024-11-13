import java.util.InputMismatchException;
import java.util.Scanner;

public class FvFutsistem {

    public static void main(String[] args) {
        JugadorDB jugadorDB = new JugadorDB();
        EquipoBD equipoBD = new EquipoBD();
        SancionBD sancionBD = new SancionBD();
        Scanner sc = new Scanner(System.in);
        boolean salir = true;

        do {
            System.out.println("Bienvenido a FV Futsistem, selecciona la operación:");
            System.out.println("1- Registrar Jugador");
            System.out.println("2- Buscar Jugador");
            System.out.println("3- Registrar Equipo");
            System.out.println("4- Registrar Sancion");
            System.out.println("0- Salir");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    try {
                        registrarJugador(jugadorDB, sc);
                        System.out.println("Presione cualquier tecla para continuar");
                        sc.nextLine();
                        break;
                    }catch (InputMismatchException a) {
                        System.out.println("**************************************************");
                        System.out.println("ERROR: INGRESE UN DATO VALIDO");
                        System.out.println("**************************************************");
                        System.out.println("Presione cualquier tecla para continuar");
                        sc.nextLine();
                    } finally {
                        sc.nextLine();
                    }
                    break;
                case 2:
                    try {
                        buscarJugador(jugadorDB, equipoBD, sc);
                        System.out.println("Presione cualquier tecla para continuar");
                        break;
                    } catch (InputMismatchException b) {
                        System.out.println("**************************************************");
                        System.out.println("ERROR: NO SE PERMITEN LETRAS");
                        System.out.println("**************************************************");
                        System.out.println("Presione cualquier tecla para continuar");
                        sc.nextLine();
                    } finally {
                        sc.nextLine();
                    }
                    break;
                case 3:
                    try {
                        registrarEquipo(equipoBD, sc);
                        System.out.println("Presione cualquier tecla para continuar");
                        sc.nextLine();
                        break;
                    } catch (InputMismatchException c) {
                        System.out.println("**************************************************");
                        System.out.println("ERROR");
                        System.out.println("**************************************************");
                        System.out.println("Presione cualquier tecla para continuar");
                        sc.nextLine();
                    } finally {
                        sc.nextLine();
                    }
                case 4:
                    try {
                        registrarSancion(sancionBD, jugadorDB, sc);
                        System.out.println("Presione cualquier tecla para continuar");
                        sc.nextLine();
                        break;
                    } catch (InputMismatchException d) {
                        System.out.println("**************************************************");
                        System.out.println("ERROR");
                        System.out.println("**************************************************");
                        System.out.println("Presione cualquier tecla para continuar");
                        sc.nextLine();
                    } finally {
                        sc.nextLine();
                    }
                case 0:
                    salir=false;
                    break;
            }
        } while (salir);
        sc.close();
    }

    private static void registrarJugador(JugadorDB jugadorDB, Scanner sc) {
        System.out.println("Ingrese DNI del jugador:");
        int dniJugador = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese el nombre del jugador:");
        String nombreJugador = sc.nextLine();

        System.out.println("Ingrese el apellido del jugador:");
        String apellidoJugador = sc.nextLine();

        System.out.println("Ingrese la edad del jugador:");
        int edadJugador = sc.nextInt();

        System.out.println("Ingresar ID del equipo del jugador:");
        int idEquipo = sc.nextInt();

        Jugador jugador = new Jugador(dniJugador, nombreJugador, apellidoJugador, edadJugador, idEquipo);
        if (jugadorDB.registrarJugador(jugador)) {
            System.out.println("Jugador registrado con exito");
        } else {
            System.out.println("Error al registrar el jugador");
        }
    }

    private static void buscarJugador(JugadorDB jugadorDB, EquipoBD equipoBD, Scanner sc) {
        System.out.println("Ingrese el DNI del jugador que desea buscar:");
        int dniJugador = sc.nextInt();
        Jugador jugador = jugadorDB.buscarJugador(dniJugador);

        if (jugador != null) {
            String nombreEquipo = equipoBD.buscarEquipo(jugador.getIdEquipo());
            System.out.println("Jugador encontrado \n" +"Nombre: "+ jugador.getJugadorNombre() + "\nApellido: " + jugador.getJugadorApellido() + "\nEdad: " + jugador.getJugadorEdad() + "\nGoles: " + jugador.getJugadorGoles() + "\nEquipo: " + nombreEquipo + "\nSanciones: " + jugador.sancionado() + "\nAmarillas: " + jugador.getTarjetasAmarillas() + "\nRojas: " + jugador.getTarjetasRojas());
        } else {
            System.out.println("Jugador no encontrado.");
        }
    }

    private static void registrarEquipo(EquipoBD equipoBD, Scanner sc) {
        System.out.println("Ingrese el ID del equipo:");
        int idEquipo = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese el nombre del equipo:");
        String nombreEquipo = sc.nextLine();

        System.out.println("Ingrese la localidad del equipo:");
        String localidadEquipo = sc.nextLine();

        Equipo equipo = new Equipo(idEquipo, nombreEquipo, localidadEquipo);
        if (equipoBD.registrarEquipo(equipo)) {
            System.out.println("Equipo registrado correctamente.");
        } else {
            System.out.println("Error al registrar el equipo.");
        }
    }

    private static void registrarSancion(SancionBD sancionBD, JugadorDB jugadorDB, Scanner sc) {
        System.out.println("Ingrese ID de la sancion:");
        int idSancion = sc.nextInt();

        System.out.println("Ingrese el DNI del jugador a sancionar:");
        int dniJugador = sc.nextInt();

        Jugador jugador = jugadorDB.buscarJugador(dniJugador);
        if (jugador == null) {
            System.out.println("El jugador al que se le intenta aplicar la sancion no se encuentra cargado");
            return;
        }

        System.out.println("Ingrese la duracion de la sanción en dias:");
        int duracionSancion = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese la fecha de inicio (YYYY-MM-DD):");
        String fechaInicio = sc.nextLine();

        System.out.println("Ingrese la fecha de fin (YYYY-MM-DD):");
        String fechaFin = sc.nextLine();

        Sancion sancion = new Sancion(idSancion, duracionSancion, fechaInicio, fechaFin, jugador);
        if (sancionBD.registrarSancion(sancion)) {
            System.out.println("Sancion registrada con exito");
        } else {
            System.out.println("Error al registrar la sancion");
        }
    }
}