package co.com.s.mongo.mapper.unitmeasure;

import co.com.s.model.unitmeasure.UnitMeasure;
import co.com.s.mongo.collection.unitmeasure.UnitMeasureDocument;
import org.mapstruct.Mapper;

/** Interface que permite generar el codigo con mapstruct, cuando se compila el proyecto.
 * @return mapper
 * @autor
 */
@Mapper(componentModel = "spring")
public interface IUnitMeasureMapper {

    /** Método encargado de convertir objeto del tipo UnitMeasureDocument a un objeto del tipo UnitMeasure
     * @return objeto tipo UnitMeasure
     * @autor
     */
    UnitMeasure toModel(UnitMeasureDocument unitMeasureDocument);

    /** Método encargado de convertir objeto del tipo UnitMeasure a un objeto del tipo UnitMeasureDocument
     * @return objeto tipo UnitMeasureDocument
     * @autor
     */
    UnitMeasureDocument toData(UnitMeasure unitMeasure);
}
