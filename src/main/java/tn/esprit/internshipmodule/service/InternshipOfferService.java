package tn.esprit.internshipmodule.service;

import tn.esprit.internshipmodule.entities.InternshipOffer;

import java.util.List;

public interface InternshipOfferService {
    List<InternshipOffer> retrieveAllInternshipOffers();

    InternshipOffer retrieveInternshipOffer(Long idInternshipOffer);

    InternshipOffer addOrUpdateInternshipOffer(InternshipOffer i);

    void removeInternshipOffer(Long idInternshipOffer);
}
