package tn.esprit.projetkaddem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projetkaddem.Entities.Universite;


@Repository
public interface UniversiteRepository extends JpaRepository<Universite,Long>
{

}
