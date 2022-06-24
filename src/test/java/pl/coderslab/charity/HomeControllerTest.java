package pl.coderslab.charity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Home Controller specification")
@WebMvcTest(HomeController.class)
class HomeControllerTest {


    @Autowired private MockMvc mockMvc;
    @MockBean private InstitutionRepository institutionRepository;
    @MockBean private DonationRepository donationRepository;

    @Test
    @DisplayName("Should prepare a view for home site")
    public void homeControllerView_success() throws Exception {
        mockMvc.perform
                (MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"))
                .andExpect(MockMvcResultMatchers.model().attribute("institutions", institutionRepository.findAll()))
                .andExpect(MockMvcResultMatchers.model().attribute("quantity", donationRepository.sumQuantity()))
                .andDo(MockMvcResultHandlers.print());
    }
}