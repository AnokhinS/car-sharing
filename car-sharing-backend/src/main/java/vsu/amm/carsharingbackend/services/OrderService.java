package vsu.amm.carsharingbackend.services;

import org.springframework.stereotype.Service;
import vsu.amm.carsharingbackend.model.Order;
import vsu.amm.carsharingbackend.model.User;
import vsu.amm.carsharingbackend.repositories.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> findAll() {
        return repository.findAll();
    }
    public List<Order> findAllByUser(User user) {
        return (List<Order>) repository.findAllByUser(user);
    }

    public Order findById(long id) {
        return repository.findById(id);
    }

    public void deleteById(long id){ repository.deleteById(id);}

    public void delete(Order object) {
        repository.delete(object);
    }

    public void save(Order object)throws Exception{
        repository.save(object);
    }
    public int getSum(long id){
        return repository.getSum(id);
    }
    public long getId(){
        return repository.getId();
    }
}