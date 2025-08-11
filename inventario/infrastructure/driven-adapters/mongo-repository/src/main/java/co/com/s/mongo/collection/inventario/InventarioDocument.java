package co.com.s.mongo.collection.inventario;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;
@Document(collection = "inventarios")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class InventarioDocument {
    @Id
    private String id;
    private String productoId;
    private Integer cantidad;
}

