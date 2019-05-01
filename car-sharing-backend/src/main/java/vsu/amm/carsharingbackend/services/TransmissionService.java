package vsu.amm.carsharingbackend.services;

import org.springframework.stereotype.Service;
import vsu.amm.carsharingbackend.exceptions.ObjectAlreadyExistsException;
import vsu.amm.carsharingbackend.exceptions.ObjectNotFoundException;
import vsu.amm.carsharingbackend.model.carinfo.Transmission;
import vsu.amm.carsharingbackend.repositories.TransmissionRepository;
import vsu.amm.carsharingbackend.utils.StringUtils;

@Service
public class TransmissionService {
    private TransmissionRepository repository;

    public TransmissionService(TransmissionRepository repository) {
        this.repository = repository;
    }

    public Iterable<Transmission> getAllOrdered() {
        return repository.findByOrderByName();
    }

    public Transmission get(long id) {
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

    public Transmission getByName(String name) {
        return repository.findByNameIgnoreCase(name).orElseThrow(ObjectNotFoundException::new);
    }

    public Transmission create(Transmission object) {
        if (alreadyExist(object.getName()))
            throw new ObjectAlreadyExistsException();
        object.setId(0);
        object.setName(StringUtils.firstToUpper(object.getName()));
        return repository.save(object);
    }

    public Transmission update(Transmission object) {
        if (alreadyExist(object.getName()))
            throw new ObjectAlreadyExistsException();
        get(object.getId());
        object.setName(StringUtils.firstToUpper(object.getName()));
        return repository.save(object);
    }

    public void delete(Transmission object) {
        repository.delete(get(object.getId()));
    }


}