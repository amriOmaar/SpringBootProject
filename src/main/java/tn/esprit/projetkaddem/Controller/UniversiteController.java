package tn.esprit.projetkaddem.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetkaddem.Entities.Universite;
import tn.esprit.projetkaddem.Service.UniversiteService;

import java.util.List;


@AllArgsConstructor
@RestController
public class UniversiteController {


    UniversiteService UniversiteService;

    //creating a get mapping that retrieves all the Universites detail from the database
    @GetMapping("/universites")
    private List<Universite> getAlluniversites() {
        return UniversiteService.getUniversites();
    }



    @PostMapping("/AddUniversite")
    public Universite addUniversite (@RequestBody Universite universite){
        return UniversiteService.saveUniversite(universite);
    }
    @PostMapping("/AddUniversites")
    public List<Universite> addUniversites (@RequestBody List<Universite> universites){
        return UniversiteService.saveUniversites(universites);
    }
    @PutMapping("/UpdateUniversite")
    public Universite updateUniversite (@RequestBody Universite universite){
        return UniversiteService.upadateUniversite(universite);
    }

    @DeleteMapping("/DeleteUniversite/{idUniv}")
    public String deleteUniversite (@PathVariable Long idUniv){
        return UniversiteService.deleteUniversite(idUniv);
    }



}
