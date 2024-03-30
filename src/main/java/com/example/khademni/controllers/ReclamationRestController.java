package com.example.khademni.controllers;

import com.example.khademni.entity.Reclamation;
import com.example.khademni.services.IReclamationServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/reclamation")
@AllArgsConstructor
@RestController
public class ReclamationRestController {

    private IReclamationServices iReclamationServices;

    @PostMapping("/add")
    public Reclamation addReclamation(@RequestBody Reclamation reclamation) {
        return iReclamationServices.addReclamation(reclamation);
    }

    @PutMapping("/update")
    public Reclamation updateReclamation(@RequestBody Reclamation reclamation) {
        return iReclamationServices.updateReclamation(reclamation);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReclamation(@PathVariable Long idRec) {
        iReclamationServices.deleteReclamation(idRec);
    }

    @GetMapping("/get/{id}")
    public Reclamation getIReclamation(@PathVariable Long idRec) {
        return iReclamationServices.getById(idRec);
    }

    @GetMapping("/all")
    public List<Reclamation> getAllReclamations() {
        return iReclamationServices.getAll();
    }

    @PostMapping("/assignToUser/{idUser}")
    public Reclamation assignToUser(@PathVariable Long idUser, @RequestBody Reclamation reclamation) {
        Reclamation createdReclamation = iReclamationServices.addReclamationAndAssignToUser(reclamation, idUser);
        return createdReclamation;
    }
}
