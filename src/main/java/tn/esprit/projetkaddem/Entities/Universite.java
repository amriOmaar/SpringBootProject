package tn.esprit.projetkaddem.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "Universite")
@AllArgsConstructor
@Data
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
