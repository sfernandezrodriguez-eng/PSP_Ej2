import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lanzador {









    public String Caso1(String numero) {
        ProcessBuilder factorizar = new ProcessBuilder("factor",numero);

        try {
            Process proceso = factorizar.start();
            BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String resultado = lector.readLine();
            return resultado;
        } catch (IOException e) {
            return "Algo falla 1: " + e.getMessage();
        }
    }


    public void Caso2(String numero){}


    public void Caso3(String numero){}


    public void Caso4(String numero){}

}
