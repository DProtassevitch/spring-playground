package by.hector.project.entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {

    @Column(name = "brand")
    @Getter
    @Setter
    private String brand;

    @Column(name = "model")
    @Getter
    @Setter
    private String model;
}
