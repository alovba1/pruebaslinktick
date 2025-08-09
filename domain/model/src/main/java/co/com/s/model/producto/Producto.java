package co.com.s.model.producto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class Producto {
    private String id;
    private String nombre;
    private Integer precio;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
