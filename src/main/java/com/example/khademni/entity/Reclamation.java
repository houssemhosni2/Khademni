package com.example.khademni.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Reclamation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRec;
    private String description;
    private String etat;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
/*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reclamation")
    private List<Response> responses;*/
}