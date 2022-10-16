package tn.esprit.projetkaddem.Entities;


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


    public Equipe_Detail(long idDetailEquipe, int salle, String thematique, tn.esprit.projetkaddem.Entities.Equipe equipe) {
        this.idDetailEquipe = idDetailEquipe;
        this.salle = salle;
        this.thematique = thematique;
        Equipe = equipe;
    }

    public Equipe_Detail() {
    }

    public long getIdDetailEquipe() {
        return idDetailEquipe;
    }

    public void setIdDetailEquipe(long idDetailEquipe) {
        this.idDetailEquipe = idDetailEquipe;
    }

    public int getSalle() {
        return salle;
    }

    public void setSalle(int salle) {
        this.salle = salle;
    }

    public String getThematique() {
        return thematique;
    }

    public void setThematique(String thematique) {
        this.thematique = thematique;
    }

    public tn.esprit.projetkaddem.Entities.Equipe getEquipe() {
        return Equipe;
    }

    public void setEquipe(tn.esprit.projetkaddem.Entities.Equipe equipe) {
        Equipe = equipe;
    }

    @Override
    public String toString() {
        return "Equipe_Detail{" +
                "idDetailEquipe=" + idDetailEquipe +
                ", salle=" + salle +
                ", thematique='" + thematique + '\'' +
                ", Equipe=" + Equipe +
                '}';
    }
}
