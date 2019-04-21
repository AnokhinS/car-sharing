package vsu.amm.carsharingbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vsu.amm.carsharingbackend.model.Firm;

@Repository
public interface FirmRepository extends JpaRepository<Firm, Integer> {
    Firm findById(int id);

    Firm findByNameIgnoreCase(String name);
}
