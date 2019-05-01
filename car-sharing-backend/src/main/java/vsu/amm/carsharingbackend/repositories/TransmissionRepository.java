package vsu.amm.carsharingbackend.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;
import vsu.amm.carsharingbackend.model.carinfo.Transmission;

import java.util.Optional;

public interface TransmissionRepository extends PagingAndSortingRepository<Transmission, Long> {
    Iterable<Transmission> findByOrderByName();

    Optional<Transmission> findByNameIgnoreCase(String name);
}

