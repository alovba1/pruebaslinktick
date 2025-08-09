package co.com.s.mongo.services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class FieldsValidationService {
    @Autowired
    private MongoTemplate mongoTemplate;
    public boolean validateUniqueName(String collectionName, String fieldName, String fieldValue, String id) {
        Query query = new Query();
        if (id != null) {
            // excluimos de la validación el registro que se está actualizando
            query.addCriteria(Criteria.where("_id").ne(new ObjectId(id)));
        }
        query.addCriteria(Criteria.where(fieldName).is(fieldValue));
        long count = mongoTemplate.count(query, collectionName);
        return count == 0;
    }
    public boolean validateUniqueNameByCompany(String collectionName, String fieldName, String fieldValue, String fieldNameCompania, String fieldValueCompania, String id) {
        Query query = new Query();
        if (id != null) {
            // excluimos de la validación el registro que se está actualizando
            query.addCriteria(Criteria.where("_id").ne(new ObjectId(id)));
        }
        query.addCriteria(Criteria.where(fieldName).is(fieldValue).and(fieldNameCompania).is(fieldValueCompania));
        long count = mongoTemplate.count(query, collectionName);
        return count == 0;
    }
    public boolean validateUniqueFields(String collectionName, Map<String, String> fields, String id) {
        Query query = new Query();
        if (id != null) {
            // excluimos de la validación el registro que se está actualizando
            query.addCriteria(Criteria.where("_id").ne(new ObjectId(id)));
        }
        for (Map.Entry<String, String> item : fields.entrySet()) {
            if (item.getKey().contains("$")){
                query.addCriteria(Criteria.where(item.getKey()).is(new ObjectId(item.getValue())));
            } else {
                query.addCriteria(Criteria.where(item.getKey()).is(item.getValue()));
            }
        }
        long count = mongoTemplate.count(query, collectionName);
        return count == 0;
    }
}
