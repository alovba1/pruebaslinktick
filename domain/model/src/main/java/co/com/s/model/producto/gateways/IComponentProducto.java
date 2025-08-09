package co.com.s.model.producto.gateways;

import java.util.List;

import co.com.s.model.exceptions.GeneralServiceException;
import co.com.s.model.producto.Producto;
public interface IComponentProducto {

    /** Método encargado de guardar o actualizar
     * @return objeto Service
     * @throw Exception si ocurre un error durante el proceso
     * @autor
     */

    Producto crearNuevoProducto(Producto producto) throws GeneralServiceException;

    /** Método encargado de listar
     * @return lista de objetos Service
     * @throw Exception si ocurre un error durante el proceso
     * @autor
     */
    List<Producto> listarTodosProductos() throws GeneralServiceException;
    Producto obtenerProductoEspecifico(String id) throws GeneralServiceException;

    /** Método encargado de eliminar

     * @throw Exception si ocurre un error durante el proceso
     * @autor
     */
    void eliminarProductoId(String id) throws GeneralServiceException;
}
