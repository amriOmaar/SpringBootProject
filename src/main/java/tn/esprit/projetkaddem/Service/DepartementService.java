package tn.esprit.projetkaddem.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.projetkaddem.Entities.Departement;
import tn.esprit.projetkaddem.Entities.Etudiant;
import tn.esprit.projetkaddem.Entities.Universite;
import tn.esprit.projetkaddem.Repository.DepartmentRepository;

import java.util.List;
import java.util.Objects;


@Service
@AllArgsConstructor
public class DepartementService implements IDepartementService {

    DepartmentRepository departmentRepository;

    @Override
    public List<Departement> getAllDepartements() {
        return departmentRepository.findAll();
    }

    @Override
    public Departement getDepartementByID(Long idDep){
        return departmentRepository.findById(idDep).get();
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


        /*
        if (departmentRepository.findById(idDepartement).isPresent()) {
            Departement toUpdateDepartement = departmentRepository.findById(idDepartement).get();
            toUpdateDepartement.setNomDepart(departement.getNomDepart());

            return departmentRepository.save(toUpdateDepartement);
        }
        return departement;
    */
    }
/*
    @Override
    public Departement findDepartementByEtudiants(String option) {
        /*Departement departement = departmentRepository.findById(idDepart).orElse(null);

        return departmentRepository.findDepartementByEtudiantsOption(option);
    }*/
}

