package tn.esprit.projetkaddem.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.projetkaddem.Entities.Departement;
import tn.esprit.projetkaddem.Entities.Etudiant;
import tn.esprit.projetkaddem.Entities.Option;
import tn.esprit.projetkaddem.Entities.Universite;
import tn.esprit.projetkaddem.Repository.DepartmentRepository;
import tn.esprit.projetkaddem.Repository.UniversiteRepository;

import java.util.List;
import java.util.Objects;
import java.util.Set;


@Service
@AllArgsConstructor
public class DepartementService implements IDepartementService {

    DepartmentRepository departmentRepository;

    UniversiteRepository universiteRepository;

    @Override
    public List<Departement> getDepartements() {
        return departmentRepository.findAll();
    }

    @Override
    public Departement getDepartementByID(Long idDep){
        return departmentRepository.findById(idDep).orElse(null);
    }

    @Override
    public Departement saveDepartement(Departement departement) {
            return departmentRepository.save(departement);
    }

    @Override
    public List<Departement> saveDepartements(List<Departement> departements){
        return departmentRepository.saveAll(departements);
    }

    @Override
    public String deleteDepartement(Long idDepartement){
        departmentRepository.deleteById(idDepartement);
        return "Departement supprimé !" +idDepartement;
    }

    @Override
    public Departement upadateDepartement(Long idDepartement, Departement departement) {

        Departement toUpdateDepartement = departmentRepository.findById(idDepartement).get();

        if (Objects.nonNull(departement.getNomDepart()) && !"".equalsIgnoreCase(departement.getNomDepart())) {
                      toUpdateDepartement.setNomDepart(departement.getNomDepart());
        }
        return departmentRepository.save(toUpdateDepartement);

    }

    @Override
    public List<Departement> retrieveDepartementByOptionEtudiant(Option op) {
        return departmentRepository.retrieveDepartementByOptionEtudiant(op);
    }
/*
    @Override
    public Departement findDepartementByEtudiants(String option) {
        /*Departement departement = departmentRepository.findById(idDepart).orElse(null);

        return departmentRepository.findDepartementByEtudiantsOption(option);
    }*/



    @Override
    public Set<Departement> retrieveDepartementsByUniversite(Long idUniversite) {

        Universite university=universiteRepository.findById(idUniversite).orElse(null);
        return  university.getDepartements();
    }

}

