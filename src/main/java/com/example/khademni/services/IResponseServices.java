package com.example.khademni.services;

import com.example.khademni.entity.Response;

import java.util.List;

public interface IResponseServices {

    void addResponse(Response response, Long idRec);

    void updateResponse(Response response, Long idResponse);

    void deleteResponse(Long idResponse);

    Response getById(Long idResponse);
    List<Response> getAll();

    List<Response> getResponsesByReclamation(Long idRec);
}
