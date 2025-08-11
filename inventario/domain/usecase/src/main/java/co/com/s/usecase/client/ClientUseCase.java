package co.com.s.usecase.client;

import java.util.List;

import co.com.s.model.client.Client;
import co.com.s.model.client.gateways.IComponentClient;
import co.com.s.model.exceptions.GeneralServiceException;
import co.com.s.model.unitmeasure.UnitMeasure;
import co.com.s.model.unitmeasure.gateways.IComponent;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClientUseCase {

    private final IComponentClient iUnitMeasureComponent;

    /** Método encargado de guardar o actualizar
     * @return objeto Service
     * @throw Exception si ocurre un error durante el proceso
     * @autor
     */
    public Client saveClient(Client client) throws GeneralServiceException {
        return iUnitMeasureComponent.saveClient(client);
    }

    /** Método encargado de listar
     * @return lista de objetos Service
     * @throw Exception si ocurre un error durante el proceso
     * @autor
     */
    public List<Client> findClientAll() throws  GeneralServiceException {
        return iUnitMeasureComponent.findClientAll();
    }

    public Client findClientById(String id) throws  GeneralServiceException {
        return iUnitMeasureComponent.findClientById(id);
    }
    public void deleteById(String id) {
        iUnitMeasureComponent.deleteById(id);
    }

}
