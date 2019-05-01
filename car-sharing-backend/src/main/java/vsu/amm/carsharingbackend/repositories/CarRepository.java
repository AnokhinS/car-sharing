package vsu.amm.carsharingbackend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import vsu.amm.carsharingbackend.model.carinfo.Car;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findByNumberIgnoreCase(String number);
}
