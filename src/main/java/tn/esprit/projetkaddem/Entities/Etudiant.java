package tn.esprit.projetkaddem.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "Etudiant")
@AllArgsConstructor
@Data
public class Etudiant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;
    private String prenom;
    private String nom;
    @Enumerated(EnumType.STRING)
    private Option option;

    @OneToMany(mappedBy = "etudiant")
    private Set<Contrat> contrats;

    @ManyToOne
    @JsonIgnore
    private Departement departement;

    @ManyToMany()
    @JsonIgnore
    private Set<Equipe> equipes;

    public Etudiant() {
    }
}
