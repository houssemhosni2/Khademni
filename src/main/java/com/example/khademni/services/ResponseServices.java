package com.example.khademni.services;

import com.example.khademni.entity.Reclamation;
import com.example.khademni.entity.Response;
import com.example.khademni.repositories.IReclamationRepository;
import com.example.khademni.repositories.IResponseRepository;
import com.example.khademni.repositories.IUserReposetory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class ResponseServices implements IResponseServices{

    private final IResponseRepository iResponseRepository;

    private final IReclamationRepository iReclamationRepository;
/*
    @Override
    public void addResponse(Response response, Long idRec) {
        Reclamation r = iReclamationRepository.findById(idRec).orElse(null);

        response.setReclamation(r);
        r.setEtat("traité");
        iResponseRepository.save(response);
        iReclamationRepository.save(r);
    }

    @Override
    public void updateResponse(Response response, Long idResponse) {
        Response res= iResponseRepository.findById(idResponse).orElse(null);
        res.setReclamation(res.getReclamation());
        res.setIdResponse(idResponse);
        res.setDescription(response.getDescription());


        iResponseRepository.save(res);    }

    @Override
    public void deleteResponse(Long idResponse) {
        iResponseRepository.deleteById(idResponse);
    }

    @Override
    public Response getById(Long idResponse) {
        return iResponseRepository.findById(idResponse).get();
    }

    @Override
    public List<Response> getAll() {
        return (List<Response>) iResponseRepository.findAll();
    }
/*
    @Override
    public List<Response> getResponsesByReclamation(Long idRec) {
        Reclamation rec = iReclamationRepository.findById(idRec).orElse(null);
        return rec.getResponses();
    }*/

}
