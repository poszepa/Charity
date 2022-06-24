package pl.coderslab.charity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class HomeController {

    private final InstitutionRepository institutionRepository;

    @RequestMapping("/")
    public String homeAction(Model model){
        return "index";
    }


    @ModelAttribute("institutions")
    public List<Institution> institutionList() {
        return institutionRepository.findAll();
    }
}
