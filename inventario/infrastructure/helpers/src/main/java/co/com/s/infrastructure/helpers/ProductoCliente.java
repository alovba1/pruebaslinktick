package co.com.s.infrastructure.helpers;

import co.com.s.model.producto.IProductoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ProductoCliente implements IProductoClient {

    private final WebClient client;

    public ProductoCliente(@Value("${productos.url}") String baseUrl) {
        this.client = WebClient.builder().baseUrl(baseUrl).build();
    }

    @Override
    public void verificarProducto(String productoId) {
        client.get()
                .uri("/{id}", productoId)
                .retrieve()
                .bodyToMono(Void.class)
                .block(); // Solo verifica existencia
    }
}
