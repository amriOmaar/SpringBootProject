package tn.esprit.projetkaddem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projetkaddem.Entities.Equipe_Detail;

import java.util.List;

@Repository
public interface Equipe_DetailRepository extends JpaRepository<Equipe_Detail,Long> {

    List<Equipe_Detail> findByThematiqueLike (String thematique);




}
