package co.com.s.mongo.components.client;

import co.com.s.model.exceptions.GeneralServiceException;
import co.com.s.model.exceptions.ValidateServiceException;
import co.com.s.model.client.Client;
import co.com.s.model.client.gateways.IComponentClient;
import co.com.s.mongo.mapper.client.IClientMapper;
import co.com.s.mongo.repository.client.IRepositoryClient;
import co.com.s.mongo.services.FieldsValidationService;
import co.com.s.mongo.services.ServiceUtilities;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
@AllArgsConstructor
public class RepositoryClientImpl implements IComponentClient {
    private final IRepositoryClient iUnitMeasureRepository;
    private final IClientMapper iUnitMeasureMapper;
    private final FieldsValidationService fieldsValidationService;
    private final ServiceUtilities serviceUtilities;

    /** Método encargado de guardar o actualizar
     * @return objeto Service
     * @throw Exception si ocurre un error durante el proceso
     * @autor
     */
    @Override
    public Client saveClient(Client client) throws GeneralServiceException {
        String collectionName = "cliente";
        try {
            //Map<String, String> fields = new HashMap<>();
            //fields.put("name", unitMeasure.getName());
            //fields.put("companyNit", unitMeasure.getCompanyNit());

            /**
             * Validación de nombre y compañía asociado por id y que el nombre no exista en la compañia
             */
            // if(fieldsValidationService.validateUniqueFields(collectionName, fields , unitMeasure.getId())) {
            //   if(unitMeasure.getId() == null) {
            //     unitMeasure.setCode(serviceUtilities.obtenerCodigo(collectionName, unitMeasure.getCompanyNit()));
           // client.setCreatedAt(LocalDateTime.now());
            //} else {
            //client.setModifiedAt(LocalDateTime.now());
            //}
            /**
             * Programación funcional: Creación de un optional para un objeto no nulo. Se utiliza la Api de Stream, nos permite realizar
             * operaciones de tipo filtro/mapeo/reducción sobre colecciones de datos de forma secuencial o paralela.
             * Ver info (https://www.oracle.com/lad/technical-resources/articles/java/expresiones-lambda-api-stream-java-part2.html)
             */
            return Optional.of(iUnitMeasureRepository.save(iUnitMeasureMapper.toData(client)))
                    .map(iUnitMeasureMapper::toModel).orElseThrow(ValidateServiceException::new);
            //} else {
            //  throw new ValidateServiceException("El nombre que ingres\u00f3 ya est\u00e1 asociado a otro unidad de medida. Por favor modifique el nombre para poder guardar el registro.");
            //}
        } catch (Exception ex) {
            throw new ValidateServiceException(ex.getMessage(), ex);
        }
    }

    /** Método encargado de listar
     * @return lista de objetos Service
     * @throw Exception si ocurre un error durante el proceso
     * @autor
     */
    @Override
    public List<Client> findClientAll() {

        return Optional.of(iUnitMeasureRepository.findAll(Sort.by("code"))
                .stream().map(iUnitMeasureMapper::toModel).collect(Collectors.toList())).orElseThrow(ValidateServiceException::new);
    }

    @Override
    public Client findClientById(String id) {
        return iUnitMeasureRepository.findById(id)
                .map(iUnitMeasureMapper::toModel)
                .orElseThrow(() -> new ValidateServiceException("UnitMeasure not found for id: " + id));
    }

    @Override
    public void deleteById(String id) {
        iUnitMeasureRepository.deleteById(id);
    }
}
