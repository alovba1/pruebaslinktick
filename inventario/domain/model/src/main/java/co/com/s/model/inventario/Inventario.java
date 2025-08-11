package co.com.s.model.inventario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class Inventario {
    private String productoId;
    private Integer cantidad;
}
