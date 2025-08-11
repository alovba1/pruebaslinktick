package co.com.s.model.client.gateways;

import java.util.List;

import co.com.s.model.exceptions.GeneralServiceException;
import co.com.s.model.client.Client;

public interface IComponentClient {

    /** Método encargado de guardar o actualizar
     * @return objeto Service
     * @throw Exception si ocurre un error durante el proceso
     * @autor
     */

    Client saveClient(Client client) throws GeneralServiceException;

    /** Método encargado de listar
     * @return lista de objetos Service
     * @throw Exception si ocurre un error durante el proceso
     * @autor
     */
    List<Client> findClientAll() throws GeneralServiceException;
    Client findClientById(String id) throws GeneralServiceException;

    void deleteById(String id) throws GeneralServiceException;
}
