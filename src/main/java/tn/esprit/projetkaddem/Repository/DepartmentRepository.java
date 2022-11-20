package tn.esprit.projetkaddem.Repository;

import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projetkaddem.Entities.*;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Departement, Long> {

    Departement findByNomDepart(String nomDepart);

    /*Departement findDepartementByEtudiantsOption(String option);*/


}
