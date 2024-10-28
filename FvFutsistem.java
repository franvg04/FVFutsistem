import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FvFutsistem {
    private static ArrayList<Jugador> jugador = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = true;

        do {
            System.out.println("Bienvenido a FV Futsistem, selecciona la operación:");
            System.out.println("1- Registrar Jugador");
            System.out.println("2- Buscar Jugador");
            System.out.println("3- Salir");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    try {
                        registrarJugador(sc);
                        System.out.println("Presione cualquier tecla para continuar");
                        sc.nextLine();
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
                        if (jugador.isEmpty()) {
                            System.out.println("No se encuentran jugadores registrados");
                        } else {
                            buscarJugador(sc);
                            System.out.println("Presione cualquier tecla para continuar");
                            sc.nextLine();
                        }
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
                    salir=false;
                    break;
            }
        } while (salir);
        sc.close();
    }

    private static void registrarJugador(Scanner sc) {
        System.out.println("Ingrese el DNI:");
        int dni = sc.nextInt();
        sc.nextLine();
        for (Jugador jugador : jugador) {
            if (jugador.getJugadorDNI() == dni) {
                System.out.println("Ya existe un jugador registrado con este DNI");
                return;
            }
        }
        System.out.println("Ingrese el Nombre");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el apellido:");
        String apellido = sc.nextLine();
        System.out.println("Ingrese la edad:");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el ID del equipo:");
        int equipoID = sc.nextInt();
        Jugador nuevoJugador = new Jugador(dni, nombre, apellido, edad, equipoID);
        nuevoJugador.setIdEquipo(equipoID);
        jugador.add(nuevoJugador);
    }

   private static void buscarJugador(Scanner sc) {
        System.out.println("Ingrese el DNI del jugador a buscar:");
        int dni = sc.nextInt();
        for (Jugador jugador : jugador) {
            if (jugador.getJugadorDNI() == dni) {
                System.out.println("Nombre: "+ jugador.getJugadorNombre()+ "\nApellido: " + jugador.getJugadorApellido() + "\nEdad: " + jugador.getJugadorEdad() + "\nGoles: " + jugador.getJugadorGoles() + "\nEquipo: " + jugador.getIdEquipo() + "\nTarjetas amarillas: " + jugador.getTarjetasAmarillas() + "\nTarjetas Rojas: " + jugador.getTarjetasRojas());
                return;
            } else {
                System.out.println("El jugador con el DNI ingresado no se encuentra en el sistema");
            }
        }
    }
}