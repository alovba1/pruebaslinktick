package co.com.s.usecase.producto;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import co.com.s.model.producto.Producto;
import co.com.s.model.producto.gateways.IComponentProducto;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductoUseCaseTest {

    @Mock
    IComponentProducto iComponentProducto;

    @InjectMocks
    ProductoUseCase productoUseCase;

    Producto producto;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        producto = Producto.builder().build();
    }

    @org.junit.jupiter.api.Test
    void crearNuevoProducto() {
        when(iComponentProducto.crearNuevoProducto(producto)).thenReturn(producto);
        assertNotNull(productoUseCase.crearNuevoProducto(producto));

    }

    @org.junit.jupiter.api.Test
    void listarTodosProductos() {
    }

    @org.junit.jupiter.api.Test
    void obtenerProductoEspecifico() {
    }

    @org.junit.jupiter.api.Test
    void eliminarProductoId() {
    }
}