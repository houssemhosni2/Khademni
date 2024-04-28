package tn.esprit.internshipmodule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.internshipmodule.entities.InternshipOffer;
import tn.esprit.internshipmodule.repositories.InternshipOfferRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InternshipOfferServImpl implements InternshipOfferService{
    private final InternshipOfferRepository internshipOfferRepository;

    @Override
    public List<InternshipOffer> retrieveAllInternshipOffers(){
        return internshipOfferRepository.findAll();
    }
    @Override
    public InternshipOffer retrieveInternshipOffer(Long idInternshipOffer){
        return internshipOfferRepository.findById(idInternshipOffer).orElse(null);
    }
    @Override
    public InternshipOffer addOrUpdateInternshipOffer(InternshipOffer i){
       // System.out.println("les données qui arrivent sont: "+ i.toString());
        return internshipOfferRepository.save(i);
    }

    @Override
    public void removeInternshipOffer(Long idInternshipOffer){
        internshipOfferRepository.deleteById(idInternshipOffer);
    }
}
