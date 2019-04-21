package vsu.amm.carsharingbackend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vsu.amm.carsharingbackend.model.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
    Type findById(int id);
    Type findByNameIgnoreCase(String name);
}
