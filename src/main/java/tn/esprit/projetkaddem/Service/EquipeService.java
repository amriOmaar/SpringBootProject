package tn.esprit.projetkaddem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projetkaddem.Entities.Equipe;
import tn.esprit.projetkaddem.Repository.EquipeRepository;

import java.util.List;

@Service
public class EquipeService {


    @Autowired
    EquipeRepository equipeRepository;


    public List<Equipe> getEquipes(){
        return equipeRepository.findAll();
    }

    public Equipe saveEquipe(Equipe equipe){
        return equipeRepository.save(equipe);
    }
    public List<Equipe> saveEquipes(List<Equipe> equipes){
        return equipeRepository.saveAll(equipes);
    }

    public String deleteEquipe(Long idEquipe){
        equipeRepository.deleteById(idEquipe);
        return "Equipe supprimé !" +idEquipe;
    }
    public Equipe upadateEquipe(Equipe equipe){
        Equipe existingEquipe = equipeRepository.findById(equipe.getIdEquipe()).orElse(null);
        existingEquipe.setNomEquipe(equipe.getNomEquipe());
        existingEquipe.setNiveau(equipe.getNiveau());
        existingEquipe.setEquipe_Detail(equipe.getEquipe_Detail());
        existingEquipe.setEtudiants(equipe.getEtudiants());

        return equipeRepository.save(existingEquipe);
    }


}
