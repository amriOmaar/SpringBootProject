package tn.esprit.projetkaddem;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "Universite")
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniv;
    private String nomUniv;

    @OneToMany
    private Set<Departement> departements;

}
