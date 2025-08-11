package co.com.s.model.fieldsValidation;

import java.util.Map;

public interface IFieldsValidationService {

    public boolean validateUniqueFields(String collectionName, Map<String, String> fields, String id);
}
