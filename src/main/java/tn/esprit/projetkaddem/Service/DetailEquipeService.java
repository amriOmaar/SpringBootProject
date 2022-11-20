package tn.esprit.projetkaddem.Service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.projetkaddem.Entities.DetailEquipe;
import tn.esprit.projetkaddem.Repository.DetailEquipeRepository;

import java.util.List;


@AllArgsConstructor
@Service
public class DetailEquipeService implements IDetailEquipeService {

    DetailEquipeRepository DetailEquipeRepository;


    @Override
    public List<DetailEquipe> getDetailEquipes(){
        return DetailEquipeRepository.findAll();
    }


    @Override
    public DetailEquipe saveDetailEquipe(DetailEquipe DetailEquipe){
        return DetailEquipeRepository.save(DetailEquipe);
    }


    @Override
    public List<DetailEquipe> saveDetailEquipes(List<DetailEquipe> DetailEquipe){
        return DetailEquipeRepository.saveAll(DetailEquipe);
    }

    @Override
    public String deleteDetailEquipe(Long idDetailEquipe){
        DetailEquipeRepository.deleteById(idDetailEquipe);
        return "DetailEquipe supprimé !" +idDetailEquipe;
    }

    @Override
    public DetailEquipe upadateDetailEquipe(DetailEquipe detailEquipe){
        return DetailEquipeRepository.save(detailEquipe);
    }




}
