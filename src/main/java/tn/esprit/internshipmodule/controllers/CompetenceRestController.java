package tn.esprit.internshipmodule.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.internshipmodule.entities.Competence;
import tn.esprit.internshipmodule.service.CompetenceService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/competence")
public class CompetenceRestController {
    private final CompetenceService competenceService;

    @PostMapping("/add")
    Competence addCompetence(@RequestBody Competence competence){
        return competenceService.addOrUpdateCompetence(competence);
    }

    @PutMapping("/update/{idC}")
    Competence updateCompetence(@RequestBody Competence competence){
        return competenceService.addOrUpdateCompetence(competence);
    }

    @GetMapping("/get/{idC}")
    Competence getCompetence(@PathVariable("idC") Long idCompetence){
        return competenceService.retrieveCompetence(idCompetence);
    }

    @GetMapping("/all")
    List<Competence> getAllCompetences(){
        return competenceService.retrieveAllCompetences();
    }

    @DeleteMapping("/delete/{idC}")
    void deleteCompetence(@PathVariable("idC") Long idCompetence){
        competenceService.removeCompetence(idCompetence);
    }
}
