package tn.esprit.projetkaddem.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetkaddem.Entities.Equipe_Detail;
import tn.esprit.projetkaddem.Service.Equipe_DetailService;

import java.util.List;

@RestController
public class Equipe_DetailController {

    @Autowired
    Equipe_DetailService Equipe_DetailService;



    @GetMapping("/detailEquipes")
    private List<Equipe_Detail> getAlldetailEquipes() {
        return Equipe_DetailService.getDetailEquipes();
    }


    @PostMapping("/AddDetailEquipe")
    public Equipe_Detail addDetailEquipe (@RequestBody Equipe_Detail Equipe_Detail){
        return Equipe_DetailService.saveDetailEquipe(Equipe_Detail);
    }
    @PostMapping("/AddDetailEquipes")
    public List<Equipe_Detail> addDetailEquipes (@RequestBody List<Equipe_Detail> Equipe_Detail){
        return Equipe_DetailService.saveDetailEquipes(Equipe_Detail);
    }
    @PutMapping("/UpdateDetailEquipe")
    public Equipe_Detail updateDetailEquipe (@RequestBody Equipe_Detail Equipe_Detail){
        return Equipe_DetailService.upadateDetailEquipe(Equipe_Detail);
    }

    @DeleteMapping("/DeleteDetailEquipe/{idDetailEquipe}")
    public String deleteDetailEquipe (@PathVariable Long idDetailEquipe){
        return Equipe_DetailService.deleteDetailEquipe(idDetailEquipe);
    }



}
