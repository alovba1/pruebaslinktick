package co.com.s.model.unitmeasure.gateways;

import java.util.List;

import co.com.s.model.exceptions.GeneralServiceException;
import co.com.s.model.unitmeasure.UnitMeasure;

public interface IComponent {

    /** Método encargado de guardar o actualizar las unidades de medida
     * @return objeto Service
     * @throw Exception si ocurre un error durante el proceso
     * @autor
     */

    UnitMeasure saveUnitMeasure(UnitMeasure unitMeasure) throws GeneralServiceException;

    /** Método encargado de listar las unidades de medida
     * @return lista de objetos Service
     * @throw Exception si ocurre un error durante el proceso
     * @autor
     */
    List<UnitMeasure> findUnitMeasureAll() throws GeneralServiceException;
    UnitMeasure findUnitMeasureById(String id) throws GeneralServiceException;

    void deleteById(String id) throws GeneralServiceException;
}
