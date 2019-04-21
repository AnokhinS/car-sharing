package vsu.amm.carsharingbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vsu.amm.carsharingbackend.model.Tax;

public interface TaxRepository extends JpaRepository<Tax, Long> {
    Tax findById(long id);
}
