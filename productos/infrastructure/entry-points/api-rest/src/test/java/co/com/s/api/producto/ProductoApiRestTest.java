package co.com.s.api.producto;

import co.com.s.model.producto.Producto;
import co.com.s.usecase.producto.ProductoUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = ProductoApiRest.class)
@ContextConfiguration(classes = TestConfiguration.class)
class ProductoApiRestTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductoUseCase productoUseCase;

    private Producto productoEjemplo() {
        return Producto.builder()
                .id("1")
                .nombre("Laptop")
                .precio(1500)
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build();
    }

    @Test
    void listarTodosLosProductos() throws Exception {
        when(productoUseCase.listarTodosProductos()).thenReturn(List.of(productoEjemplo()));

        mockMvc.perform(get("/producto"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Laptop"))
                .andExpect(jsonPath("$[0].precio").value(1500));
    }

    @Test
    void obtenerProductoPorId() throws Exception {
        when(productoUseCase.obtenerProductoEspecifico("1")).thenReturn(productoEjemplo());

        mockMvc.perform(get("/producto/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Laptop"))
                .andExpect(jsonPath("$.precio").value(1500));
    }

    @Test
    void eliminarProducto() throws Exception {
        doNothing().when(productoUseCase).eliminarProductoId("1");

        mockMvc.perform(delete("/producto/1"))
                .andExpect(status().isNoContent());
    }
}
