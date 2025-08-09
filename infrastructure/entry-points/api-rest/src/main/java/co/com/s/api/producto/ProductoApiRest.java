package co.com.s.api.producto;

import java.util.List;

import co.com.s.model.producto.Producto;
import co.com.s.usecase.producto.ProductoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import static co.com.s.api.constant.Constant.URL_BASE;

@RestController
@RequestMapping(value = URL_BASE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ProductoApiRest {

    private final ProductoUseCase productoUseCase;

    @GetMapping
    public List<Producto> listar() {
        return productoUseCase.listarTodosProductos();

    }

    @GetMapping(path = { "/{id}" })
    public Producto listarId(@PathVariable("id") String id) {
        return productoUseCase.obtenerProductoEspecifico(id);
    }

    @PostMapping
    public Producto add(@RequestBody Producto p) {
        return productoUseCase.crearNuevoProducto(p);
    }

    @PutMapping("/{id}")
    public Producto edit(@RequestBody Producto p, @PathVariable("id") String id) {
        //p.builder().id(id).build();
        p.setId(id);
        return productoUseCase.crearNuevoProducto(p);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        productoUseCase.eliminarProductoId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).build();
    }

}
