package co.com.s.mongo.components.producto;
import co.com.s.model.exceptions.GeneralServiceException;
import co.com.s.model.exceptions.ValidateServiceException;
import co.com.s.model.producto.gateways.IComponentProducto;
import co.com.s.model.producto.Producto;
import co.com.s.model.producto.gateways.IComponentProducto;
import co.com.s.mongo.mapper.producto.IProductoMapper;
import co.com.s.mongo.repository.producto.IProductoRepository;
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
public class ProductoRepositoryComponentImpl implements IComponentProducto {
    private final IProductoRepository iProductoRepository;
    private final IProductoMapper iProductoMapper;
    private final FieldsValidationService fieldsValidationService;
    private final ServiceUtilities serviceUtilities;

    /** Método encargado de guardar o actualizar los productos
     * @return objeto Service
     * @throw Exception si ocurre un error durante el proceso
     * @autor
     */
    @Override
    public Producto crearNuevoProducto(Producto producto) throws GeneralServiceException {
        String collectionName = "producto";
        try {
            producto.setCreatedAt(LocalDateTime.now());
            producto.setModifiedAt(LocalDateTime.now());
            return Optional.of(iProductoRepository.save(iProductoMapper.toData(producto)))
                    .map(iProductoMapper::toModel).orElseThrow(ValidateServiceException::new);

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
    public List<Producto> listarTodosProductos() {
        return Optional.of(iProductoRepository.findAll(Sort.by("code"))
                .stream().map(iProductoMapper::toModel).collect(Collectors.toList())).orElseThrow(ValidateServiceException::new);
    }

    @Override
    public Producto obtenerProductoEspecifico(String id) {
        return iProductoRepository.findById(id)
                .map(iProductoMapper::toModel)
                .orElseThrow(() -> new ValidateServiceException("UnitMeasure not found for id: " + id));
    }

    @Override
    public void eliminarProductoId(String id) {
        iProductoRepository.deleteById(id);
    }
}
