package vsu.amm.carsharingbackend.restcontrollers;


import org.springframework.web.bind.annotation.*;
import vsu.amm.carsharingbackend.exceptions.CarNumberAlreadyExistException;
import vsu.amm.carsharingbackend.exceptions.ObjectNotFoundException;
import vsu.amm.carsharingbackend.model.carinfo.Car;
import vsu.amm.carsharingbackend.services.CarService;


@RestController
@RequestMapping("/restapi/cars")
//@PreAuthorize("hasAuthority('ADMIN')")
public class RestCarController {
    private final CarService service;

    public RestCarController(CarService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Car> list() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public Car get(@PathVariable long id) {
        return service.get(id);
    }

    @PostMapping
    public Car add(@RequestBody Car car) throws CarNumberAlreadyExistException {
        try {
            return service.create(car);
        } catch (CarNumberAlreadyExistException e) {
            e.printStackTrace();
            throw new CarNumberAlreadyExistException();
        }
    }

    @PutMapping
    public Car update(@RequestBody Car car) {
        Car found = service.get(car.getId());
        if (found == null)
            throw new ObjectNotFoundException();
        try {
            return service.create(car);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping
    public void delete(@RequestBody Car object) {
        Car found = service.get(object.getId());
        if (found == null)
            throw new ObjectNotFoundException();
        service.delete(object);
    }

}
