package tn.esprit.projetkaddem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projetkaddem.Entities.Departement;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Long> {



}
