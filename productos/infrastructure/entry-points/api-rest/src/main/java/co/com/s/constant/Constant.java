package co.com.s.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constant {
    public static final String RUTA_BASE = "/api";
    public static final String RUTA_TABLA_ = "/-tabla";
    public static final String RUTA_COMBO_ = "/-combo";

    // Response
    public static final Integer CODIGO_OK = 0;
    public static final Integer CODIGO_ERROR = 1;
    public static final Integer CONTEO = 1;
    public static final String TOTAL = "0";
    public static final String MENSAJE = "ok";

}
