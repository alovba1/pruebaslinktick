package co.com.s.mongo.mapper.inventario;
import co.com.s.model.inventario.Inventario;
import co.com.s.mongo.collection.inventario.InventarioDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IInventarioMapper {
    Inventario toModel(InventarioDocument doc);
    InventarioDocument toDocument(Inventario model);
    InventarioDocument toData(Inventario inventario);
}
