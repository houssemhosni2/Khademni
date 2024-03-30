package com.example.khademni.services;

import com.example.khademni.entity.Reclamation;
import com.example.khademni.entity.User;
import com.example.khademni.repositories.IReclamationRepository;
import com.example.khademni.repositories.IUserReposetory;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReclamationServices implements IReclamationServices {

    private final IReclamationRepository ireclamationRepository;
    private final IUserReposetory iUserReposetory;
    @Override
    public Reclamation addReclamation(Reclamation reclamation) {
        return ireclamationRepository.save(reclamation);
    }

    @Override
    public Reclamation updateReclamation(Reclamation reclamation) {
        return ireclamationRepository.save(reclamation);
    }

    @Override
    public void deleteReclamation(Long idRec) {
        ireclamationRepository.deleteById(idRec);
    }

    @Override
    public Reclamation getById(Long idRec) {
        return ireclamationRepository.findById(idRec).get();
    }

    @Override
    public List<Reclamation> getAll() {
        return (List<Reclamation>) ireclamationRepository.findAll();
    }

    @Override
    public Reclamation addReclamationAndAssignToUser(Reclamation reclamation, Long idUser) {
        User user = iUserReposetory.findById(idUser).orElse(null);
        if (user != null) {
            reclamation.setUser(user);
            return ireclamationRepository.save(reclamation);
        }
        return null; // Or handle error appropriately
    }
    }

