package vsu.amm.carsharingbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vsu.amm.carsharingbackend.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);

}
