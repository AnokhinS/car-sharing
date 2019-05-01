package vsu.amm.carsharingbackend.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import vsu.amm.carsharingbackend.model.carinfo.Firm;

import java.util.Optional;

@Repository
public interface FirmRepository extends PagingAndSortingRepository<Firm, Long> {
    Iterable<Firm> findByOrderByName();

    Optional<Firm> findByNameIgnoreCase(String name);
}
