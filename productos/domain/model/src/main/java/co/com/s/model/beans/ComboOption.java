package co.com.s.model.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public final class ComboOption implements Serializable {
    private Integer codigo;
    private String nombre;
}
