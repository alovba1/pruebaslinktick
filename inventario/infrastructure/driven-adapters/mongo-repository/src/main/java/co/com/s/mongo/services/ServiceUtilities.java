package co.com.s.mongo.services;

import co.com.s.mongo.collection.SecuenciaDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
@Service
public class ServiceUtilities {
    private String fieldId = "_id";
    private String fieldSequence = "secuencia";
    @Autowired
    private MongoOperations mongoOperations;
    /**
     * @param inNit
     * @param inNombreDocument
     * @return
     */
    public Integer  obtenerCodigo(String inNit, String inNombreDocument) {
        final SecuenciaDocument secuencia = mongoOperations.findAndModify(
                query(where(fieldId).is(inNombreDocument + "|" + inNit)),
                new Update().inc(fieldSequence, 1),
                options().returnNew(true).upsert(true),
                SecuenciaDocument.class);
        return secuencia == null ? 0 : Integer.valueOf(secuencia.getSecuencia());
    }
    /**
     *
     * @param inNombreDocument
     * @return
     */
    @Deprecated
    public String getCode(String inNombreDocument) {
        Integer tam = 4;
        final SecuenciaDocument secuencia = mongoOperations.findAndModify(
                query(where(fieldId).is(inNombreDocument)),
                new Update().inc("secuencia", 1),
                options().returnNew(true).upsert(true),
                SecuenciaDocument.class);

        return String.format("%0" + tam + "d", Integer.valueOf(secuencia.getSecuencia()));
    }
    /**
     *
     * @param inNombreDocument
     * @param inTam
     * @return
     */
    public String getCode(String inNit, String inNombreDocument, Integer inTam) {
        final SecuenciaDocument secuencia = mongoOperations.findAndModify(
                query(where(fieldId).is(inNombreDocument + "|" + inNit)),
                new Update().inc(fieldSequence, 1),
                options().returnNew(true).upsert(true),
                SecuenciaDocument.class);

        return String.format("%0" + inTam + "d", Integer.valueOf(secuencia.getSecuencia()));
    }
    public Long getCode(String inNit, String inNombreDocument) {
        final SecuenciaDocument secuencia = mongoOperations.findAndModify(
                query(where(fieldId).is(inNombreDocument + "|" + inNit)),
                new Update().inc(fieldSequence, 1),
                options().returnNew(true).upsert(true),
                SecuenciaDocument.class);

        return Long.valueOf(secuencia.getSecuencia());
    }
    public Integer getCode(Integer compania, String inNombreDocument) {
        final SecuenciaDocument secuencia = mongoOperations.findAndModify(
                query(where(fieldId).is(inNombreDocument + "|" + compania)),
                new Update().inc(fieldSequence, 1),
                options().returnNew(true).upsert(true),
                SecuenciaDocument.class);

        return secuencia == null ? 0 : Integer.valueOf(secuencia.getSecuencia());
    }
    /**
     * Metodo encargado de generar el codigo
     * @param code
     * @return Integer generateCode
     */
    public Long generateCode(Long code) {
        final SecuenciaDocument counter = mongoOperations.findAndModify(query(where(fieldId).is(code)),
                new Update().inc(fieldSequence, 1), options().returnNew(true).upsert(true),
                SecuenciaDocument.class);
        return !Objects.isNull(counter) ? Long.parseLong(String.valueOf(counter.getSecuencia())) : 1;
    }
}
