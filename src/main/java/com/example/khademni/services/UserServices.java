package com.example.khademni.services;

import com.example.khademni.entity.Reclamation;
import com.example.khademni.entity.User;
import com.example.khademni.repositories.IUserReposetory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServices implements IUserServices {

    private final IUserReposetory iuserReposetory;


    @Override
    public User addUser(User user) {
        return iuserReposetory.save(user);
    }

    @Override
    public User updateUser(User user) {
        return iuserReposetory.save(user);
    }

    @Override
    public void deleteUser(Long idUser) {
        iuserReposetory.deleteById(idUser);
    }

    @Override
    public User getById(Long idUser) {
        return iuserReposetory.findById(idUser).get();
    }

    @Override
    public List<User> getAll() {
        return (List<User>) iuserReposetory.findAll();
    }
}
