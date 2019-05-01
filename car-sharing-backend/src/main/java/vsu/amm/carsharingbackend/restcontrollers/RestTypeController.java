package vsu.amm.carsharingbackend.restcontrollers;


import org.springframework.web.bind.annotation.*;
import vsu.amm.carsharingbackend.model.carinfo.Type;
import vsu.amm.carsharingbackend.services.TypeService;


@RestController
@RequestMapping("/restapi/types")
//@PreAuthorize("hasAuthority('ADMIN')")
public class RestTypeController {
    private final TypeService service;

    public RestTypeController(TypeService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Type> list() {
        return service.getAllOrdered();
    }

    @GetMapping("{id}")
    public Type get(@PathVariable int id) {
        return service.get(id);
    }

    @PostMapping
    public Type add(@RequestBody Type type) throws RuntimeException {
        return service.create(type);
    }

    @PutMapping
    public Type update(@RequestBody Type type) throws RuntimeException {
        return service.update(type);
    }

    @DeleteMapping
    public void delete(@RequestBody Type object) {
        service.delete(object);
    }

}
