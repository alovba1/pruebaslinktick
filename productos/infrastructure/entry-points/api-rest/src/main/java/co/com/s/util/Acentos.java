package co.com.s.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
public class Acentos {

    public StringBuilder convertirAcentos(String mensaje) {
        Map<String, String> map = new HashMap<>();


        for (Map.Entry<String, String> entry : map.entrySet()) {
            mensaje.replace(entry.getKey(), entry.getValue());
        }
        StringBuilder out = new StringBuilder();

        return out.append(mensaje);
    }
}
