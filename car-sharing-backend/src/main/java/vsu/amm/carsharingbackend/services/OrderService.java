package vsu.amm.carsharingbackend.services;

import org.springframework.stereotype.Service;
import vsu.amm.carsharingbackend.exceptions.ObjectNotFoundException;
import vsu.amm.carsharingbackend.model.Order;
import vsu.amm.carsharingbackend.model.userinfo.User;
import vsu.amm.carsharingbackend.repositories.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> getAll() {
        return repository.findAll();
    }

    public List<Order> getAllByUser(User user) {
        return repository.findAllByUser(user);
    }

    public Order get(long id) {
        return repository.findById(id).orElseThrow(ObjectNotFoundException::new);
    }

    public void delete(Order object) {
        repository.delete(object);
    }

    public void save(Order object) throws Exception {
        repository.save(object);
    }

    public int getSum(long id) {
        return repository.getSum(id);
    }

    public long getId() {
        return repository.getId();
    }
}