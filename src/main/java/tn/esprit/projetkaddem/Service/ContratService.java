package tn.esprit.projetkaddem.Service;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.projetkaddem.Entities.Contrat;
import tn.esprit.projetkaddem.Repository.ContratRepository;

import java.util.List;


@AllArgsConstructor
@Service
public class ContratService implements IContratService{


    ContratRepository ContratRepository;

    @Override
    public List<Contrat> getAllcontrats() {
        return ContratRepository.findAll();
    }

    @Override
    public Contrat getContratByID(Long idContrat) {
        return ContratRepository.findById(idContrat).get();
    }

    @Override
    public Contrat saveContrat(Contrat Contrat){
        return ContratRepository.save(Contrat);
    }


    @Override
    public List<Contrat> saveAllContrats(List<Contrat> contrats){
        return ContratRepository.saveAll(contrats);
    }

    @Override
    public String deleteContrat(Long idContrat){
        ContratRepository.deleteById(idContrat);
        return "Contrat supprimé !";
    }

    @Override
    public Contrat upadateContrat(Contrat contrat){
        Contrat existingContrat = ContratRepository.findById(contrat.getIdContrat()).orElse(null);
        assert existingContrat != null;
        existingContrat.setDateDebutContrat(contrat.getDateDebutContrat());
        existingContrat.setDateFinContrat(contrat.getDateFinContrat());
        existingContrat.setArchive(contrat.getArchive());
        existingContrat.setSpecialite(contrat.getSpecialite());

        return ContratRepository.save(existingContrat);
    }


}
