import java.io.*;

public class Lanzador {


    public int caso1(String numero) {
        int exitCode;
        try {
            //*ProcessBuilder factorizar = new ProcessBuilder("factor",numero).start() No necesita Process proceso;
            ProcessBuilder factorizar = new ProcessBuilder("factor", numero);
            factorizar.redirectErrorStream(true);
            Process proceso = factorizar.start();

            BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
            exitCode = proceso.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al ejecutar factor: " + e.getMessage());
            exitCode = 1;
        }
        System.out.println("Operación completada. Código de salida: " + exitCode);
        return exitCode;
    }



    public int caso2(String numero) {
        int exitCode;
        try {
            ProcessBuilder factorizar = new ProcessBuilder("factor", numero);
            Process proceso = factorizar.start();

            BufferedReader stdOut = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            BufferedReader stdErr = new BufferedReader(new InputStreamReader(proceso.getErrorStream()));

            String linea;
            while ((linea = stdOut.readLine()) != null) {
                System.out.println("[OK] " + linea);
            }
            while ((linea = stdErr.readLine()) != null) {
                System.out.println("[ERROR] " + linea);
            }
            exitCode = proceso.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("[ERROR] " + e.getMessage());
            exitCode = 1;
        }
        System.out.println("Operación completada. Código de salida: " + exitCode);
        return exitCode;
    }


    public int caso3(String numero) {
        File outputFile = new File("factor_output.log");
        File errorFile = new File("factor_error.log");
        int exitCode;

        try {
            ProcessBuilder factorizar = new ProcessBuilder("factor", numero);
            factorizar.redirectOutput(ProcessBuilder.Redirect.appendTo(outputFile));
            factorizar.redirectError(ProcessBuilder.Redirect.appendTo(errorFile));

            Process proceso = factorizar.start();
            exitCode = proceso.waitFor();
        } catch (IOException | InterruptedException e) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(errorFile, true))) {
                writer.println("[ERROR] " + e.getMessage());
            } catch (IOException ignored) {
            }
            exitCode = 1;
        }
        System.out.println("Código de salida: " + exitCode);
        return exitCode;
    }


    public int caso4(String numero) {
        int exitCode;
        try {
            ProcessBuilder factorizar = new ProcessBuilder("factor", numero);
            Process proceso = factorizar.start();

            BufferedReader stdOut = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            BufferedReader stdErr = new BufferedReader(new InputStreamReader(proceso.getErrorStream()));

            String salida = stdOut.readLine();
            String error = stdErr.readLine();
            exitCode = proceso.waitFor();

            if (salida != null) {
                System.out.println(salida);
                String[] partes = salida.split(":");
                if (partes.length == 2) {
                    String num = partes[0].trim();
                    String factores = partes[1].trim();
                    if (factores.equals(num)) {
                        System.out.println("¡" + num + " es primo!");
                    } else {
                        System.out.println(num + " no es primo");
                    }
                }
            }
            if (error != null) {
                System.out.println(error);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al ejecutar factor: " + e.getMessage());
            exitCode = 1;
        }
        System.out.println("Operación completada. Código de salida: " + exitCode);
        return exitCode;
    }
}

