package tn.esprit.projetkaddem.Service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.projetkaddem.Entities.Departement;
import tn.esprit.projetkaddem.Entities.Universite;
import tn.esprit.projetkaddem.Repository.DepartmentRepository;
import tn.esprit.projetkaddem.Repository.UniversiteRepository;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@Service
public class UniversiteService implements IUniversite {



    UniversiteRepository universiteRepository;
    DepartmentRepository departmentRepository;

    public List<Universite> getUniversites(){
        return universiteRepository.findAll();
    }

    public Universite saveUniversite(Universite universite){
        return universiteRepository.save(universite);
    }
    public List<Universite> saveUniversites(List<Universite> universites){
        return universiteRepository.saveAll(universites);
    }



    public Universite upadateUniversite(Long idUniv, Universite universite) {
        Universite toUpdateUniversite = universiteRepository.findById(idUniv).get();

        if (Objects.nonNull(universite.getNomUniv()) && !"".equalsIgnoreCase(universite.getNomUniv())) {
            toUpdateUniversite.setNomUniv(universite.getNomUniv());
        }
        return universiteRepository.save(toUpdateUniversite);

    }

    public String deleteUniversite(Long idUniv){
        universiteRepository.deleteById(idUniv);
        return "Universite supprimé !" +idUniv;
    }


    @Override
    public void assignUniversiteToDepartement(Long idUniversite, Long idDepartement) {

        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        Departement departement = departmentRepository.findById(idDepartement).orElse(null);

        universite.getDepartements().add(departement);
        universiteRepository.save(universite);


    }


}
