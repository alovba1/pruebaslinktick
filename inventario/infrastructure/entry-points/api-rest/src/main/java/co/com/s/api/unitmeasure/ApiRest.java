package co.com.s.api.unitmeasure;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.com.s.model.unitmeasure.UnitMeasure;
import co.com.s.usecase.unitmeasure.UseCase;
import lombok.RequiredArgsConstructor;
import static co.com.s.api.constant.Constant.URL_BASE;

@RestController
@RequestMapping(value = URL_BASE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ApiRest {
    private final UseCase unitMeasureUseCase;

    @GetMapping
    public List<UnitMeasure> listar() {
        return unitMeasureUseCase.findUnitMeasureAll();

    }

    @GetMapping(path = { "/{id}" })
    public UnitMeasure listarId(@PathVariable("id") String id) {
        return unitMeasureUseCase.findUnitMeasureById(id);
    }

    @PostMapping
    public UnitMeasure add(@RequestBody UnitMeasure p) {
        return unitMeasureUseCase.saveUnitMeasure(p);
    }

    @PutMapping("/{id}")
    public UnitMeasure edit(@RequestBody UnitMeasure p, @PathVariable("id") String id) {
        //p.builder().id(id).build();
        p.setId(id);
        return unitMeasureUseCase.saveUnitMeasure(p);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        unitMeasureUseCase.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).build();
    }

}
