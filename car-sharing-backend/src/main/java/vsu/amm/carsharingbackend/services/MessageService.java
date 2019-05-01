package vsu.amm.carsharingbackend.services;

import org.springframework.stereotype.Service;
import vsu.amm.carsharingbackend.exceptions.ObjectNotFoundException;
import vsu.amm.carsharingbackend.model.userinfo.Message;
import vsu.amm.carsharingbackend.repositories.MessageRepository;

@Service
public class MessageService {
    private MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public Message get(long id) {
        return repository.findById(id).orElseThrow(ObjectNotFoundException::new);
    }

    public Iterable<Message> findByUser(long id) {
        return repository.findByUserAndReadFalseOrderByDateDesc(id);
    }

    public void create(Message object) {
        repository.save(object);
    }

    public void update(Message object) {
        get(object.getId());
        repository.save(object);
    }

    public void delete(Message object) {
        repository.save(get(object.getId()));
    }
}
