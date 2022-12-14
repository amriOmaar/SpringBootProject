package tn.esprit.projetkaddem.Controller;


import lombok.AllArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetkaddem.Entities.*;
import tn.esprit.projetkaddem.Service.*;
import java.io.ByteArrayInputStream;
import java.util.*;

@AllArgsConstructor
@RestController
@CrossOrigin
public class DepartementController {

    IDepartementService departementService;
    ExportPDFService exportPDFService;

    @GetMapping("/getDepartements")
    public List<Departement> getDepartements(){
        return departementService.getDepartements();
    }

    @GetMapping("/getDepartmentById/{idDep}")
    public Departement getDepartementByID(@PathVariable("idDep") Long idDep){
        return departementService.getDepartementByID(idDep);
    }

    @PostMapping("/addDepart")
    public Departement saveDepartement(@RequestBody Departement departement){
        return departementService.saveDepartement(departement);
    }

    @PostMapping("/addDeparts")
    public List<Departement> saveDepartements (@RequestBody List<Departement> departements){
        return departementService.saveDepartements(departements);
    }

    @PutMapping("/updateDepart/{idDepart}")
    public Departement updateDepartement (@PathVariable("idDepart") Long idDepart, @RequestBody Departement departement){
        return departementService.upadateDepartement(idDepart, departement);
    }

    @DeleteMapping("/deleteDepart/{idDepart}")
    public String deleteDepartement (@PathVariable Long idDepart){
        return departementService.deleteDepartement(idDepart);
    }

    @GetMapping("/retrieveDepartByUniv/{idUniversite}")
    public Set<Departement> GetDepByIdUni(@PathVariable("idUniversite") Long idUniversite){

        return  departementService.retrieveDepartementsByUniversite(idUniversite);
    }

    @PostMapping("/addDepartToUniv/{idUniversite}")
    @ResponseBody
    public void addEtudtoEqpandContrat(@RequestBody Departement D,
                                        @PathVariable("idUniversite") Long idU){
        departementService.addDepartementToUniversity(D,idU);
    }



    @GetMapping("/getDepartBynomprenom/{nom}/{prenom}")
    public List<Departement> getDepartBynomprenom(@PathVariable("nom") String nom, @PathVariable("prenom") String prenom){

        return  departementService.getDepartByNomPrenom(nom, prenom);
    }


    @GetMapping("/nbrDeparts")
    public String NbrDeparts(){
        return departementService.nbrDepart();
    }

    @GetMapping("/nbrEtuByDeprt")
    public Long NbrEtud(){
        return departementService.nbrEtudByDepart();
    }

    @GetMapping("/nbrEtudOneDeprt/{nomDepart}")
    public long NbrEtudOneDeprt(@PathVariable("nomDepart") String nomDepart){
        return departementService.nbrEtudByOneDepart(nomDepart);
    }

    @GetMapping("/nbrEtudiantOption/{nomDepart}")
    public Map<Option, Long> afficherOptionForDepartement(@PathVariable("nomDepart") String nomDepart){
        return departementService.afficherOptionForDepartement(nomDepart);
    }

    @GetMapping("exportPDF")
    @ResponseBody
    public ResponseEntity<InputStreamResource> exportTermsPdf() {
        List<Departement> departements = departementService.getDepartements();
        ByteArrayInputStream bais = exportPDFService.departementsPDFReport(departements);
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-Disposition","inline;filename=departements.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bais));
    }

    @GetMapping("triDepart")
    public List<Departement> triDepartement(){
        return departementService.triDepartement();
    }

    @GetMapping("/findbyNiveau/{niveau}")
    public List<Departement>findbyNiveau(@PathVariable("niveau") Niveau niveau){
        return departementService.findAllByEtudiantsEquipesIdeNiveau(niveau);
    }

    @GetMapping("/getDepartByNom/{nomDepart}")
    public List<Departement>getDepartByNom(@PathVariable("nomDepart") String nomDepart){
        return departementService.getDepartByNom(nomDepart);
    }


}
