package vsu.amm.carsharingbackend.services;

import org.springframework.stereotype.Service;
import vsu.amm.carsharingbackend.model.Type;
import vsu.amm.carsharingbackend.repositories.TypeRepository;

@Service
public class TypeService implements ToUpperCase{
    private TypeRepository repository;

    public TypeService(TypeRepository repository) {
        this.repository = repository;
    }

    public Iterable<Type> findAll() {
        return repository.findAll();
    }

    public Type findById(int id) {
        return repository.findById(id);
    }


    public void delete(Type object) {
        repository.delete(object);
    }

    public void save(Type object) throws Exception {
        if(repository.findByNameIgnoreCase(object.getName())==null) {
            object.setName(upper(object.getName()));
            repository.save(object);
            return;
        }
        throw new Exception("Тип "+upper(object.getName())+" уже существует");
    }
}
