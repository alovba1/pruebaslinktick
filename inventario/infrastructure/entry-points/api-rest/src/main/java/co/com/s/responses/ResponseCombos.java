package co.com.s.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCombos<T> {
    private Integer codigo;
    private String mensaje;
    private List<T> cuerpo;
}
