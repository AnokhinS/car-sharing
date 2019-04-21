package vsu.amm.carsharingbackend.services;

import org.springframework.stereotype.Service;
import vsu.amm.carsharingbackend.model.Notification;
import vsu.amm.carsharingbackend.repositories.NotificationRepository;

import java.util.List;

@Service
public class NotificationService implements ToUpperCase{
    private NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public Notification findById(long id) {
        return repository.findById(id);
    }

    public List<Notification> findByUser(long id){
        return repository.findByUserAndReadFalseOrderByDateDesc(id);
    }

    public void save(Notification object){
            repository.save(object);
    }
}
