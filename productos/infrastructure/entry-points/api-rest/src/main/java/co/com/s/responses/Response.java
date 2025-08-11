package co.com.s.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private Integer codigo;
    private String mensaje;
    private BodyResponse cuerpo;
}
