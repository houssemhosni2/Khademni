package tn.esprit.internshipmodule.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.internshipmodule.entities.Etudiant;
import tn.esprit.internshipmodule.repositories.EtudiantRepository;
import tn.esprit.internshipmodule.service.EtudiantService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/Etudiant")
public class EtudiantRestController {
    private final EtudiantService etudiantService;

    @PostMapping("/add")
    Etudiant addEtudiant(@RequestBody Etudiant etudiant){
        return etudiantService.addOrUpdateEtudiant(etudiant);
    }

    @PutMapping("/update/{id}")
    Etudiant updateEtudiant(@RequestBody Etudiant etudiant){
        return etudiantService.addOrUpdateEtudiant(etudiant);
    }

    @GetMapping("/get/{id}")
    Etudiant getEtudiant(@PathVariable("id") Long idEtudiant){
        return etudiantService.retrieveEtudiant(idEtudiant);
    }

    @GetMapping("/all")
    List<Etudiant> getAllEtudiants(){
        return etudiantService.retrieveAllEtudiants();
    }

    @DeleteMapping("/delete/{id}")
    void deleteEtudiant(@PathVariable("id") Long idEtudiant){
         etudiantService.removeEtudiant(idEtudiant);
    }
}
