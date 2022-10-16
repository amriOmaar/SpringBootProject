package tn.esprit.projetkaddem.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projetkaddem.Entities.Equipe_Detail;
import tn.esprit.projetkaddem.Repository.Equipe_DetailRepository;

import java.util.List;

@Service
public class Equipe_DetailService {


    @Autowired
    Equipe_DetailRepository Equipe_DetailRepository;



    public List<Equipe_Detail> getDetailEquipes(){
        return Equipe_DetailRepository.findAll();
    }
    //getting a specific record by using the method findById() of CrudRepository
    public Equipe_Detail saveDetailEquipe(Equipe_Detail Equipe_Detail){
        return Equipe_DetailRepository.save(Equipe_Detail);
    }
    public List<Equipe_Detail> saveDetailEquipes(List<Equipe_Detail> Equipe_Detail){
        return Equipe_DetailRepository.saveAll(Equipe_Detail);
    }

    public String deleteDetailEquipe(Long idDetailEquipe){
        Equipe_DetailRepository.deleteById(idDetailEquipe);
        return "DetailEquipe supprimé !" +idDetailEquipe;
    }
    public Equipe_Detail upadateDetailEquipe(Equipe_Detail detailEquipe){
        Equipe_Detail existingDetailEquipe = Equipe_DetailRepository.findById(detailEquipe.getIdDetailEquipe()).orElse(null);
        existingDetailEquipe.setSalle(detailEquipe.getSalle());
        existingDetailEquipe.setThematique(detailEquipe.getThematique());
        existingDetailEquipe.setEquipe(detailEquipe.getEquipe());
        return Equipe_DetailRepository.save(existingDetailEquipe);
    }



}
