package co.com.s.mongo.collection.unitmeasuretype;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * UnitMeasureTypeDocument
 * Clase encargada de mapear el documento de la colección tipo unidad medida a mongoDB
 * @autor Anderson Guarnizo
 */
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tipo_unidad_medida")
@Data
@Builder
public class UnitMeasureTypeDocument {
    @Id
    private String id;

    private Long code;

    private String name;

    private Boolean active;

    private String createdBy;

    private LocalDateTime createdAt;

    private String modifiedBy;

    private LocalDateTime modifiedAt;
}
