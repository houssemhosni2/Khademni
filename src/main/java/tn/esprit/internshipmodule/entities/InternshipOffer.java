package tn.esprit.internshipmodule.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.internal.Cascade;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter @Builder
public class InternshipOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ititle;
    private String idescription;
//    @ManyToMany
//    private List<Competence> iSkillsRequired;
    private Integer idurationMonths;
    private String ilocation;
    private Double iremuneration;
    private LocalDate iapplicationDeadline;
    private String icontact;
//    @ManyToOne
//    private User user;
    @Enumerated(EnumType.STRING)
    private Statut istatut;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "internshipOffer")
//    private List<Application> applications;
}
