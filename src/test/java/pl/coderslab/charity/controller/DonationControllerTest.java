package pl.coderslab.charity.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Donation controller specificity")
@WebMvcTest(DonationController.class)
class DonationControllerTest {

    @Autowired private MockMvc mockMvc;
    @MockBean private CategoryRepository categoryRepository;
    @MockBean private InstitutionRepository institutionRepository;
    @MockBean private DonationRepository donationRepository;

    @Test
    @DisplayName("Should prepare a donation Form")
    public void donationControllerView_success() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/donation"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("form"))
                .andExpect(MockMvcResultMatchers.model().attribute("listOfCategory", categoryRepository.findAll()))
                .andExpect(MockMvcResultMatchers.model().attribute("listOfInstitution", institutionRepository.findAll()))
                .andDo(MockMvcResultHandlers.print());
    }


}