package co.com.s.model.beans;
import org.apache.commons.collections4.ListUtils;
import java.util.Collections;
import java.util.List;
public class ResponseBuilder<T> {
    public static <T> Response<T> TableResponse(List<T> list, Integer pageNumber, Integer pageSize) {
        if (list.isEmpty()) {
            return Response.<T>builder()
                    .ok(true)
                    .codigo(0)
                    .cuerpo(BodyResponse.<T>builder()
                            .conteo(0)
                            .datos(Collections.emptyList())
                            .build())
                    .build();
        }
        return Response.<T>builder()
                .ok(true)
                .codigo(0)
                .cuerpo(BodyResponse.<T>builder()
                        .conteo(list.size())
                        .datos(ListUtils.partition(list, pageSize).get(pageNumber))
                        .build())
                .build();
    }
    public static <T> ComboResponse<T> ComboResponse(List<T> list) {
        return ComboResponse.<T>builder()
                .ok(true)
                .codigo(0)
                .mensaje("ok")
                .cuerpo(list)
                .build();
    }
    public static Boolean interpretParameterBooleanGeneric(Integer value) {
        return value == null ? null : value < 0;
    }
    public static <T> Response<T> genericResponse(T obj) {
        return Response.<T>builder()
                .ok(true)
                .codigo(0)
                .cuerpo(BodyResponse.<T>builder()
                        .conteo(1)
                        .datos(Collections.singletonList(obj))
                        .build())
                .build();
    }
    public static <T> Response<T> genericResponse(Throwable ex, Integer errorCode) {
        return Response.<T>builder()
                .codigo(errorCode)
                .mensaje(ex.getMessage())
                .build();
    }
}
