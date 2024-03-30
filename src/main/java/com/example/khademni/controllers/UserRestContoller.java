package com.example.khademni.controllers;

import com.example.khademni.entity.Reclamation;
import com.example.khademni.entity.User;
import com.example.khademni.services.IReclamationServices;
import com.example.khademni.services.IUserServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/user")
@AllArgsConstructor
@RestController
public class UserRestContoller {

    private IUserServices iUserServices;

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return iUserServices.addUser(user);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return iUserServices.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long idRec) {
        iUserServices.deleteUser(idRec);
    }

    @GetMapping("/get/{id}")
    public User getIUser(@PathVariable Long idUser) {
        return iUserServices.getById(idUser);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return iUserServices.getAll();
    }


}
