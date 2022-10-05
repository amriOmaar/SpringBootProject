package tn.esprit.projetkaddem;


import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "DetailEquipe")
public class Equipe_Detail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDetailEquipe;

    private int salle;
    private String thematique;

    @OneToOne(mappedBy = "Equipe_Detail")
    private Equipe Equipe;

}
