package co.com.s.mongo.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "secuencia")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SecuenciaDocument {
    @Id
    private String id;
    private Integer secuencia;
}
