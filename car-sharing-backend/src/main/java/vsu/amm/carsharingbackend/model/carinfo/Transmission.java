package vsu.amm.carsharingbackend.model.carinfo;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "transmission")
@Data
public class Transmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transmission_id")
    private long id;

    @Column(name = "name")
    private String name;

    public Transmission() {
    }
}
