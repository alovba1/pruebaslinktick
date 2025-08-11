package co.com.s.api.inventario;

import co.com.s.model.inventario.Inventario;
import co.com.s.model.inventario.gateways.IComponentInventario;
import co.com.s.model.producto.IProductoClient;
import co.com.s.usecase.inventario.InventarioUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventario")
public class InventarioApiRest {

    private final InventarioUseCase useCase;

    public InventarioApiRest(IComponentInventario componente, IProductoClient productoClient) {
        this.useCase = new InventarioUseCase(componente, productoClient);
    }

    @GetMapping("/{productoId}")
    public ResponseEntity<Inventario> consultar(@PathVariable String productoId) {
        return ResponseEntity.ok(useCase.consultarInventario(productoId));
    }

    @PutMapping("/{productoId}/comprar")
    public ResponseEntity<Inventario> comprar(@PathVariable String productoId, @RequestParam int cantidad) {
        return ResponseEntity.ok(useCase.actualizarCantidad(productoId, cantidad));
    }

    @PostMapping
    public Inventario add(@RequestBody Inventario p) {
        return useCase.crearNuevoInventario(p);
    }

}


