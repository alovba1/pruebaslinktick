package co.com.s.mongo.repository.client;

import org.springframework.data.mongodb.repository.MongoRepository;
import co.com.s.mongo.collection.client.ClientDocument;

/**
 * MongoDBClientRepository
 * @autor
 * Extiende de MongoRepository
 */
public interface IRepositoryClient extends MongoRepository<ClientDocument, String> {
}
