package co.com.s.configuracion;

import co.com.s.api.constant.Constant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class ApiRestConfiguration {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping(Constant.ADD_MAPPING)
                        .allowCredentials(true)
                        .allowedOrigins(Constant.ALLOWED_ORIGIN_PATTERNS)
                        .allowedMethods("OPTIONS", "HEAD", "GET", "PUT", "POST", "DELETE", "PATCH")
                        .allowedHeaders("Authorization", "Origin", "X-Requested-With", "Content-Type", "Accept")
                        .exposedHeaders(
                                "Access-Control-Allow-Headers", "Origin", "Accept", "X-Requested-With", "Content-Type",
                                "Access-Control-Request-Method", "Access-Control-Request-Headers");
            }
        };
    }
}
