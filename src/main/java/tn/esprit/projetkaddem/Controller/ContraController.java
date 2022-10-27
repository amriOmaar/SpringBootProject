package tn.esprit.projetkaddem.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetkaddem.Entities.Contrat;
import tn.esprit.projetkaddem.Service.ContratService;

import java.util.List;


@AllArgsConstructor
@RestController
public class ContraController {


    ContratService ContratService;


    @GetMapping("/contrats")
    private List<Contrat> getAllcontrats() {
        return ContratService.getAllcontrats();
    }

    @GetMapping("/contrats/{idContrat}")
    private Contrat getContratByID(Long idContrat){
        return ContratService.getContratByID(idContrat);
    }

    @PostMapping("/AddContrat")
    private Contrat saveContrat(@RequestBody Contrat Contrat){
        return ContratService.saveContrat(Contrat);
    }

    @PostMapping("/AddAllContrats")
    private List<Contrat> saveAllContrat(@RequestBody List<Contrat> Contrats){
        return ContratService.saveAllContrats(Contrats);
    }

    @DeleteMapping("/DeleteContrat/{idContrat}")
    private String deleteContrat(@PathVariable Long idContrat) {
        return ContratService.deleteContrat(idContrat);
    }

    @PutMapping("/UpdateContrat")
    public Contrat updateContrat (@RequestBody Contrat contrat){
        return ContratService.upadateContrat(contrat);
    }



}
