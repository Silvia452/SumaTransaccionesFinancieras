import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UtilidadesFicheros {
    public static long sumarTransacciones(String[] archivos) {
        long sumaTotal = 0;
        for (String archivo : archivos) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    long transaccion = Long.parseLong(linea);
                    sumaTotal += transaccion;
                }
            } catch (IOException | NumberFormatException e) {
                // Manejar excepciones de lectura y formato aquí
                e.printStackTrace();
            }
        }
        return sumaTotal;
    }



    public static void guardarResultado(String archivo, long resultado) throws IOException {
        try (FileWriter fw = new FileWriter(archivo + ".res")) {
            fw.write(Long.toString(resultado));
        }
    }
}

