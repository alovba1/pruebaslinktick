package co.com.s.api.client;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.com.s.model.client.Client;
import co.com.s.usecase.client.ClientUseCase;
import lombok.RequiredArgsConstructor;
import static co.com.s.api.constant.Constant.URL_BASE;

@RestController
//@RequestMapping(value = URL_BASE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientApiRest {
    private final ClientUseCase clientUseCase;

    @GetMapping
    public List<Client> listar() {
        return clientUseCase.findClientAll();

    }

    @GetMapping(path = { "/{id}" })
    public Client listarId(@PathVariable("id") String id) {
        return clientUseCase.findClientById(id);
    }

    @PostMapping
    public Client add(@RequestBody Client p) {
        return clientUseCase.saveClient(p);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        clientUseCase.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).build();
    }

}
