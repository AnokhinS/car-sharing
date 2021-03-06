package vsu.amm.carsharingbackend.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import vsu.amm.carsharingbackend.model.carinfo.Car;
import vsu.amm.carsharingbackend.model.userinfo.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "order")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @Column(name = "start_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @Column(name = "days")
    private int days;

    @Column(name = "returned")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate returned;


}
