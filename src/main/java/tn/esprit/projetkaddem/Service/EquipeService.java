package tn.esprit.projetkaddem.Service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projetkaddem.Entities.Equipe;
import tn.esprit.projetkaddem.Repository.EquipeRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class EquipeService implements IEquipeService {


    EquipeRepository equipeRepository;


    @Override
    public List<Equipe> getEquipes(){
        return equipeRepository.findAll();
    }

    @Override
    public Equipe saveEquipe(Equipe equipe){
        return equipeRepository.save(equipe);
    }

    @Override
    public List<Equipe> saveEquipes(List<Equipe> equipes){
        return equipeRepository.saveAll(equipes);
    }


    @Override
    public String deleteEquipe(Long idEquipe){
        equipeRepository.deleteById(idEquipe);
        return "Equipe supprimé !" +idEquipe;
    }

    @Override
    public Equipe upadateEquipe(Equipe equipe){
        Equipe existingEquipe = equipeRepository.findById(equipe.getIdEquipe()).orElse(null);
        existingEquipe.setNomEquipe(equipe.getNomEquipe());
        existingEquipe.setNiveau(equipe.getNiveau());
        existingEquipe.setEquipe_Detail(equipe.getEquipe_Detail());
        existingEquipe.setEtudiants(equipe.getEtudiants());

        return equipeRepository.save(existingEquipe);
    }






    @Override
    public List<Equipe> findByEtudiantsIdEtudiant (Long idEtudiant) {
        return equipeRepository.findByEtudiantsIdEtudiant(idEtudiant);

    }




}
