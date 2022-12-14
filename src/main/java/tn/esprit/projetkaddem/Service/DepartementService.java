package tn.esprit.projetkaddem.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.projetkaddem.Entities.*;
import tn.esprit.projetkaddem.Repository.*;
import java.util.*;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class DepartementService implements IDepartementService {

    DepartmentRepository departmentRepository;
    UniversiteRepository universiteRepository;
    EtudiantRepository etudiantRepository;
    EquipeRepository equipeRepository;
    ContratRepository contratRepository;

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
        /* if (departement.getNomDepart().length() <= 3)
            throw new RuntimeException(
                    "Length of Nom depart must be 4 or more");

         */
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
                      toUpdateDepartement.setChefDepart(departement.getChefDepart());
        }
        return departmentRepository.save(toUpdateDepartement);

    }

    @Override
    public Set<Departement> retrieveDepartementsByUniversite(Long idUniversite) {
        Universite university=universiteRepository.findById(idUniversite).orElse(null);
        return  university.getDepartements();
    }

    @Override
    public Departement addDepartementToUniversity(Departement deprt, Long idUniversite){

        Universite univ = universiteRepository.findById(idUniversite).orElse(null);
        departmentRepository.save(deprt);
        univ.getDepartements().add(deprt);
        universiteRepository.save(univ);
        return deprt;
    }

    @Override
    public List<Departement> getDepartByNomPrenom(String nom, String prenom) {
        return departmentRepository.getDepartementByNomAndPrenomEtudiant(nom, prenom);
    }


    @Override
    public String nbrDepart() {
        int j=0 ;
        List<Departement> Listdepts = departmentRepository.findAll();
        for(int i=0;i<Listdepts.size();i++){
            j++;
        }
        return "On a " + j + " Departements";
    }

    @Override
    public Long nbrEtudByDepart() {
        long nbrEtu=0 ;
        List<Departement> Listdepts = departmentRepository.findAll();
        for(int i=0;i<Listdepts.size();i++){
            return nbrEtu = Listdepts.get(i).getEtudiants().stream().map(e -> e.getDepartement()).count();
        }
        return nbrEtu;
    }

    @Override
    public long nbrEtudByOneDepart(String nomDepart) {
        long nbrEtu=0 ;
        Departement d = this.departmentRepository.findByNomDepart(nomDepart);
            return nbrEtu = d.getEtudiants().stream().map(e -> e.getDepartement()).count();
    }

    @Override
    public Map<Option, Long> afficherOptionForDepartement(String nomDepart){
        Departement departement=departmentRepository.findByNomDepart(nomDepart);
        if(departement!=null){
            return   departement.getEtudiants().stream().collect(Collectors.groupingBy(Etudiant::getOption,Collectors.counting()));
        }
        return null;
    }

    @Override
    public List<Departement> triDepartement(){
        return departmentRepository.triDepartement();
    }

    @Override
    public List<Departement> findAllByEtudiantsEquipesIdeNiveau(Niveau niveau) {
        return departmentRepository.findAllByEtudiantsEquipesNiveau(niveau);
    }


    @Override
    public List<Departement> getDepartByNom(String nomDepart) {
        List<Departement> departements=departmentRepository.findAll();
        List<Departement> newList= new ArrayList<>() ;

        for (int i=0; i<departements.size(); i++){
            Departement d = departements.get(i);
            if(d.getNomDepart().contains(nomDepart)){
                newList.add(d);
            }
        }
            return newList;
    }


}

