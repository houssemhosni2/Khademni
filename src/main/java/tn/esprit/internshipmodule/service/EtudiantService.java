package tn.esprit.internshipmodule.service;

import tn.esprit.internshipmodule.entities.Etudiant;

import java.util.List;

public interface EtudiantService {
    List<Etudiant> retrieveAllEtudiants();
    Etudiant retrieveEtudiant(Long idEtudiant);
    Etudiant addOrUpdateEtudiant(Etudiant etudiant);
    void removeEtudiant(Long idEtudiant);
}
