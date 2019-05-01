package vsu.amm.carsharingbackend.services;

import org.springframework.stereotype.Service;
import vsu.amm.carsharingbackend.exceptions.ObjectAlreadyExistsException;
import vsu.amm.carsharingbackend.exceptions.ObjectNotFoundException;
import vsu.amm.carsharingbackend.model.carinfo.Type;
import vsu.amm.carsharingbackend.repositories.TypeRepository;
import vsu.amm.carsharingbackend.utils.StringUtils;

@Service
public class TypeService {
    private TypeRepository repository;

    public TypeService(TypeRepository repository) {
        this.repository = repository;
    }

    public Iterable<Type> getAllOrdered() {
        return repository.findByOrderByName();
    }

    public Type get(long id) {
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

    public Type getByName(String name) {
        return repository.findByNameIgnoreCase(name).orElseThrow(ObjectNotFoundException::new);
    }

    public Type create(Type object) {
        if (alreadyExist(object.getName()))
            throw new ObjectAlreadyExistsException();
        object.setId(0);
        object.setName(StringUtils.firstToUpper(object.getName()));
        return repository.save(object);
    }

    public Type update(Type object) {
        if (alreadyExist(object.getName()))
            throw new ObjectAlreadyExistsException();
        get(object.getId());
        object.setName(StringUtils.firstToUpper(object.getName()));
        return repository.save(object);
    }

    public void delete(Type object) {
        repository.delete(get(object.getId()));
    }


}