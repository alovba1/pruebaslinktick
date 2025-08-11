package co.com.s.util;

public class UtilidadTexto {

    /**
     * @param inTexto
     * @return
     */
    public static final String textoToOracion(String inTexto) {
        if (inTexto == null || inTexto.isEmpty()) {
            return inTexto;
        } else {
            return inTexto.toUpperCase().charAt(0) + inTexto.substring(1).toLowerCase();
        }
    }
}
