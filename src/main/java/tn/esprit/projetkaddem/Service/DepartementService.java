package tn.esprit.projetkaddem.Service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projetkaddem.Entities.Departement;
import tn.esprit.projetkaddem.Repository.DepartementRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class DepartementService implements IDepartementService {


    DepartementRepository DepartementRepository;


    @Override
    public List<Departement> getAllDepartements() {
        return DepartementRepository.findAll();
    }

    @Override
    public Departement getDepartementByID(Long idDep){
        return DepartementRepository.findById(idDep).get();
    }

    @Override
    public Departement saveDepartement(Departement Departement){
        return DepartementRepository.save(Departement);
    }

    @Override
    public List<Departement> saveDepartements(List<Departement> departements){
        return DepartementRepository.saveAll(departements);
    }

    @Override
    public String deleteDepartement(Long idDepartement){
        DepartementRepository.deleteById(idDepartement);
        return "Departement supprimé !" +idDepartement;
    }

    @Override
    public Departement upadateDepartement(Departement departement){
        Departement existingDepartement = DepartementRepository.findById(departement.getIdDepart()).orElse(null);
        existingDepartement.setNomDepart(departement.getNomDepart());
        existingDepartement.setEtudiants(departement.getEtudiants());

        return DepartementRepository.save(existingDepartement);
    }


}
