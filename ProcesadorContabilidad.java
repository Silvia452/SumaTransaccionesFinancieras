import java.io.IOException;

public abstract class ProcesadorContabilidad implements Runnable {
    private String archivo;

    public ProcesadorContabilidad(String archivo) {
        this.archivo = archivo;
    }

}
