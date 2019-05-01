package vsu.amm.carsharingbackend.model.carinfo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "firm")
@Data
public class Firm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "firm_id")
    private long id;

    @Column(name = "name")
    private String name;

}
