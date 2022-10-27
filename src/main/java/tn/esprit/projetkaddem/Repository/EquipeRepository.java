package tn.esprit.projetkaddem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projetkaddem.Entities.Equipe;

import java.util.List;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe,Long> {


    List<Equipe> findByEtudiantsIdEtudiant (Long idEtudiant);

    List<Equipe> findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull (Long idEtudiant);







}
