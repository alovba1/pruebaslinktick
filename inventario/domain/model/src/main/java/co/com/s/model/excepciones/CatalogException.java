package co.com.s.model.excepciones;

public class CatalogException extends Exception {
    public CatalogException(String mensaje) {
        super(mensaje);
    }

    public CatalogException(Throwable excepcion) {
        super(excepcion);
    }

    public CatalogException(String mensaje, Throwable excepcion) {
        super(mensaje, excepcion);
    }
}
