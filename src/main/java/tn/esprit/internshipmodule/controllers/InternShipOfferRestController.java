package tn.esprit.internshipmodule.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.internshipmodule.entities.InternshipOffer;
import tn.esprit.internshipmodule.service.InternshipOfferService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/InternShipOffer")
public class InternShipOfferRestController {

    private final InternshipOfferService internshipOfferService;

    @PostMapping("/add")
    InternshipOffer addInternshipOffer(@RequestBody InternshipOffer internshipOffer){
        System.out.println("ici on est sur le controller : "+internshipOffer);
        return internshipOfferService.addOrUpdateInternshipOffer(internshipOffer);
    }

    @PutMapping("/update/{id}")
    InternshipOffer updateInternshipOffer(@RequestBody InternshipOffer internshipOffer){
        return internshipOfferService.addOrUpdateInternshipOffer(internshipOffer);
    }

    @GetMapping("/{id}")
    InternshipOffer getInternshipOffer(@PathVariable("id") Long idInternshipOffer){
        return internshipOfferService.retrieveInternshipOffer(idInternshipOffer);
    }

    @GetMapping("/all")
    List<InternshipOffer> getAllInternshipOffers(){
        return internshipOfferService.retrieveAllInternshipOffers();
    }

    @DeleteMapping("/delete/{id}")
    void deleteInternshipOffer(@PathVariable("id") Long idInternshipOffer){
        internshipOfferService.removeInternshipOffer(idInternshipOffer);
    }
}
