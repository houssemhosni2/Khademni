package tn.esprit.internshipmodule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.internshipmodule.entities.Etudiant;
import tn.esprit.internshipmodule.repositories.EtudiantRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EtudiantServImpl implements EtudiantService {
    private final EtudiantRepository etudiantRepository;
    @Override
    public List<Etudiant> retrieveAllEtudiants(){
        return etudiantRepository.findAll();
    }
    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant){
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }
    @Override
    public Etudiant addOrUpdateEtudiant(Etudiant etudiant){
        return etudiantRepository.save(etudiant);
    }
    @Override
    public void removeEtudiant(Long idEtudiant){
        etudiantRepository.deleteById(idEtudiant);
    }
}
