package pl.coderslab.charity.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Entity
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Donation extends EntityBasic{

    @Min(1)
    @NumberFormat
    private Integer quantity;

    @ManyToMany
    private List<Category> categories;

    @ManyToMany
    private List<Institution> institution;

    @Size(min = 2)
    @NotNull
    private String street;

    @Size(min = 2)
    @NotNull
    private String city;

    @NotNull
    private String zipCode;

    @NotNull
    @NumberFormat
    @Min(1)
    private Integer phoneNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime pickUpTime;

    private String pickUpComment;
}
