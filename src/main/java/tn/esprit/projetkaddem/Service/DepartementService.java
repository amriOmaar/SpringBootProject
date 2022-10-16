package tn.esprit.projetkaddem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projetkaddem.Entities.Departement;
import tn.esprit.projetkaddem.Repository.DepartementRepository;

import java.util.List;

@Service
public class DepartementService {

    @Autowired
    DepartementRepository DepartementRepository;


    public List<Departement> getAllDepartements() {
        return DepartementRepository.findAll();
    }

    public Departement getDepartementByID(Long idDep){
        return DepartementRepository.findById(idDep).get();
    }

    public Departement saveDepartement(Departement Departement){
        return DepartementRepository.save(Departement);
    }

    public List<Departement> saveDepartements(List<Departement> departements){
        return DepartementRepository.saveAll(departements);
    }

    public String deleteDepartement(Long idDepartement){
        DepartementRepository.deleteById(idDepartement);
        return "Departement supprimé !" +idDepartement;
    }



    public Departement upadateDepartement(Departement departement){
        Departement existingDepartement = DepartementRepository.findById(departement.getIdDepart()).orElse(null);
        existingDepartement.setNomDepart(departement.getNomDepart());
        existingDepartement.setEtudiants(departement.getEtudiants());

        return DepartementRepository.save(existingDepartement);
    }


}
