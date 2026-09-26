import java.io.*;

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

    public void Caso3(String numero) {
        File outputFile = new File("factor_output.log");
        File errorFile = new File("factor_error.log");

        try {
            int prueba = Integer.parseInt(numero);
            if (prueba <= 0) {
                throw new NumberFormatException();
            }

            ProcessBuilder factorizar = new ProcessBuilder("factor", numero);

            factorizar.redirectOutput(ProcessBuilder.Redirect.appendTo(outputFile));
            factorizar.redirectError(ProcessBuilder.Redirect.appendTo(errorFile));

            Process proceso = factorizar.start();
            int exitCode = proceso.waitFor();

            System.out.println("Código de salida: " + exitCode);

        } catch (NumberFormatException e) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(errorFile, true))) {
                writer.println("[ERROR] factor: '" + numero + "' no es un entero positivo válido.");
            } catch (IOException ignored) {}

            System.out.println("Código de salida: 1");
        } catch (IOException | InterruptedException e) {
            System.out.println("Código de salida: 1");
        }
    }

    public void Caso4(String numero) {
        try {
            int prueba = Integer.parseInt(numero);
            if (prueba <= 0) {
                throw new NumberFormatException();
            }

            ProcessBuilder factorizar = new ProcessBuilder("factor", numero);

            try {
                Process proceso = factorizar.start();
                BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                String salida = lector.readLine();

                if (salida != null) {
                    System.out.println(salida);

                    String[] partes = salida.split(":");
                    if (partes.length == 2) {
                        String num = partes[0].trim();
                        String factores = partes[1].trim();

                        if (factores.equals(num)) {
                            System.out.println("¡" + num + " es primo!");
                        } else {
                            System.out.println(num + " no es primo. Factores: " + factores);
                        }
                    }

                    proceso.waitFor();
                    System.out.println("Operación completada. Código de salida: 0");
                }
            } catch (IOException | InterruptedException e) {
                System.out.println("Algo falla 1: " + e.getMessage());
                System.out.println("Operación completada. Código de salida: 1");
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] factor: '" + numero + "' no es un entero positivo válido.");
            System.out.println("Operación completada. Código de salida: 1");
        }
    }
}
