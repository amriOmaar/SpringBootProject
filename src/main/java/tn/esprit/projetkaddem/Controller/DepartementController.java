package tn.esprit.projetkaddem.Controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetkaddem.Entities.Departement;
import tn.esprit.projetkaddem.Entities.Etudiant;
import tn.esprit.projetkaddem.Service.DepartementService;
import tn.esprit.projetkaddem.Service.IDepartementService;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
public class DepartementController {

    IDepartementService departementService;

    @GetMapping("/getDepartements")
    public List<Departement> getDepartements(){
        return departementService.getDepartements();
    }

    @GetMapping("/getDepartmentById/{idDep}")
    public Departement getDepartementByID(@PathVariable("idDep") Long idDep){
        return departementService.getDepartementByID(idDep);
    }

    @PostMapping("/addDepart")
    public Departement saveDepartement(@RequestBody Departement departement){
        return departementService.saveDepartement(departement);
    }

    @PostMapping("/addDeparts")
    public List<Departement> saveDepartements (@RequestBody List<Departement> departements){
        return departementService.saveDepartements(departements);
    }

    @PutMapping("/update/{idDepartement}")
    public Departement updateDepartement (@PathVariable("idDepartement") Long idDepartement, @RequestBody Departement departement){
        return departementService.upadateDepartement(idDepartement, departement);
    }

    @DeleteMapping("/delete/{idDepartement}")
    public String deleteDepartement (@PathVariable Long idDepartement){
        return departementService.deleteDepartement(idDepartement);
    }

    /*

    @GetMapping("/getDeptByOption/{option}")
    public Set<Set<Etudiant>> getEtudiantbyoption(@PathVariable("option") String option) {
        return departementService.getDepartements().stream().
                map(departement -> departement.getEtudiants().
                        stream().
                        filter(etudiant ->  Objects.equals(etudiant.getOption().toString(), option)).
                        collect(Collectors.toSet())).
                collect(Collectors.toSet());

    }

     */

    @GetMapping("/getDepartByUniversity/{idUniversite}")
    public Set<Departement> GetDepByIdUni(@PathVariable("idUniversite") Long idUniversite){

        return  departementService.retrieveDepartementsByUniversite(idUniversite);
    }

    @PostMapping("/addDeaprtToUniv/{idUniversite}")
    public  void addDepartementToUniversity(@RequestBody Departement depart,@PathVariable("idUniversite") Long idUniversite){
        departementService.addDepartementToUniversity(depart,idUniversite);
    }

    @GetMapping("/getDepartBynomprenom/{nom}/{prenom}")
    public List<Departement> getDepartBynomprenom(@PathVariable("nom") String nom, @PathVariable("prenom") String prenom){

        return  departementService.getDepartByNomPrenom(nom, prenom);
    }


    @GetMapping("/nbrDeparts")
    public String NbrDeparts(){
        return departementService.nbrDepart();
    }

    @GetMapping("/nbrEtu")
    public long NbrEtud(){
        return departementService.nbrEtudByDepart();
    }

    @GetMapping("/nbrEtudOneDeprt/{idDeprt}")
    public long NbrEtudOneDeprt(@PathVariable("idDeprt") Long idDeprt){
        return departementService.nbrEtudByOneDepart(idDeprt);
    }



}
