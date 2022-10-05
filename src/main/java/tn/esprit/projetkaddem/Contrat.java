package tn.esprit.projetkaddem;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "Contrat")
public class Contrat  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;
    @Temporal (TemporalType.DATE)
    private Date dateDebutContrat;
    @Temporal (TemporalType.DATE)
    private Date dateFinContrat;
    private Specialite Specialite;
    private Boolean archive;

    @ManyToOne
    private Etudiant etudiant;

}
