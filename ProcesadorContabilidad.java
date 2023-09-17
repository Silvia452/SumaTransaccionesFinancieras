import java.io.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProcesadorContabilidad implements Runnable {
    private String archivo;

    public ProcesadorContabilidad(String archivo) {
        this.archivo = archivo;
    }

    @Override
    public void run() {
        long suma = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.isEmpty()) {
                    try {
                        suma += Long.parseLong(linea);
                    } catch (NumberFormatException e) {
                        System.err.println("Error en línea no válida en " + archivo + ": " + linea);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo " + archivo + ": " + e.getMessage());
        }

        try {
            UtilidadesFicheros.guardarResultado(archivo, suma);
            System.out.println("Resultado para " + archivo + ": " + suma);
        } catch (IOException e) {
            System.err.println("Error al guardar el resultado de " + archivo + ": " + e.getMessage());
        }
    }
}

