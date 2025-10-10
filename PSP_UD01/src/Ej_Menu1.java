import java.io.IOException;
import java.util.Scanner;

public class Ej_Menu1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            // Menú de opciones
            System.out.println("\nMenu:");
            System.out.println("1. Listar ficheros");
            System.out.println("2. Ver fecha y hora");
            System.out.println("3. Ver usuario actual");
            System.out.println("4. Ver historial de comandos");
            System.out.println("5. Ver espacio libre en disco");
            System.out.println("6. Ver procesos en ejecución");
            System.out.println("7. Mostrar red actual");
            System.out.println("8. Mostrar IP local");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opcion: ");
            
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea

            String[] command = null;

            // Switch de opciones
            switch (opcion) {
                case 1:
                    command = new String[] { "ls", "-l" }; // Ver lista fichero
                    break;
                case 2:
                    command = new String[] { "date" }; // Ver fecha
                    break;
                case 3:
                    command = new String[] { "whoami" }; // Ver usuario actual
                    break;
                case 4:
                	command = new String[] { "history" }; // Ver historial de comandos
                    break;
                case 5:
                    command = new String[] { "df", "-h" }; // Ver espacio libre en disco
                    break;
                case 6:
                    command = new String[] { "ps", "aux" }; // Ver procesos en ejecución
                    break;
                case 7:
                    command = new String[] { "ip", "a" }; // Mostrar configuración de red
                    break;
                case 8:
                    command = new String[] { "hostname", "-I" }; // Mostrar IP local
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    continue;
            }

            // Solo ejecutamos el comando si no es nulo
            if (command != null) {
                try {
                    int return_code = new ProcessBuilder(command)
                            .inheritIO() // Inherit I/O to the console
                            .start()
                            .waitFor();

                    if (return_code != 0) {
                        System.out.println("El comando terminó con un código de error: " + return_code);
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } while (opcion != 9); // Salir cuando se elige la opción 4

        sc.close();
    }
}

