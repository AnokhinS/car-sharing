package vsu.amm.carsharingbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vsu.amm.carsharingbackend.model.Notification;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUserAndReadFalseOrderByDateDesc(long user);
    Notification findById(long id);
}
