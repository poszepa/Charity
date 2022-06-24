package pl.coderslab.charity.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Institution extends EntityBasic{

    private String name;

    private String description;

}
