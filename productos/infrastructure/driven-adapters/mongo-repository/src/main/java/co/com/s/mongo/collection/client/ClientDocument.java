package co.com.s.mongo.collection.client;


import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cliente")
@Data
@Builder

public class ClientDocument {
    @Id
    private String id;
    private String problemTecnics;
    private String cambiosPlan;
    private String portabilidad;


}
