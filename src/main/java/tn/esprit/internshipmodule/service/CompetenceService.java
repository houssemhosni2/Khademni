package tn.esprit.internshipmodule.service;

import tn.esprit.internshipmodule.entities.Competence;

import java.util.List;

public interface CompetenceService {
    List<Competence> retrieveAllCompetences();
    Competence retrieveCompetence(Long idCompetence);
    Competence addOrUpdateCompetence(Competence competence);
    void removeCompetence(Long idCompetence);
}
