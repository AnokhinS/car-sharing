package vsu.amm.carsharingbackend.services;

import org.springframework.stereotype.Service;
import vsu.amm.carsharingbackend.exceptions.ObjectNotFoundException;
import vsu.amm.carsharingbackend.model.Sum;
import vsu.amm.carsharingbackend.repositories.SumRepository;

@Service
public class SumService {
    private SumRepository repository;

    public SumService(SumRepository repository) {
        this.repository = repository;
    }

    public Iterable<Sum> findAll() {
        return repository.findAll();
    }

    public Sum findById(long id) {
        return repository.findById(id).orElseThrow(ObjectNotFoundException::new);
    }

    public void delete(Sum object) {
        repository.delete(object);
    }

    public void save(Sum object) throws Exception {
        repository.save(object);
    }
}