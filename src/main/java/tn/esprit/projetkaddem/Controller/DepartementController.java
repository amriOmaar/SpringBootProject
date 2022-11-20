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


    @GetMapping("/getallDepart")
    public List<Departement> getAllDepartements(){
        return departementService.getAllDepartements();
    }

    @GetMapping("/getById/{idDep}")
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

    @GetMapping("/getDeptByOption/{option}")
    public Set<Set<Etudiant>> getEtudiantbyoption(@PathVariable("option") String option) {
        return departementService.getAllDepartements().stream().
                map(departement -> departement.getEtudiants().
                        stream().
                        filter(etudiant ->  Objects.equals(etudiant.getOption().toString(), option)).
                        collect(Collectors.toSet())).
                collect(Collectors.toSet());

    }



}
