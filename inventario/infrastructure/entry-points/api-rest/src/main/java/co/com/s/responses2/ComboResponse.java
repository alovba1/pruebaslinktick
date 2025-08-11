package co.com.s.responses2;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
public final class ComboResponse<T> {
    private Integer codigo;
    private String mensaje;
    private List<T> cuerpo;
}
