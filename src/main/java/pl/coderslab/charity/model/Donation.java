package pl.coderslab.charity.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Entity
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Donation extends EntityBasic{

    private Integer quantity;

    @ManyToMany
    private List<Category> categories;

    @ManyToMany
    private List<Institution> institution;

    private String street;

    private String city;

    private String zipCode;

    private LocalDate pickUpDate;

    private LocalTime pickUpTime;

    private String pickUpComment;
}
