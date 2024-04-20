package com.example.khademni.repositories;

import com.example.khademni.entity.Reclamation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IReclamationRepository extends CrudRepository<Reclamation,Long> {

    @Query("SELECT c FROM Reclamation c WHERE c.user.idUser = :idUser")
    public List<Reclamation> getReclamationByUsername(@Param("idUser") Long idUser);
}
