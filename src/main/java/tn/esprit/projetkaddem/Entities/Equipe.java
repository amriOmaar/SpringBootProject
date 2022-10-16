package tn.esprit.projetkaddem.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import tn.esprit.projetkaddem.Entities.*;


@Entity(name = "Equipe")
public class Equipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipe;
    private String nomEquipe;
    private niveau niveau;

    @OneToOne
    private Equipe_Detail Equipe_Detail;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants;


    public Equipe(Long idEquipe, String nomEquipe, tn.esprit.projetkaddem.Entities.niveau niveau, tn.esprit.projetkaddem.Entities.Equipe_Detail equipe_Detail, Set<Etudiant> etudiants) {
        this.idEquipe = idEquipe;
        this.nomEquipe = nomEquipe;
        this.niveau = niveau;
        Equipe_Detail = equipe_Detail;
        this.etudiants = etudiants;
    }

    public Equipe() {

    }

    public Long getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(Long idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(niveau niveau) {
        this.niveau = niveau;
    }

    public Equipe_Detail getEquipe_Detail() {
        return Equipe_Detail;
    }

    public void setEquipe_Detail(Equipe_Detail equipe_Detail) {
        Equipe_Detail = equipe_Detail;
    }

    public Set<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(Set<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "idEquipe=" + idEquipe +
                ", nomEquipe='" + nomEquipe + '\'' +
                ", niveau=" + niveau +
                ", Equipe_Detail=" + Equipe_Detail +
                ", etudiants=" + etudiants +
                '}';
    }
}
