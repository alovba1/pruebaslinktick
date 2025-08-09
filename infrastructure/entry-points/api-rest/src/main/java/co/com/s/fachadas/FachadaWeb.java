package co.com.s.fachadas;

import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.ListUtils;

import co.com.s.responses2.BodyResponse;
import co.com.s.responses2.ComboResponse;
import co.com.s.responses2.Response;

public class FachadaWeb<T> {

    public Response<T> obtenerRespuestaParaTabla(List<T> lista, Integer pagina, Integer tamanioPagina) {
        if (lista.isEmpty()) {
            return Response.<T>builder()
                    .codigo(0)
                    .cuerpo(BodyResponse.<T>builder()
                            .conteo(0)
                            .datos(Collections.<T>emptyList())
                            .build())
                    .build();
        }
        return Response.<T>builder()
                .codigo(0)
                .cuerpo(BodyResponse.<T>builder()
                        .conteo(lista.size())
                        .datos(ListUtils.partition(lista, tamanioPagina).get(pagina))
                        .build())
                .build();
    }

    public ComboResponse<T> obtenerRespuestaParaCombo(List<T> lista) {
        return ComboResponse.<T>builder()
                .codigo(0)
                .mensaje("ok")
                .cuerpo(lista)
                .build();
    }

    public Boolean interpretarParametroBoleano(Integer valor) {
        return valor == null ? null : valor < 0;
    }

    public Response<T> generarRespuestaGenerica(T obj) {
        return Response.<T>builder()
                .codigo(0)
                .cuerpo(BodyResponse.<T>builder()
                        .conteo(1)
                        .datos(Collections.singletonList(obj))
                        .build())
                .build();
    }

    public Response<T> generarRespuestaGenerica(Throwable ex, Integer codigoError) {
        return Response.<T>builder()
                .codigo(codigoError)
                .mensaje(ex.getMessage())
                .build();
    }

}
