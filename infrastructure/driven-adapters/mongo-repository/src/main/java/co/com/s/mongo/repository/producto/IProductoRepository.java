package co.com.s.mongo.repository.producto;

import co.com.s.mongo.collection.producto.ProductoDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * MongoDBUnitMeasureRepository
 * @autor
 * Extiende de MongoRepository
 */
public interface IProductoRepository extends MongoRepository<ProductoDocument, String>  {
}
