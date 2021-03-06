package vsu.amm.carsharingbackend.restcontrollers;


import org.springframework.web.bind.annotation.*;
import vsu.amm.carsharingbackend.exceptions.ObjectAlreadyExistsException;
import vsu.amm.carsharingbackend.exceptions.ObjectNotFoundException;
import vsu.amm.carsharingbackend.model.userinfo.User;
import vsu.amm.carsharingbackend.services.UserService;


@RestController
@RequestMapping("/restapi/users")
//@PreAuthorize("hasAuthority('ADMIN')")
public class RestUserController {
    private final UserService service;

    public RestUserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<User> list() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public User get(@PathVariable long id) {
        User found = service.get(id);
        if (found != null)
            return found;
        else
            throw new ObjectNotFoundException();
    }

    @PostMapping
    public User add(@RequestBody User user) throws RuntimeException {
        try {
            return service.create(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new ObjectAlreadyExistsException();
    }

    @PutMapping
    public User update(@RequestBody User user) throws RuntimeException {
        User found = service.get(user.getId());
        if (found == null)
            throw new ObjectNotFoundException();
        try {
            return service.create(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping
    public void delete(@RequestBody User object) {
        User found = service.get(object.getId());
        if (found == null)
            throw new ObjectNotFoundException();
        service.delete(object);
    }

}
