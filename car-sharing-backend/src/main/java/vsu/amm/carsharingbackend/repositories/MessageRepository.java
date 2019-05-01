package vsu.amm.carsharingbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vsu.amm.carsharingbackend.model.userinfo.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
    Iterable<Message> findByUserAndReadFalseOrderByDateDesc(long userId);
}
