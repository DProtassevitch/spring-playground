package by.hector.project.entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Admin on 19.06.2017.
 */
public class BaseEntity {

    @Id
    @Entity
    @Getter
    @Setter

}
