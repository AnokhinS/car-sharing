package vsu.amm.carsharingbackend.services;

import org.springframework.stereotype.Service;
import vsu.amm.carsharingbackend.model.Car;
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

    public Car findById(long id) {
        return repository.findById(id);
    }

    public void deleteById(long id){ repository.deleteById(id);}

    public void delete(Car object) throws Exception {
            repository.delete(object);
    }

    public void save(Car object) throws Exception{
        if (repository.findByNumber(object.getNumber())==null||repository.findByNumber(object.getNumber()).getId()==object.getId()) {
            repository.save(object);
            return;
        }
        throw new Exception("Такой номер принадлежит другому автомобилю");
    }
}