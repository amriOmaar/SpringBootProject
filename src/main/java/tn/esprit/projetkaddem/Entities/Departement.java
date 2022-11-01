package tn.esprit.projetkaddem.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "Departement")
@AllArgsConstructor
@Getter
@Setter
    public class Departement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepart;
    private String nomDepart;

    @OneToMany(mappedBy = "departement")
    private Set<Etudiant> etudiants;


    public Departement() {
    }
}
