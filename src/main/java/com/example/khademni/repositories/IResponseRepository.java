package com.example.khademni.repositories;

import com.example.khademni.entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IResponseRepository extends JpaRepository<Response, Long> {
}
