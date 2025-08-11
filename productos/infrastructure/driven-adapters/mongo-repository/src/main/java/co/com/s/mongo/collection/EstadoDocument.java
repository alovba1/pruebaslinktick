package co.com.s.mongo.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;

import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "estado")
public class EstadoDocument {
    @Id
    private String _id;

    @Indexed(unique = true)
    private Integer codigo;

    @Indexed(unique = true)
    private String nombre;

}
