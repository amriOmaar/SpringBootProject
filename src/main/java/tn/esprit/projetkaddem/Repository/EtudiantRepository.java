package tn.esprit.projetkaddem.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projetkaddem.Entities.Etudiant;


@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long>
{

    Etudiant findByPrenom(String prenon);
    Etudiant findByNom(String nom);
}
