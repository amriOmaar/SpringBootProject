package tn.esprit.projetkaddem.Service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.projetkaddem.Entities.Equipe;
import tn.esprit.projetkaddem.Entities.Etudiant;
import tn.esprit.projetkaddem.Repository.EtudiantRepository;
import java.util.List;


@AllArgsConstructor
@Service
public class EtudiantService implements IEtudiantService {


    EtudiantRepository EtudiantRepository;

    @Override
    public List<Etudiant> getEtudiants(){
        return EtudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiantById(long id)
    {
        return EtudiantRepository.findById(id).get();
    }

    @Override
    public Etudiant findEtudiantByPnemom(String prenom){return EtudiantRepository.findByPrenom(prenom);}

    @Override
    public Etudiant findEtudiantByNom(String nom){return EtudiantRepository.findByNom(nom);}


    @Override
    public Etudiant saveEtudiant(Etudiant etudiant){
        return EtudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> saveEtudiants(List<Etudiant> etudiants){
        return EtudiantRepository.saveAll(etudiants);
    }



    @Override
    public String deleteEtudiant(Long idEtudiant){
        EtudiantRepository.deleteById(idEtudiant);
        return "Etudiant supprimé !" +idEtudiant;
    }


    @Override
    public Etudiant upadateEtudiant(Etudiant etudiant){
        Etudiant existingEtudiant = EtudiantRepository.findById(etudiant.getIdEtudiant()).orElse(null);
        existingEtudiant.setPrenom(etudiant.getPrenom());
        existingEtudiant.setNom(etudiant.getNom());
        existingEtudiant.setOption(etudiant.getOption());
        return EtudiantRepository.save(existingEtudiant);
    }





    }




