package co.com.s.responses2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    private Integer codigo;
    private String mensaje;
    private BodyResponse<T> cuerpo;
}
