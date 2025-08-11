package co.com.s.responses2;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public final class OpcionCombo implements Serializable {
    private Integer codigo;
    private String nombre;
}
