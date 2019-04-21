package vsu.amm.carsharingbackend.services;

import org.springframework.stereotype.Service;
import vsu.amm.carsharingbackend.model.Tax;
import vsu.amm.carsharingbackend.repositories.TaxRepository;

@Service
public class TaxService {

    private TaxRepository repository;

    public TaxService(TaxRepository repository) {
        this.repository = repository;
    }

    public Iterable<Tax> findAll() {
        return repository.findAll();
    }

    public Tax findById(long id) {
        return repository.findById(id);
    }

    public void delete(Tax object) {
        repository.delete(object);
    }

    public void save(Tax object) throws Exception{
        repository.save(object);
    }
}