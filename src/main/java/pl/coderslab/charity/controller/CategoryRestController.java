package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.List;



@RestController
@RequiredArgsConstructor
public class CategoryRestController {

    private final CategoryRepository categoryRepository;

    @GetMapping("category/getList")
    public List<Category> getListOfDonation() {
        return categoryRepository.findAll();
    }
}
