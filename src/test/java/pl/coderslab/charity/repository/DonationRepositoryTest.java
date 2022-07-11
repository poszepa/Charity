package pl.coderslab.charity.repository;

import com.google.common.truth.Truth;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;

import java.util.List;


@DisplayName("Donation repository specification")
@DataJpaTest
class DonationRepositoryTest {

    @Autowired private TestEntityManager entityManager;
    @Autowired private DonationRepository donationRepository;

    @Test
    @DisplayName("Should sum qunatity of Bags every donation")
    public void sumQuantityBags_success() {
        //GIVEN
        Institution institution = Institution.builder().name("test").description("test").build();
        entityManager.persist(institution);
        Category category = Category.builder().name("testCategory").build();
        entityManager.persist(category);
        Donation donation1 = Donation.builder()
                .quantity(10)
                .institution(List.of(institution))
                .categories(List.of(category))
                .city("test")
                .phoneNumber(602111111)
                .street("test")
                .zipCode("62123")
                .build();
        Donation donation2 = Donation.builder()
                .quantity(10)
                .institution(List.of(institution))
                .categories(List.of(category))
                .city("test")
                .phoneNumber(602111111)
                .street("test")
                .zipCode("62123")
                .build();
        entityManager.persist(donation1);
        entityManager.persist(donation2);

        //ACT
        Integer sumQuantity = donationRepository.sumQuantity();

        //ASSERT
        Truth.assertThat(sumQuantity).isEqualTo(20);
    }

    @Test
    @DisplayName("Should return null from sum qunatity of Bags every donation when any donation wasn't save")
    public void sumQuantityBagsReturnNull_failed() {
        //GIVEN

        //ACT
        Integer sumQuantity = donationRepository.sumQuantity();

        //ASSERT
        Truth.assertThat(sumQuantity).isEqualTo(null);
    }



    @Test
    @DisplayName("Should count every donation")
    public void countDonation_success(){
        //GIVEN
        Institution institution = Institution.builder().name("test").description("test").build();
        entityManager.persist(institution);
        Category category = Category.builder().name("testCategory").build();
        entityManager.persist(category);
        Donation donation1 = Donation.builder()
                .quantity(10)
                .institution(List.of(institution))
                .categories(List.of(category))
                .city("test")
                .phoneNumber(602111111)
                .street("test")
                .zipCode("62123")
                .build();
        Donation donation2 = Donation.builder()
                .quantity(10)
                .institution(List.of(institution))
                .categories(List.of(category))
                .city("test")
                .phoneNumber(602111111)
                .street("test")
                .zipCode("62123")
                .build();
        entityManager.persist(donation1);
        entityManager.persist(donation2);

        //ACT
        Long countDonation = donationRepository.countAllById();

        //ASSERT
        Truth.assertThat(countDonation).isEqualTo(2);
    }



}