package co.com.s.mongo.collection.producto;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * ProductoDocument
 * Clase encargada de mapear el documento de la colección producto a mongoDB
 * @autor
 */
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "producto")
@Data
@Builder
public class ProductoDocument {

    @Id
    private String id;
    private String nombre;
    private Integer precio;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
