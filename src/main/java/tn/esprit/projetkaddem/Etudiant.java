package tn.esprit.projetkaddem;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "Etudiant")
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

    @ManyToMany(mappedBy = "etudiants", fetch = FetchType.EAGER)
    private Set<Equipe> equipes;


}
