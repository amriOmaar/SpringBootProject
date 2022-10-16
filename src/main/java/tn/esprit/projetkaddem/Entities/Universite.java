package tn.esprit.projetkaddem.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "Universite")
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniv;
    private String nomUniv;

    @OneToMany
    private Set<Departement> departements;

    public Universite() {
    }

    public Universite(Long idUniv, String nomUniv, Set<Departement> departements) {
        this.idUniv = idUniv;
        this.nomUniv = nomUniv;
        this.departements = departements;
    }

    public Long getIdUniv() {
        return idUniv;
    }

    public void setIdUniv(Long idUniv) {
        this.idUniv = idUniv;
    }

    public String getNomUniv() {
        return nomUniv;
    }

    public void setNomUniv(String nomUniv) {
        this.nomUniv = nomUniv;
    }

    public Set<Departement> getDepartements() {
        return departements;
    }

    public void setDepartements(Set<Departement> departements) {
        this.departements = departements;
    }

    @Override
    public String toString() {
        return "Universite{" +
                "idUniv=" + idUniv +
                ", nomUniv='" + nomUniv + '\'' +
                ", departements=" + departements +
                '}';
    }
}
