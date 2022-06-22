package pl.coderslab.charity.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Category extends EntityBasic{

    @Column(name = "name")
    private String name;
}
