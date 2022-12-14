package tn.esprit.projetkaddem.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetkaddem.Entities.Departement;
import tn.esprit.projetkaddem.Entities.Universite;
import tn.esprit.projetkaddem.Service.UniversiteService;

import java.util.List;


@AllArgsConstructor
@RestController
@CrossOrigin
public class UniversiteController {


    UniversiteService universiteService;


    @GetMapping("/getUniversite")
    private List<Universite> getAlluniversites() {
        return universiteService.getUniversites();
    }

    @PostMapping("/saveUniversite")
    public Universite saveUniversite(@RequestBody Universite universite){
        return universiteService.saveUniversite(universite);
    }


    @PostMapping("/addUniversites")
    public List<Universite> addUniversites (@RequestBody List<Universite> universites){
        return universiteService.saveUniversites(universites);
    }

    @PutMapping("/updateUniversite/{idUniv}")
    public Universite updateDepartement (@PathVariable("idUniv") Long idUniv, @RequestBody Universite universite){
        return universiteService.upadateUniversite(idUniv, universite);
    }


    @DeleteMapping("/deleteUniversite/{idUniv}")
    public String deleteDepartement (@PathVariable Long idUniv){
        return universiteService.deleteUniversite(idUniv);
    }


    @PutMapping("/assignUniversiteToDepartement/{idUniversite}/{idDepartement}")
    public void assignUniversiteToDepartement(@PathVariable("idUniversite") Long idUniversite,@PathVariable("idDepartement") Long idDepartement) {
        universiteService.assignUniversiteToDepartement(idUniversite, idDepartement);

    }

}
