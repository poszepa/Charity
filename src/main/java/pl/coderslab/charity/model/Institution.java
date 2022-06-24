package pl.coderslab.charity.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Institution extends EntityBasic{

    private String name;

    private String description;

    @OneToMany(mappedBy = "institution")
    private List<Donation> donationList;
}
