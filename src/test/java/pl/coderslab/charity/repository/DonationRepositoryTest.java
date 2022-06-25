package pl.coderslab.charity.repository;

import com.google.common.truth.Truth;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import pl.coderslab.charity.model.Donation;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Donation repository specification")
@DataJpaTest
class DonationRepositoryTest {

    @Autowired private TestEntityManager entityManager;
    @Autowired private DonationRepository donationRepository;

    @Test
    @DisplayName("Should sum qunatity of Bags every donation")
    public void sumQuantityBags_success() {
        //GIVEN
        Donation donation1 = Donation.builder().quantity(10).build();
        entityManager.persist(donation1);
        Donation donation2 = Donation.builder().quantity(20).build();
        entityManager.persist(donation2);

        //ACT
        Integer sumQuantity = donationRepository.sumQuantity();

        //ASSERT
        Truth.assertThat(sumQuantity).isEqualTo(30);
    }

    @Test
    @DisplayName("Should count every donation")
    public void countDonation_success(){
        //GIVEN
        Donation donation1 = Donation.builder().quantity(10).build();
        entityManager.persist(donation1);
        Donation donation2 = Donation.builder().quantity(20).build();
        entityManager.persist(donation2);

        //ACT
        Long countDonation = donationRepository.countAllById();

        //ASSERT
        Truth.assertThat(countDonation).isEqualTo(2);
    }

}