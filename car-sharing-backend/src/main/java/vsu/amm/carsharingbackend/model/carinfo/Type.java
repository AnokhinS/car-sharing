package vsu.amm.carsharingbackend.model.carinfo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "type")
@Data
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private long id;

    @Length(min = 1, message = "Поле не может быть пустым")
    @Column(name = "name")
    private String name;

    public Type() {
    }
}
