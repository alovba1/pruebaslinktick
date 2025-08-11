package co.com.s.usecase.unitmeasure;

import java.util.List;
import co.com.s.model.exceptions.GeneralServiceException;
import co.com.s.model.unitmeasure.UnitMeasure;
import co.com.s.model.unitmeasure.gateways.IComponent;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UseCase {

    private final IComponent iUnitMeasureComponent;

    /** Método encargado de guardar o actualizar las unidades de medida
     * @return objeto Service
     * @throw Exception si ocurre un error durante el proceso
     * @autor
     */
    public UnitMeasure saveUnitMeasure(UnitMeasure unitMeasure) throws GeneralServiceException {
        return iUnitMeasureComponent.saveUnitMeasure(unitMeasure);
    }

    /** Método encargado de listar las unidades de medida
     * @return lista de objetos Service
     * @throw Exception si ocurre un error durante el proceso
     * @autor
     */
    public List<UnitMeasure> findUnitMeasureAll() throws  GeneralServiceException {
        return iUnitMeasureComponent.findUnitMeasureAll();
    }

    public UnitMeasure findUnitMeasureById(String id) throws  GeneralServiceException {
        return iUnitMeasureComponent.findUnitMeasureById(id);
    }
    public void deleteById(String id) {
        iUnitMeasureComponent.deleteById(id);
    }

}
