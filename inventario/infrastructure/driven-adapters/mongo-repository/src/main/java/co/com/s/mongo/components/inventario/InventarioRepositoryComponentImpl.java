package co.com.s.mongo.components.inventario;

import co.com.s.model.exceptions.GeneralServiceException;
import co.com.s.model.exceptions.ValidateServiceException;
import co.com.s.model.inventario.Inventario;
import co.com.s.model.inventario.gateways.IComponentInventario;
import co.com.s.mongo.mapper.inventario.IInventarioMapper;
import co.com.s.mongo.repository.inventario.IInventarioRepository;
import co.com.s.mongo.services.FieldsValidationService;
import co.com.s.mongo.services.ServiceUtilities;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@AllArgsConstructor
public class InventarioRepositoryComponentImpl implements IComponentInventario {
    private final IInventarioRepository iInventarioRepository;
    private final IInventarioMapper iInventarioMapper;
    private final FieldsValidationService fieldsValidationService;
    private final ServiceUtilities serviceUtilities;

    public Optional<Inventario> obtenerPorProductoId(String productoId) {
        return iInventarioRepository.findByProductoId(productoId).map(iInventarioMapper::toModel);
    }

    public Inventario guardar(Inventario inventario) {
        return iInventarioMapper.toModel(iInventarioRepository.save(iInventarioMapper.toDocument(inventario)));
    }
    @Override
    public Inventario crearNuevoInventario(Inventario inventario) throws GeneralServiceException {
        String collectionName = "inventario";
        try {

            return Optional.of(iInventarioRepository.save(iInventarioMapper.toData(inventario)))
                    .map(iInventarioMapper::toModel).orElseThrow(ValidateServiceException::new);

        } catch (Exception ex) {
            throw new ValidateServiceException(ex.getMessage(), ex);
        }
    }
}
