import java.util.Objects;
import java.util.Scanner;


public class Interfaz {

    public void menu() {
        Lanzador l = new Lanzador();
        String opcion = "";
        String numero = "";
        do {
            System.out.println("\n--- Detector de primos ---");
            System.out.println("¿Qué nivel quieres usar? (1, 2, 3 o 4):");
            opcion = new Scanner(System.in).next();
            switch (opcion) {
                    case "1" -> {
                        while (true) {
                            System.out.println("Introduce un número:");
                            numero = new Scanner(System.in).next();
                            if ("salir".equalsIgnoreCase(numero)) {
                                System.out.println("Saliendo del programa");
                                break;}
                            l.Caso1(numero);
                        }
                        System.out.println("Saliendo del programa");
                    }
                    case "2" -> {
                        while (true) {
                            System.out.println("Introduce un número:");
                            numero = new Scanner(System.in).next();
                            if ("salir".equalsIgnoreCase(numero)) {
                                System.out.println("Saliendo del programa");
                                break;}
                            l.Caso2(numero);
                        }
                        System.out.println("Saliendo del programa");
                    }
                    case "3" -> {
                        //* l.Caso3(numero);
                    }
                    case "4" -> {
                        //* l.Caso4(numero);
                    }
                }
        } while (!Objects.equals(opcion, "0"));
        System.out.println("Saliendo de la aplicación");
    }
}