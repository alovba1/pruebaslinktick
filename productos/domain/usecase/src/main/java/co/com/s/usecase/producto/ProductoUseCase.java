package co.com.s.usecase.producto;
import java.util.List;
import co.com.s.model.exceptions.GeneralServiceException;
import co.com.s.model.producto.Producto;
import co.com.s.model.producto.gateways.IComponentProducto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductoUseCase {


    private final IComponentProducto iComponentProducto;

    /** Método encargado de guardar o actualizar Producto
     * @return objeto Service
     * @throw Exception si ocurre un error durante el proceso
     * @autor
     */
    public Producto crearNuevoProducto(Producto producto) throws GeneralServiceException {
        return iComponentProducto.crearNuevoProducto(producto);
    }

    /** Método encargado de listar Producto
     * @return lista de objetos Service
     * @throw Exception si ocurre un error durante el proceso
     * @autor
     */
    public List<Producto> listarTodosProductos() throws  GeneralServiceException {
        return iComponentProducto.listarTodosProductos();
    }
    /** Método encargado de obtner un Producto especifico
     * @return objeto especifico
     * @throw Exception si ocurre un error durante el proceso
     * @autor
     */
    public Producto obtenerProductoEspecifico(String id) throws  GeneralServiceException {
        return iComponentProducto.obtenerProductoEspecifico(id);
    }

    /** Método encargado de eliminar un Producto especifico
     * @return objeto especifico
     * @throw Exception si ocurre un error durante el proceso
     * @autor
     */
    public void eliminarProductoId(String id) {
        iComponentProducto.eliminarProductoId(id);
    }

}
