package com.example.khademni.controllers;

import com.example.khademni.entity.Reclamation;
import com.example.khademni.services.EmailService;
import com.example.khademni.services.IReclamationServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/reclamation")
@AllArgsConstructor
@RestController
public class ReclamationRestController {

    @Autowired
    private IReclamationServices iReclamationServices;

    @Autowired
    private EmailService emailService;


    @PostMapping("/addRec/{userId}")
    public Reclamation addReclamation(@PathVariable Long userId, @RequestBody Reclamation reclamation) {
        Reclamation newReclamation = iReclamationServices.addReclamation(reclamation, userId);

        // Send email notification
        emailService.sendEmail(
                "daadsoufi01@gmail.com",
                "New Reclamation Created",
                "A new reclamation with ID: " + newReclamation.getIdRec() + " has been created."
        );

        return newReclamation;
    }

    @PutMapping("/updateRec")
    public Reclamation updateReclamation(@RequestBody Reclamation reclamation) {
        Reclamation existingReclamation = iReclamationServices.getById(reclamation.getIdRec());
        String previousState = existingReclamation.getEtat();
        String newState = reclamation.getEtat();

        // If the reclamation is updated to "solved", send an email notification
        if (!previousState.equals("solved") && newState.equals("solved")) {
            emailService.sendEmail(
                    "daadsoufi01@gmail.com", // Change to the recipient email
                    "Reclamation Solved",
                    "A reclamation with ID: " + reclamation.getIdRec() + " has been solved. Thank you for your patience."
            );
        }

        // Update the existing reclamation with new data
        existingReclamation.setDescription(reclamation.getDescription());
        existingReclamation.setEtat(reclamation.getEtat());

        // Update the reclamation in the service
        return iReclamationServices.updateReclamation(existingReclamation);
    }


    @DeleteMapping("/deleteRec/{idRec}")
    public void deleteReclamation(@PathVariable Long idRec) {
        iReclamationServices.deleteReclamation(idRec);
    }

    @GetMapping("/getRec/{idRec}")
    public Reclamation getIReclamation(@PathVariable Long idRec) {
        return iReclamationServices.getById(idRec);
    }


    @GetMapping("/allRec")
    public List<Reclamation> getAllReclamations() {
        return iReclamationServices.getAll();
    }

/*
    @PostMapping("/addRecUser/{idUser}")
    public Reclamation assignToUser(@PathVariable Long idUser, @RequestBody Reclamation reclamation) {
        Reclamation createdReclamation = iReclamationServices.addReclamationAndAssignToUser(reclamation, idUser);
        return createdReclamation;
    }

    @GetMapping("/getreclamationparuser/{idUser}")
    public List<Reclamation> getReclamationsByUser(@PathVariable Long idUser) {

        System.out.println("User ID : "+idUser);
        return iReclamationServices.getReclamationsByUser(idUser);
    }*/
}
