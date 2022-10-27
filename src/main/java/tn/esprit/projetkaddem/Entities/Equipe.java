package tn.esprit.projetkaddem.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import tn.esprit.projetkaddem.Entities.*;


@Entity(name = "Equipe")
@Getter
@Setter
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
