package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class InstitutionRestController {

    private final InstitutionRepository institutionRepository;

    @GetMapping("institution/getList")
    public List<Institution> listOfInstitution() {
        return institutionRepository.findAll();
    }
}
