package com.example.khademni.services;

import com.example.khademni.entity.Reclamation;

import java.util.List;

public interface IReclamationServices {

    Reclamation addReclamation(Reclamation reclamation);

    Reclamation updateReclamation(Reclamation reclamation);

    void deleteReclamation(Long idRec);

    Reclamation getById(Long idRec);
    List<Reclamation> getAll();

    Reclamation addReclamationAndAssignToUser(Reclamation reclamation, Long idUser);

}
