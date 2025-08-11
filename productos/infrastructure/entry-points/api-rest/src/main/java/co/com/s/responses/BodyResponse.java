package co.com.s.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BodyResponse<T> {
    private Integer conteo;
    private List<T> datos;
    private String totales;
}
