package com.example.khademni.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idResponse")
    private Long idResponse;

    //@NotBlank(message="The description must be written")
    //@Size(max=4000 , message="The total number of characters cannot be exceeded")
    private String description;

    @ManyToOne
    @JsonIgnore
    Reclamation reclamation;


}