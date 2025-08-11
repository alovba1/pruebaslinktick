package co.com.s.model.inventario.gateways;
import co.com.s.model.exceptions.GeneralServiceException;
import co.com.s.model.inventario.Inventario;
import java.util.Optional;

public interface IComponentInventario {
    Optional<Inventario> obtenerPorProductoId(String productoId);
    Inventario guardar(Inventario inventario);

    Inventario crearNuevoInventario(Inventario inventario) throws GeneralServiceException;


}
