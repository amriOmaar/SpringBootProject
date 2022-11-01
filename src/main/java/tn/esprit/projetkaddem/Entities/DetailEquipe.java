package tn.esprit.projetkaddem.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "DetailEquipe")
@AllArgsConstructor
@Getter
@Setter
public class DetailEquipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDetailEquipe;

    private int salle;
    public String thematique;

    @OneToOne(mappedBy = "detailEquipe")
    @JsonIgnore
    private Equipe equipe;



    public DetailEquipe() {
    }

}
