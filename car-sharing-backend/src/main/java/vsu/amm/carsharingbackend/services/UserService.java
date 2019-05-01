package vsu.amm.carsharingbackend.services;

import org.springframework.stereotype.Service;
import vsu.amm.carsharingbackend.exceptions.EmailAlreadyExistException;
import vsu.amm.carsharingbackend.exceptions.ObjectNotFoundException;
import vsu.amm.carsharingbackend.model.userinfo.Role;
import vsu.amm.carsharingbackend.model.userinfo.User;
import vsu.amm.carsharingbackend.repositories.UserRepository;

import java.util.Arrays;
import java.util.HashSet;


@Service
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository userRep) {
        this.repository = userRep;
    }

    public Iterable<User> findAll() {
        return repository.findAll();
    }

    public User get(long id) {
        return repository.findById(id).orElseThrow(ObjectNotFoundException::new);
    }

    public User getByEmail(String email) {
        return repository.findByEmailIgnoreCase(email).orElseThrow(ObjectNotFoundException::new);
    }

    private boolean emailExist(String email) {
        try {
            getByEmail(email);
            return true;
        } catch (ObjectNotFoundException e) {
            return false;
        }
    }

    public User create(User user) throws EmailAlreadyExistException {
        if (emailExist(user.getEmail()))
            throw new EmailAlreadyExistException();
        user.setActive(true);
        Role userRole = Role.USER;
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return repository.save(user);
    }

    public void update(User user) {
        get(user.getId());
        repository.save(user);
    }

    public void delete(User user) {
        repository.delete(get(user.getId()));
    }
}
