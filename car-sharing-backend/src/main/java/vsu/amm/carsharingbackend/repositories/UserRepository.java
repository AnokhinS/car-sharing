package vsu.amm.carsharingbackend.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import vsu.amm.carsharingbackend.model.userinfo.User;

import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    Optional<User> findByEmailIgnoreCase(String email);
}
