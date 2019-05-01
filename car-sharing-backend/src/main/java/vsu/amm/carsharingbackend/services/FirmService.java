package vsu.amm.carsharingbackend.services;

import org.springframework.stereotype.Service;
import vsu.amm.carsharingbackend.exceptions.ObjectAlreadyExistsException;
import vsu.amm.carsharingbackend.exceptions.ObjectNotFoundException;
import vsu.amm.carsharingbackend.model.carinfo.Firm;
import vsu.amm.carsharingbackend.repositories.FirmRepository;
import vsu.amm.carsharingbackend.utils.StringUtils;

@Service
public class FirmService {
    private FirmRepository repository;

    public FirmService(FirmRepository repository) {
        this.repository = repository;
    }

    public Iterable<Firm> getAllOrdered() {
        return repository.findByOrderByName();
    }

    public Firm get(long id) {
        return repository.findById(id).orElseThrow(ObjectNotFoundException::new);
    }

    private boolean alreadyExist(String name) {
        try {
            getByName(name);
            return true;
        } catch (ObjectNotFoundException e) {
            return false;
        }
    }

    public Firm getByName(String name) {
        return repository.findByNameIgnoreCase(name).orElseThrow(ObjectNotFoundException::new);
    }

    public Firm create(Firm object) {
        if (alreadyExist(object.getName()))
            throw new ObjectAlreadyExistsException();
        object.setId(0);
        object.setName(StringUtils.firstToUpper(object.getName()));
        return repository.save(object);
    }

    public Firm update(Firm object) {
        if (alreadyExist(object.getName()))
            throw new ObjectAlreadyExistsException();
        get(object.getId());
        object.setName(StringUtils.firstToUpper(object.getName()));
        return repository.save(object);
    }

    public void delete(Firm object) {
        repository.delete(get(object.getId()));
    }


}