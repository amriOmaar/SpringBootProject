package tn.esprit.projetkaddem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projetkaddem.Entities.*;

import java.util.Date;
import java.util.List;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long> {

    List<Contrat> findAllByDateDebutContratOrDateFinContratOrSpecialiteOrArchive(Date dateDebut,
                                                                                 Date dateFin,
                                                                                 Specialite specialite,
                                                                                 boolean archive);

}
