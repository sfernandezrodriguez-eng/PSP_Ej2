import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lanzador {


    public void Caso1(String numero) {
        try {
            int prueba = Integer.parseInt(numero);
            //*ProcessBuilder factorizar = new ProcessBuilder("factor",numero).start() No necesita Process proceso;
            ProcessBuilder factorizar = new ProcessBuilder("factor", numero);

            try {
                Process proceso = factorizar.start();
                BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                String resultado = lector.readLine();
                System.out.println(resultado);
                System.out.println("Operación completada. Código de salida: 0");
            } catch (IOException e) {
                System.out.println("Algo falla 1: " + e.getMessage());
                System.out.println("Operación completada. Código de salida: 1");
            }
        } catch (NumberFormatException e) {
            System.out.println("Factor: " + numero + " is not a valid positive integer");
            System.out.println("Operación completada. Código de salida: 1");
        }
    }


    public void Caso2(String numero) {
        try {
            int prueba = Integer.parseInt(numero);
            //*ProcessBuilder factorizar = new ProcessBuilder("factor",numero).start() No necesita Process proceso;
            ProcessBuilder factorizar = new ProcessBuilder("factor", numero);

            try {
                Process proceso = factorizar.start();
                BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                String resultado = "[OK] " + lector.readLine();
                System.out.println(resultado);
                System.out.println("Operación completada. Código de salida: 0");
            } catch (IOException e) {
                System.out.println("Algo falla 1: " + e.getMessage());
                System.out.println("Operación completada. Código de salida: 1");
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] factor: " + numero + " is not a valid positive integer");
            System.out.println("Operación completada. Código de salida: 1");
        }
    }


    /**
     * public String Caso3(String numero){}
     **/

    public void Caso4(String numero) {
        try {
            int prueba = Integer.parseInt(numero);
            //*ProcessBuilder factorizar = new ProcessBuilder("factor",numero).start() No necesita Process proceso;
            ProcessBuilder factorizar = new ProcessBuilder("factor", numero);

            try {
                Process proceso = factorizar.start();
                BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                String partido = lector.readLine();
                String partes = partido.split(":");
                if (partes[0].length== partes[1].length+1)){
                    String resultado = "[OK] " + lector.readLine();
                    System.out.println(resultado);
                    System.out.println("Operación completada. Código de salida: 0");
                }
            } catch (IOException e) {
                System.out.println("Algo falla 1: " + e.getMessage());
                System.out.println("Operación completada. Código de salida: 1");
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] factor: " + numero + " is not a valid positive integer");
            System.out.println("Operación completada. Código de salida: 1");
        }
    }
}
