package com.example.khademni.repositories;

import com.example.khademni.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserReposetory extends CrudRepository<User,Long> {
}
