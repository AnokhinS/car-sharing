package vsu.amm.carsharingbackend.restcontrollers;


import org.springframework.web.bind.annotation.*;
import vsu.amm.carsharingbackend.model.carinfo.Transmission;
import vsu.amm.carsharingbackend.services.TransmissionService;


@RestController
@RequestMapping("/restapi/transmissions")
//@PreAuthorize("hasAuthority('ADMIN')")
public class RestTransmissionController {
    private final TransmissionService service;

    public RestTransmissionController(TransmissionService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Transmission> list() {
        return service.getAllOrdered();
    }

    @GetMapping("{id}")
    public Transmission get(@PathVariable long id) {
        return service.get(id);
    }

    @PostMapping
    public Transmission add(@RequestBody Transmission transmission) {
        return service.create(transmission);
    }

    @PutMapping
    public Transmission update(@RequestBody Transmission transmission) {
        return service.update(transmission);
    }

    @DeleteMapping
    public void delete(@RequestBody Transmission object) {
        service.delete(object);
    }
}
