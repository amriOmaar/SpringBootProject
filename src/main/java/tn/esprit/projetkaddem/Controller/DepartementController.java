package tn.esprit.projetkaddem.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetkaddem.Entities.Departement;
import tn.esprit.projetkaddem.Service.DepartementService;

import java.util.List;

@RestController
public class DepartementController {

    @Autowired
    DepartementService DepartementService;


    @GetMapping("/departements")
    private List<Departement> getAllDepartements(){
        return DepartementService.getAllDepartements();
    }

    @GetMapping("/departement")
    private Departement getDepartementByID(Long idDep){
        return DepartementService.getDepartementByID(idDep);
    }


    @PostMapping("/AddDepartement")
    private Departement saveDepartement(Departement Departement){
        return DepartementService.saveDepartement(Departement);
    }

    @PostMapping("/AddDepartements")
    public List<Departement> saveDepartements (@RequestBody List<Departement> departements){
        return DepartementService.saveDepartements(departements);
    }

    @PutMapping("/UpdateDepartement")
    public Departement updateDepartement (@RequestBody Departement departement){
        return DepartementService.upadateDepartement(departement);
    }

    @DeleteMapping("/DeleteDepartement/{idDepart}")
    public String deleteDepartement (@PathVariable Long idDepar){
        return DepartementService.deleteDepartement(idDepar);
    }


}
