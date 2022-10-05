package tn.esprit.projetkaddem;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "Equipe")
public class Equipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipe;
    private String nomEquipe;
    private niveau niveau;

    @OneToOne
    private Equipe_Detail Equipe_Detail;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants;


}
