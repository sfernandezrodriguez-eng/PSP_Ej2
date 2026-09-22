import java.util.Scanner;


public class Interfaz {

    public void menu() {
        Lanzador l = new Lanzador();
        String opcion = "";
        String numero = "";
        do {
            System.out.println("\n--- Detector de primos ---");
            System.out.println("¿Qué nivel quieres usar? (1, 2, 3 o 4) (o 'salir' para terminar):");
            opcion = new Scanner(System.in).next();
            System.out.println("Introduce un número:");
            numero = new Scanner(System.in).next();
            switch (opcion) {
                case "1" -> {
                    System.out.println(l.Caso1(numero));

                }
                case "2" -> {
                    l.Caso2(numero);

                }
                case "3" -> {
                    l.Caso3(numero);
                }
                case "4" -> {
                    l.Caso4(numero);
                }
                case "salir" -> System.out.println("Chao hasta luego....");
            }
        } while (!opcion.equals("salir"));
    }
}