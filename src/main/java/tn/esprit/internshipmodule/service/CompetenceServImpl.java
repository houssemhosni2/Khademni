package tn.esprit.internshipmodule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.internshipmodule.entities.Competence;
import tn.esprit.internshipmodule.repositories.CompetenceRepository;

import java.util.List;
@RequiredArgsConstructor
@Service
public class CompetenceServImpl implements CompetenceService{
    private final CompetenceRepository competenceRepository;
    @Override
    public List<Competence> retrieveAllCompetences(){
        return competenceRepository.findAll();
    }
    public Competence retrieveCompetence(Long idCompetence){
        return competenceRepository.findById(idCompetence).orElse(null);
    }
    public Competence addOrUpdateCompetence(Competence competence){
        return competenceRepository.save(competence);
    }
    public void removeCompetence(Long idCompetence){
        competenceRepository.deleteById(idCompetence);
    }
}
