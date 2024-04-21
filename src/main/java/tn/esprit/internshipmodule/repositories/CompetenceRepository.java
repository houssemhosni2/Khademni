package tn.esprit.internshipmodule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.internshipmodule.entities.Competence;
@Repository
public interface CompetenceRepository extends JpaRepository<Competence, Long> {
}