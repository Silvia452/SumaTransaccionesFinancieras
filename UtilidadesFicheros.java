import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UtilidadesFicheros {
    public static long sumarTransacciones(String archivo) throws IOException {
        long suma = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.isEmpty() && linea.matches("^\\d+$")) {
                    suma += Long.parseLong(linea);
                } else {
                    // Maneja el caso en el que la línea no sea numérica o esté vacía
                    System.err.println("Error en línea no válida en " + archivo + ": " + linea);
                }
            }
        }
        return suma;
    }




    public static void guardarResultado(String archivo, long resultado) throws IOException {
        // Eliminar la extensión ".txt" del nombre del archivo
        String nombreResultado = archivo.replaceFirst("\\.txt$", ".txt.res");
        try (FileWriter fw = new FileWriter(nombreResultado)) {
            fw.write(Long.toString(resultado));
        }
    }

}

