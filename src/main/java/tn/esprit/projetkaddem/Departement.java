package tn.esprit.projetkaddem;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "Departement")
    public class Departement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepart;
    private String nomDepart;

    @OneToMany(mappedBy = "departement")
    private Set<Etudiant> etudiants;


    public Departement(Long idDepart, String nomDepart, Etudiant etudiant) {
        this.idDepart = idDepart;
        this.nomDepart = nomDepart;

        this.etudiants = etudiants;
    }

    public Departement() {

    }
}
