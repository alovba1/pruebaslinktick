package co.com.s.usecase.inventario;

import co.com.s.model.exceptions.GeneralServiceException;
import co.com.s.model.inventario.Inventario;
import co.com.s.model.inventario.gateways.IComponentInventario;
import co.com.s.model.producto.IProductoClient;

public class InventarioUseCase {
    private final IComponentInventario componente;
    private final IProductoClient productoClient;

    public InventarioUseCase(IComponentInventario componente, IProductoClient productoClient) {
        this.componente = componente;
        this.productoClient = productoClient;
    }

    public Inventario consultarInventario(String productoId) {
        productoClient.verificarProducto(productoId);
        return componente.obtenerPorProductoId(productoId)
                .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));
    }

    public Inventario actualizarCantidad(String productoId, int cantidadComprada) {
        Inventario inventario = consultarInventario(productoId);
        inventario.setCantidad(inventario.getCantidad() - cantidadComprada);
        Inventario actualizado = componente.guardar(inventario);
        System.out.println("Inventario actualizado: " + actualizado.getProductoId() +
                " → " + actualizado.getCantidad() + " unidades.");
        return actualizado;
    }


    public Inventario crearNuevoInventario(Inventario inventario) throws GeneralServiceException {
        return componente.crearNuevoInventario(inventario);
    }
}
