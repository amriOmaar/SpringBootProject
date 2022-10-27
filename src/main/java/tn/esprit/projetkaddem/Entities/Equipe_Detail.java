package tn.esprit.projetkaddem.Entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "DetailEquipe")
@Getter
@Setter
public class Equipe_Detail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDetailEquipe;

    private int salle;
    private String thematique;

    @OneToOne(mappedBy = "Equipe_Detail")
    private Equipe Equipe;


    public Equipe_Detail(long idDetailEquipe, int salle, String thematique, tn.esprit.projetkaddem.Entities.Equipe equipe) {
        this.idDetailEquipe = idDetailEquipe;
        this.salle = salle;
        this.thematique = thematique;
        Equipe = equipe;
    }

    public Equipe_Detail() {
    }

}
