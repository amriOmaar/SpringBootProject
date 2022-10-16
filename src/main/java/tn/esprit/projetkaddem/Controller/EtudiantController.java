package tn.esprit.projetkaddem.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetkaddem.Entities.Etudiant;
import tn.esprit.projetkaddem.Service.EtudiantService;
import java.util.List;

@RestController
public class EtudiantController {

    @Autowired
    EtudiantService EtudiantService;

    @GetMapping("/etudiants")
    private List<Etudiant> getAlletudiants() {
        return EtudiantService.getEtudiants();
    }

    @GetMapping("/etudiant/{idEtudiant}")
    private Etudiant getEtudiant(@PathVariable("idEtudiant") long idEtudiant) {
        return EtudiantService.getEtudiantById(idEtudiant);
    }

    @GetMapping("/EtudiantByPrenom/{prenom}")
    public Etudiant getEtudiantByPrenom(@PathVariable String prenom){
        return EtudiantService.getEtudiantByPnemom(prenom);
    }

    @GetMapping("/EtudiantByNom/{nom}")
    public Etudiant getEtudiantByNom(@PathVariable String nom){
        return EtudiantService.getEtudiantByNom(nom);
    }


    @PostMapping("/AddEtudiant")
    public Etudiant addEtudiant (@RequestBody Etudiant etudiant){
        return EtudiantService.saveEtudiant(etudiant);
    }

    @PostMapping("/AddEtudiants")
    public List<Etudiant> saveEtudiants(@RequestBody List<Etudiant> Etudiant){
        return EtudiantService.saveEtudiants(Etudiant);
    }


    @PutMapping("/UpdateEtudiant")
    public Etudiant updateEtudiant (@RequestBody Etudiant etudiant){
        return EtudiantService.upadateEtudiant(etudiant);
    }

    @DeleteMapping("/DeleteEtudiant/{idEtudiant}")
    public String deleteEtudiant (@PathVariable Long idEtudiant){
        return EtudiantService.deleteEtudiant(idEtudiant);
    }


}
