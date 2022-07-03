package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DonationController {

    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    @GetMapping("/donation")
    public String donationForm(Model model) {
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/donation")
    public String donationFormPost(@ModelAttribute("donation")@Valid Donation donation, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "form";
        }
        donationRepository.save(donation);
        return "redirect:/donation/complete";
    }

    @GetMapping("/donation/complete")
    public String donationFormComplete() {
        return "form-confirmation";
    }

    @ModelAttribute("listOfCategory")
    public List<Category> getListCategory() {
        return categoryRepository.findAll();
    }

    @ModelAttribute("listOfInstitution")
    public List<Institution> getListInstitution() {
        return institutionRepository.findAll();
    }
}
