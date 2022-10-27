package tn.esprit.projetkaddem.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "Etudiant")
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

    @ManyToMany(mappedBy = "etudiants", fetch = FetchType.EAGER)
    private Set<Equipe> equipes;

    public Etudiant() {
    }

    public Etudiant(Long idEtudiant, String prenom, String nom, Option option, Set<Contrat> contrats, Departement departement, Set<Equipe> equipes) {
        this.idEtudiant = idEtudiant;
        this.prenom = prenom;
        this.nom = nom;
        this.option = option;
        this.contrats = contrats;
        this.departement = departement;
        this.equipes = equipes;
    }

    public Etudiant(Long idEtudiant, String prenom, String nom, Option option) {
        this.idEtudiant = idEtudiant;
        this.prenom = prenom;
        this.nom = nom;
        this.option = option;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "idEtudiant=" + idEtudiant +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", option=" + option +
                ", contrats=" + contrats +
                ", departement=" + departement +
                ", equipes=" + equipes +
                '}';
    }
}
