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


    @GetMapping("/allEquipes")
    private List<Equipe> getAllEquipes() {
        return equipeService.getEquipes();
    }


    @PostMapping("/addEquipe")
    public Equipe saveEquipe (@RequestBody Equipe equipe){
        return equipeService.saveEquipe(equipe);
    }


    @PostMapping("/addEquipes")
    public List<Equipe> addEquipes (@RequestBody List<Equipe> equipes){
        return equipeService.saveEquipes(equipes);
    }


    @PutMapping("/updateEquipe")
    public Equipe updateEquipe (@RequestBody Equipe equipe){
        return equipeService.upadateEquipe(equipe);
    }

    @DeleteMapping("/deleteEquipe/{idEquipe}")
    public String deleteEquipe (@PathVariable Long idEquipe){
        return equipeService.deleteEquipe(idEquipe);
    }


    @GetMapping("/findequipeDetailequipe/{tg}")
    public List<Equipe> findEquipeByDetailEquipeThematiqueLike(@PathVariable("tg") String thematique){
        return equipeService.findEquipeByDetailEquipeThematique(thematique);
    }


    @GetMapping("/faireEvoluerEquipes")
    public void faireEvoluerEquipes(){
        equipeService.faireEvoluerEquipes();
    }


}
