package tn.esprit.projetkaddem.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "Etudiant")
@AllArgsConstructor
@Getter
@Setter
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
    private Departement departement;

    @ManyToMany()
    private Set<Equipe> equipes;

    public Etudiant() {
    }
}
