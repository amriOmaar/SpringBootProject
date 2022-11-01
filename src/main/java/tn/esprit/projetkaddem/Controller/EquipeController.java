package tn.esprit.projetkaddem.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetkaddem.Entities.Equipe;
import tn.esprit.projetkaddem.Service.EquipeService;

import java.util.List;


@AllArgsConstructor
@RestController
public class EquipeController {


    EquipeService equipeService;

    //creating a get mapping that retrieves all the Equipes detail from the database
    @GetMapping("/Equipes")
    private List<Equipe> getAllEquipes() {
        return equipeService.getEquipes();
    }

    //creating a get mapping that retrieves the detail of a specific Equipe
    @PostMapping("/AddEquipe")
    public Equipe addEquipe (@RequestBody Equipe equipe){
        return equipeService.saveEquipe(equipe);
    }
    @PostMapping("/AddEquipes")
    public List<Equipe> addEquipes (@RequestBody List<Equipe> equipes){
        return equipeService.saveEquipes(equipes);
    }
    @PutMapping("/UpdateEquipe")
    public Equipe updateEquipe (@RequestBody Equipe equipe){
        return equipeService.upadateEquipe(equipe);
    }

    @DeleteMapping("/DeleteEquipe/{idEquipe}")
    public String deleteEquipe (@PathVariable Long idEquipe){
        return equipeService.deleteEquipe(idEquipe);
    }


    @GetMapping("/findequipeDetailequipe/{tg}")
    public List<Equipe> findEquipeByDetailEquipeThematiqueLike(@PathVariable("tg") String thematique){
        return equipeService.findEquipeByDetailEquipeThematique(thematique);
    }

}
