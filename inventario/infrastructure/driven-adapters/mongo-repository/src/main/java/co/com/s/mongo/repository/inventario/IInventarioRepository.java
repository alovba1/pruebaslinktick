package co.com.s.mongo.repository.inventario;
import co.com.s.mongo.collection.inventario.InventarioDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
public interface IInventarioRepository extends MongoRepository<InventarioDocument, String> {
    Optional<InventarioDocument> findByProductoId(String productoId);
}
