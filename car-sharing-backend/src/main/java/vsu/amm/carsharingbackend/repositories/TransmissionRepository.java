package vsu.amm.carsharingbackend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import vsu.amm.carsharingbackend.model.Transmission;

public interface TransmissionRepository extends JpaRepository<Transmission, Integer> {
    Transmission findById(int id);

    Transmission findByNameIgnoreCase(String name);
}

