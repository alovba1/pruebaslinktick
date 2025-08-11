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
public final class BodyResponse<T> implements Serializable {
    private Integer conteo;
    private transient List<T> datos;
    private String totales;
}
