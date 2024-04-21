package tn.esprit.internshipmodule.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String domain;
    private LocalDate birthDate;
    private String cv;
//
//    @OneToMany(mappedBy = "user")
//    private List<Application> applications;
//
//    @OneToMany(mappedBy = "user")
//    private List<InternshipOffer> internshipOffers;
}