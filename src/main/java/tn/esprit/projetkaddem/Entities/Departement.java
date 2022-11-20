package tn.esprit.projetkaddem.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "Departement")
@AllArgsConstructor
@Data
    public class Departement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepart;
    private String nomDepart;

    /*@OneToMany(mappedBy = "departement")
    @JsonIgnore
    private Set<Etudiant> etudiants;*/

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departement")
    private Set<Etudiant> etudiants;


    public Departement() {
    }
}
