package tn.esprit.projetkaddem.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Entity(name = "Equipe")
@AllArgsConstructor
@Getter
@Setter
public class Equipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipe;
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private niveau niveau;

    @OneToOne
    private DetailEquipe detailEquipe;

    @ManyToMany(mappedBy = "equipes")
    @JsonIgnore
    private Set<Etudiant> etudiants;



    public Equipe() {

    }


}
