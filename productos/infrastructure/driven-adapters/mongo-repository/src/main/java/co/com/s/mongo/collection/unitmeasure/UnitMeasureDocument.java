package co.com.s.mongo.collection.unitmeasure;

import java.time.LocalDateTime;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UnitMeasureDocument
 * Clase encargada de mapear el documento de la colección unidad medida a mongoDB
 * @autor
 */
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "unidad_medida")
@Data
@Builder
public class UnitMeasureDocument {
    @Id
    private String id;

    private Integer code;

    private String name;

    private Integer codeUnitMeasureType;

    private String acronyms;

    private Boolean active;

    private String companyNit;

    private String createdBy;

    private LocalDateTime createdAt;

    private String modifiedBy;

    private LocalDateTime modifiedAt;

    private String unitMeasureType;
}
