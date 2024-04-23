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
    public Reclamation addReclamation(Reclamation reclamation, Long userId) {
        User user = iUserReposetory.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + userId + " not found"));
        reclamation.setUser(user);
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
        return ireclamationRepository.findById(idRec)
                .orElseThrow(() -> new EntityNotFoundException("Reclamation with id " + idRec + " not found"));
    }

    @Override
    public List<Reclamation> getAll() {
        return (List<Reclamation>) ireclamationRepository.findAll();
    }
}
