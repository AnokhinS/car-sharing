package vsu.amm.carsharingbackend.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import vsu.amm.carsharingbackend.model.carinfo.Type;

import java.util.Optional;

@Repository
public interface TypeRepository extends PagingAndSortingRepository<Type, Long> {
    Iterable<Type> findByOrderByName();

    Optional<Type> findByNameIgnoreCase(String name);
}
