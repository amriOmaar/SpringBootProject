package tn.esprit.projetkaddem.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import tn.esprit.projetkaddem.Entities.Specialite;

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

    public Contrat(Long idContrat, Date dateDebutContrat, Date dateFinContrat, tn.esprit.projetkaddem.Entities.Specialite specialite, Boolean archive, Etudiant etudiant) {
        this.idContrat = idContrat;
        this.dateDebutContrat = dateDebutContrat;
        this.dateFinContrat = dateFinContrat;
        Specialite = specialite;
        this.archive = archive;
        this.etudiant = etudiant;
    }

    public Contrat() {
    }

    public Long getIdContrat() {
        return idContrat;
    }

    public void setIdContrat(Long idContrat) {
        this.idContrat = idContrat;
    }

    public Date getDateDebutContrat() {
        return dateDebutContrat;
    }

    public void setDateDebutContrat(Date dateDebutContrat) {
        this.dateDebutContrat = dateDebutContrat;
    }

    public Date getDateFinContrat() {
        return dateFinContrat;
    }

    public void setDateFinContrat(Date dateFinContrat) {
        this.dateFinContrat = dateFinContrat;
    }

    public Specialite getSpecialite() {
        return Specialite;
    }

    public void setSpecialite(Specialite Specialite) {
        this.Specialite = Specialite;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }


    @Override
    public String toString() {
        return "Contrat{" +
                "idContrat=" + idContrat +
                ", dateDebutContrat=" + dateDebutContrat +
                ", dateFinContrat=" + dateFinContrat +
                ", Specialite=" + Specialite +
                ", archive=" + archive +
                ", etudiant=" + etudiant +
                '}';
    }
}
