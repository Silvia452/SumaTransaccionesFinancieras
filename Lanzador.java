import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.io.IOException;

public class Lanzador {
    public static void main(String[] args) {
        String[] archivos = { "informatica.txt", "gerencia.txt", "contabilidad.txt", "comercio.txt", "recursos_humanos.txt" };
        Thread[] threads = new Thread[archivos.length];

        for (int i = 0; i < archivos.length; i++) {
            threads[i] = new Thread(new ProcesadorContabilidad(archivos[i]));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long sumaGlobal = 0;
        for (String archivo : archivos) {
            try {
                long sumaDepartamento = UtilidadesFicheros.sumarTransacciones(archivo + ".res");
                sumaGlobal += sumaDepartamento;
                System.out.println("Suma para " + archivo + ": " + sumaDepartamento);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Guardar resultado global
        try {
            UtilidadesFicheros.guardarResultado("Resultado_global.txt", sumaGlobal);
            System.out.println("Suma global guardada en Resultado_global.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
