package com.example.khademni.controllers;

import com.example.khademni.entity.Reclamation;
import com.example.khademni.services.IReclamationServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/reclamation")
@AllArgsConstructor
@RestController
public class ReclamationRestController {

    private IReclamationServices iReclamationServices;

    @PostMapping("/addRec")
    public Reclamation addReclamation(@RequestBody Reclamation reclamation) {
        return iReclamationServices.addReclamation(reclamation);
    }

    @PutMapping("/updateRec")
    public Reclamation updateReclamation(@RequestBody Reclamation reclamation) {
        return iReclamationServices.updateReclamation(reclamation);
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

    @PostMapping("/addRecUser/{idUser}")
    public Reclamation assignToUser(@PathVariable Long idUser, @RequestBody Reclamation reclamation) {
        Reclamation createdReclamation = iReclamationServices.addReclamationAndAssignToUser(reclamation, idUser);
        return createdReclamation;
    }

    @GetMapping("/getreclamationparuser/{idUser}")
    public List<Reclamation> getReclamationsByUser(@PathVariable Long idUser) {

        System.out.println("User ID : "+idUser);
        return iReclamationServices.getReclamationsByUser(idUser);
    }
}
