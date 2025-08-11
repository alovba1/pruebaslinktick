package co.com.s.mongo.mapper.producto;

import co.com.s.model.producto.Producto;
import co.com.s.mongo.collection.producto.ProductoDocument;
import org.mapstruct.Mapper;

/** Interface que permite generar el codigo con mapstruct, cuando se compila el proyecto.
 * @return mapper
 * @autor
 */
@Mapper(componentModel = "spring")
public interface IProductoMapper {

    /** Método encargado de convertir objeto del tipo ProductoDocument a un objeto del tipo Producto
     * @return objeto tipo Producto
     * @autor
     */
    Producto toModel(ProductoDocument productoDocument);

    /** Método encargado de convertir objeto del tipo Producto a un objeto del tipo ProductoDocument
     * @return objeto tipo ProductoDocument
     * @autor
     */
    ProductoDocument toData(Producto producto);
}
