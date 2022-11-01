package tn.esprit.projetkaddem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projetkaddem.Entities.Equipe;

import java.util.List;


public interface EquipeRepository extends JpaRepository<Equipe,Long> {


    //List<Equipe> findEquipeByDetailEquipeThematiqueLike(String thematique);

    List<Equipe> findEquipeByDetailEquipeThematique(String tg);

}
