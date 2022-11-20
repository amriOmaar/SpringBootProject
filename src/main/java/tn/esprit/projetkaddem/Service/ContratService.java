package tn.esprit.projetkaddem.Service;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.projetkaddem.Entities.Contrat;
import tn.esprit.projetkaddem.Entities.Etudiant;
import tn.esprit.projetkaddem.Repository.ContratRepository;
import tn.esprit.projetkaddem.Repository.EtudiantRepository;

import java.util.List;
import java.util.Set;


@AllArgsConstructor
@Service
public class ContratService implements IContratService{


    ContratRepository contratRepository;
    EtudiantRepository etudiantRepository;

    @Override
    public List<Contrat> getAllcontrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat getContratByID(Long idContrat) {
        return contratRepository.findById(idContrat).get();
    }

    @Override
    public Contrat saveContrat(Contrat Contrat){
        return contratRepository.save(Contrat);
    }


    @Override
    public List<Contrat> saveAllContrats(List<Contrat> contrats){
        return contratRepository.saveAll(contrats);
    }

    @Override
    public String deleteContrat(Long idContrat){
        contratRepository.deleteById(idContrat);
        return "Contrat supprimé !";
    }

    @Override
    public Contrat upadateContrat(Contrat contrat){
        Contrat existingContrat = contratRepository.findById(contrat.getIdContrat()).orElse(null);
        assert existingContrat != null;
        existingContrat.setDateDebutContrat(contrat.getDateDebutContrat());
        existingContrat.setDateFinContrat(contrat.getDateFinContrat());
        existingContrat.setArchive(contrat.getArchive());
        existingContrat.setSpecialite(contrat.getSpecialite());

        return contratRepository.save(existingContrat);
    }


    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nom, String prenom) {


        Etudiant etudiant = etudiantRepository.findByNom(nom);
        Etudiant etudiantp = etudiantRepository.findByPrenom(prenom);

        etudiant.setContrats((Set<Contrat>) ce);
        etudiantp.setContrats((Set<Contrat>) ce);


        etudiantRepository.save(etudiant);
        etudiantRepository.save(etudiantp);

        return ce;
    }

}
