package tn.esprit.internshipmodule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.internshipmodule.entities.InternshipOffer;
@Repository
public interface InternshipOfferRepository extends JpaRepository<InternshipOffer, Long> {
}