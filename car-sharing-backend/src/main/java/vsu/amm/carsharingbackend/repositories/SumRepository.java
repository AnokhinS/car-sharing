package vsu.amm.carsharingbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vsu.amm.carsharingbackend.model.Sum;

@Repository
public interface SumRepository extends JpaRepository<Sum, Long> {
    Sum findById(long id);
}

