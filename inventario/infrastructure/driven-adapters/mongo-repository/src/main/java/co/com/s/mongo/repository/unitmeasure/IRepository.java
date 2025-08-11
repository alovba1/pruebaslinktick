package co.com.s.mongo.repository.unitmeasure;

import org.springframework.data.mongodb.repository.MongoRepository;
import co.com.s.mongo.collection.unitmeasure.UnitMeasureDocument;

/**
 * MongoDBUnitMeasureRepository
 * @autor
 * Extiende de MongoRepository
 */
public interface IRepository extends MongoRepository<UnitMeasureDocument, String> {
}
