package vsu.amm.carsharingbackend.services;

import org.springframework.stereotype.Service;
import vsu.amm.carsharingbackend.exceptions.CarNumberAlreadyExistException;
import vsu.amm.carsharingbackend.exceptions.ObjectNotFoundException;
import vsu.amm.carsharingbackend.model.carinfo.Car;
import vsu.amm.carsharingbackend.repositories.CarRepository;

@Service
public class CarService {
    private CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public Iterable<Car> findAll() {
        return repository.findAll();
    }

    public Car get(long id) {
        return repository.findById(id).orElseThrow(ObjectNotFoundException::new);
    }

    public Car getByNumber(String number) {
        return repository.findByNumberIgnoreCase(number).orElseThrow(ObjectNotFoundException::new);
    }

    private boolean numberExist(String number) {
        try {
            getByNumber(number);
            return true;
        } catch (ObjectNotFoundException e) {
            return false;
        }
    }

    public Car create(Car object) throws CarNumberAlreadyExistException {
        if (numberExist(object.getNumber()))
            throw new CarNumberAlreadyExistException();
        return repository.save(object);
    }


    public Car update(Car object) {
        get(object.getId());
        return repository.save(object);
    }

    public void delete(Car object) {
        repository.delete(get(object.getId()));
    }

}