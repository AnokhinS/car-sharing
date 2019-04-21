package vsu.amm.carsharingbackend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import vsu.amm.carsharingbackend.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
    Car findById(long id);
    Car findByNumber(String number);
}
