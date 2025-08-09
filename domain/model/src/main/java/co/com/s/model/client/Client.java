package co.com.s.model.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class Client {
    private String id;
    private String problemTecnics;
    private String cambiosPlan;
    private String portabilidad;
}
