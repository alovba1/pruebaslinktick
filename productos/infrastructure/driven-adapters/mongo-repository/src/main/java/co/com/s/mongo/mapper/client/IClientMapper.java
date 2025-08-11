package co.com.s.mongo.mapper.client;

import co.com.s.model.client.Client;
import co.com.s.mongo.collection.client.ClientDocument;
import org.mapstruct.Mapper;

/** Interface que permite generar el codigo con mapstruct, cuando se compila el proyecto.
 * @return mapper
 * @autor
 */
@Mapper(componentModel = "spring")
public interface IClientMapper {

    /** Método encargado de convertir objeto del tipo Document a un objeto del tipo client
     * @return objeto tipo UnitMeasure
     * @autor
     */
    Client toModel(ClientDocument clientDocument);

    /** Método encargado de convertir objeto del tipo UnitMeasure a un objeto del tipo UnitMeasureDocument
     * @return objeto tipo UnitMeasureDocument
     * @autor
     */
    ClientDocument toData(Client client);
}
