import java.util.Scanner;

public class Interfaz {

    public void menu() {
        Lanzador lanzador = new Lanzador();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Detector de primos ---");
        System.out.println("¿Qué nivel quieres usar? (1, 2, 3 o 4):");
        System.out.print("> ");
        String opcion = scanner.next();

        while (true) {
            System.out.println("Introduce un número (o 'salir' para terminar):");
            System.out.print("> ");
            String numero = scanner.next();

            if ("salir".equalsIgnoreCase(numero)) {
                System.out.println("Saliendo del programa");
                break;
            }

            switch (opcion) {
                case "1" -> lanzador.caso1(numero);
                case "2" -> lanzador.caso2(numero);
                case "3" -> lanzador.caso3(numero);
                case "4" -> lanzador.caso4(numero);
                default -> {
                    System.out.println("Nivel no válido");
                    return;
                }
            }
        }

        scanner.close();
    }
}