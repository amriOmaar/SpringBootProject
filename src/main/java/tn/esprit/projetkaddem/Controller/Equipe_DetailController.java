package tn.esprit.projetkaddem.Controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetkaddem.Entities.DetailEquipe;
import tn.esprit.projetkaddem.Service.DetailEquipeService;

import java.util.List;

@AllArgsConstructor
@RestController
public class Equipe_DetailController {


    DetailEquipeService Equipe_DetailService;



    @GetMapping("/detailEquipes")
    private List<DetailEquipe> getAlldetailEquipes() {
        return Equipe_DetailService.getDetailEquipes();
    }


    @PostMapping("/AddDetailEquipe")
    public DetailEquipe addDetailEquipe (@RequestBody DetailEquipe DetailEquipe){
        return Equipe_DetailService.saveDetailEquipe(DetailEquipe);
    }
    @PostMapping("/AddDetailEquipes")
    public List<DetailEquipe> addDetailEquipes (@RequestBody List<DetailEquipe> DetailEquipe){
        return Equipe_DetailService.saveDetailEquipes(DetailEquipe);
    }
    @PutMapping("/UpdateDetailEquipe")
    public DetailEquipe updateDetailEquipe (@RequestBody DetailEquipe DetailEquipe){
        return Equipe_DetailService.upadateDetailEquipe(DetailEquipe);
    }

    @DeleteMapping("/DeleteDetailEquipe/{idDetailEquipe}")
    public String deleteDetailEquipe (@PathVariable Long idDetailEquipe){
        return Equipe_DetailService.deleteDetailEquipe(idDetailEquipe);
    }





}
