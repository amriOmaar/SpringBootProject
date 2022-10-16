package tn.esprit.projetkaddem.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projetkaddem.Entities.Etudiant;
import tn.esprit.projetkaddem.Repository.EtudiantRepository;
import java.util.List;


@Service
public class EtudiantService {

    @Autowired
    EtudiantRepository EtudiantRepository;

    public List<Etudiant> getEtudiants(){
        return EtudiantRepository.findAll();
    }
    public Etudiant getEtudiantById(long id)
    {
        return EtudiantRepository.findById(id).get();
    }


    public Etudiant getEtudiantByPnemom(String prenom){return EtudiantRepository.findByPrenom(prenom);}
    public Etudiant getEtudiantByNom(String nom){return EtudiantRepository.findByNom(nom);}


    public Etudiant saveEtudiant(Etudiant etudiant){
        return EtudiantRepository.save(etudiant);
    }
    public List<Etudiant> saveEtudiants(List<Etudiant> etudiants){
        return EtudiantRepository.saveAll(etudiants);
    }

    public String deleteEtudiant(Long idEtudiant){
        EtudiantRepository.deleteById(idEtudiant);
        return "Etudiant supprimé !" +idEtudiant;
    }
    public Etudiant upadateEtudiant(Etudiant etudiant){
        Etudiant existingEtudiant = EtudiantRepository.findById(etudiant.getIdEtudiant()).orElse(null);
        existingEtudiant.setPrenom(etudiant.getPrenom());
        existingEtudiant.setNom(etudiant.getNom());
        existingEtudiant.setOption(etudiant.getOption());
        return EtudiantRepository.save(existingEtudiant);
    }




}
