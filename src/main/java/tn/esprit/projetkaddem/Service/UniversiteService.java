package tn.esprit.projetkaddem.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projetkaddem.Entities.Universite;
import tn.esprit.projetkaddem.Repository.UniversiteRepository;

import java.util.List;

@Service
public class UniversiteService {


    @Autowired
    UniversiteRepository UniversiteRepository;


    public List<Universite> getUniversites(){
        return UniversiteRepository.findAll();
    }

    public Universite saveUniversite(Universite universite){
        return UniversiteRepository.save(universite);
    }
    public List<Universite> saveUniversites(List<Universite> universites){
        return UniversiteRepository.saveAll(universites);
    }

    public String deleteUniversite(Long idUniversite){
        UniversiteRepository.deleteById(idUniversite);
        return "Universite supprimé !" +idUniversite;
    }
    public Universite upadateUniversite(Universite universite){
        Universite existingUniversite = UniversiteRepository.findById(universite.getIdUniv()).orElse(null);
        existingUniversite.setNomUniv(universite.getNomUniv());
        existingUniversite.setDepartements(universite.getDepartements());
        return UniversiteRepository.save(existingUniversite);
    }



}
