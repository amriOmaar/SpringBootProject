package tn.esprit.projetkaddem.Repository;

import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.projetkaddem.Entities.*;

import java.util.Date;
import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Departement, Long> {


    Departement findByNomDepart(String nomDepart);


    @Query("SELECT  departement FROM Departement  departement  , Etudiant e " +
            "where departement.id=e.departement.id " +
            "and e.nom = :nom and e.prenom = :prenom")
    List<Departement> getDepartementByNomAndPrenomEtudiant(@Param("nom") String nom, @Param("prenom") String prenom);


    @Query("select d from Departement d order by d.nomDepart asc")
    List<Departement> triDepartement();

    List<Departement> findAllByEtudiantsEquipesNiveau(Niveau niveau);




}
