package co.com.s.model.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
public final class ComboResponse<T> implements Serializable {
    private boolean ok;
    private Integer codigo;
    private String mensaje;
    private transient List<T> cuerpo;
}
