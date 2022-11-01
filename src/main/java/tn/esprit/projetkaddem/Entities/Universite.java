package tn.esprit.projetkaddem.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "Universite")
@AllArgsConstructor
@Getter
@Setter
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniv;
    private String nomUniv;

    @OneToMany
    private Set<Departement> departements;

    public Universite() {
    }
}
