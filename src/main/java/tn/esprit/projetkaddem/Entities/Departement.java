package tn.esprit.projetkaddem.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "Departement")
    public class Departement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepart;
    private String nomDepart;

    @OneToMany(mappedBy = "departement")
    private Set<Etudiant> etudiants;


    public Departement(Long idDepart, String nomDepart, Etudiant etudiant) {
        this.idDepart = idDepart;
        this.nomDepart = nomDepart;

        this.etudiants = etudiants;
    }

    public Departement() {
    }

    public Departement(Long idDepart, String nomDepart, Set<Etudiant> etudiants) {
        this.idDepart = idDepart;
        this.nomDepart = nomDepart;
        this.etudiants = etudiants;
    }

    public Long getIdDepart() {
        return idDepart;
    }

    public void setIdDepart(Long idDepart) {
        this.idDepart = idDepart;
    }

    public String getNomDepart() {
        return nomDepart;
    }

    public void setNomDepart(String nomDepart) {
        this.nomDepart = nomDepart;
    }

    public Set<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(Set<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "idDepart=" + idDepart +
                ", nomDepart='" + nomDepart + '\'' +
                ", etudiants=" + etudiants +
                '}';
    }
}
