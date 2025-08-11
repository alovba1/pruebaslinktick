package co.com.s.responses;

import java.util.List;

public class ConstruccionResponse {

    /**
     * Metodo para construir la respuesta
     * 
     * @param <T>
     * 
     * @param codigo
     * @param conteo
     * @param total
     * @param mensaje
     * @param datos
     * @return
     */
    public static <T> Response construirRespuesta(Integer codigo, Integer conteo, String total, String mensaje,
            List<T> datos) {
        Response rpt = new Response();
        BodyResponse rptbody = new BodyResponse<>();
        rpt.setCodigo(codigo);
        rptbody.setConteo(conteo);
        rptbody.setDatos(datos);
        rptbody.setTotales(total);
        rpt.setMensaje(mensaje);
        rpt.setCuerpo(rptbody);
        return rpt;
    }

    /**
     * Metodo para construir la respuesta ResponseCombos
     * 
     * @param <T>
     * @param codigo
     * @param conteo
     * @param total
     * @param mensaje
     * @param datos
     * @return
     */
    public static <T> ResponseCombos construirRespuestaSinFormato(Integer codigo, Integer conteo, String total,
            String mensaje, List<T> datos) {
        return ResponseCombos.<T>builder().codigo(codigo).mensaje(mensaje).cuerpo(datos).build();
    }

}
