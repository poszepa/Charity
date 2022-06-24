package pl.coderslab.charity.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Category extends EntityBasic{

    @Column(name = "name")
    private String name;


}
