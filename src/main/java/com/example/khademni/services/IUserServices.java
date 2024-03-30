package com.example.khademni.services;

import com.example.khademni.entity.Reclamation;
import com.example.khademni.entity.User;

import java.util.List;

public interface IUserServices {

    User addUser(User user);

    User updateUser(User user);

    void deleteUser(Long idUser);

    User getById(Long idUser);
    List<User> getAll();
}
