import java.io.*;

public class ProcesadorContabilidad implements Runnable {
    private String archivo;

    public ProcesadorContabilidad(String archivo) {
        this.archivo = archivo;
    }

    @Override
    public void run() {
        long sumaDepartamento = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                long transaccion = Long.parseLong(linea);
                sumaDepartamento += transaccion;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        //Guardar el resultado en archivo
        String resultadoArchivo = archivo + ".res";
        try (PrintWriter pw = new PrintWriter(new FileWriter(resultadoArchivo))) {
            pw.println(sumaDepartamento);
        } catch (IOException e) {
            // Maneja el caso en el que no se pueda escribir el resultado
            e.printStackTrace();
        }
    }
}
