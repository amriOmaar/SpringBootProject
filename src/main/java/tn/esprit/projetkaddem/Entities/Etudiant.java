package tn.esprit.projetkaddem.Entities;

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

    public Long getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(Long idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public Set<Contrat> getContrats() {
        return contrats;
    }

    public void setContrats(Set<Contrat> contrats) {
        this.contrats = contrats;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Set<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(Set<Equipe> equipes) {
        this.equipes = equipes;
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
