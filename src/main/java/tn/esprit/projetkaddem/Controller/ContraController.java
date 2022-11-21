package tn.esprit.projetkaddem.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetkaddem.Entities.Contrat;
import tn.esprit.projetkaddem.Service.ContratService;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@RestController
public class ContraController {


    ContratService contratService;


    @GetMapping("/contrats")
    private List<Contrat> getAllcontrats() {
        return contratService.getAllcontrats();
    }

    @GetMapping("/contrats/{idContrat}")
    private Contrat getContratByID(Long idContrat){
        return contratService.getContratByID(idContrat);
    }

    @PostMapping("/AddContrat")
    private Contrat saveContrat(@RequestBody Contrat Contrat){
        return contratService.saveContrat(Contrat);
    }

    @PostMapping("/AddAllContrats")
    private List<Contrat> saveAllContrat(@RequestBody List<Contrat> Contrats){
        return contratService.saveAllContrats(Contrats);
    }

    @DeleteMapping("/DeleteContrat/{idContrat}")
    private String deleteContrat(@PathVariable Long idContrat) {
        return contratService.deleteContrat(idContrat);
    }

    @PutMapping("/UpdateContrat")
    public Contrat updateContrat (@RequestBody Contrat contrat){
        return contratService.upadateContrat(contrat);
    }


    @GetMapping("/getCiffreAffaire/{DateDebutContrat}/{DateFinContrat}")
    public Float GetCiffreAffaire(@PathVariable("DateDebutContrat") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateD, @PathVariable("DateFinContrat")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date dateF){

        return  contratService.getChiffreAffaireEntreDeuxDate(dateD,dateF);
    }



}
