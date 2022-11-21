package tn.esprit.projetkaddem.Service;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.projetkaddem.Entities.Contrat;
import tn.esprit.projetkaddem.Entities.Etudiant;
import tn.esprit.projetkaddem.Repository.ContratRepository;
import tn.esprit.projetkaddem.Repository.EtudiantRepository;

import java.util.Date;
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
        Etudiant etudiant=etudiantRepository.findByPrenom(prenom);
        if (etudiant.getContrats().size()<5) {
            ce.setEtudiant(etudiant);
            contratRepository.save(ce);
        }
        else{
            System.out.println("Cannot Affect anymore");
        }

        return ce;
    }


    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        int j=0 ;

        List< Contrat> contrat= contratRepository.findAll();

        for(int i=0;i<contrat.size();i++){
            Contrat ct=contrat.get(i);

            if(ct.getArchive()==false){
                j++;
                System.out.println("Les contrats dispo :" + j);
            }

        }
        return j;
    }


    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {

        float CA=0;
        int nbOfMonths=1;

        List< Contrat> contrat= contratRepository.findAll();
        for(int i=0;i<contrat.size();i++){
            Contrat ct=contrat.get(i);
            int dd=Integer.parseInt(ct.getDateDebutContrat().toString().substring(5,7));
            int df=Integer.parseInt(ct.getDateFinContrat().toString().substring(5,7));

            if((nbOfMonths*=(df-dd))==0){
                nbOfMonths=1;
            }else{
                nbOfMonths=(df-dd);
            }
            if(ct.getArchive()==false){

                System.out.println("*******"+nbOfMonths);

                if(ct.getSpecialite().toString()=="IA"){
                    CA+=nbOfMonths*300;

                }
                else if(ct.getSpecialite().toString()=="RESEAUX"){
                    CA+=nbOfMonths*350;
                }
                else if(ct.getSpecialite().toString()=="CLOUD"){
                    CA+=nbOfMonths*400;
                }
                else if(ct.getSpecialite().toString()=="SECURITE"){
                    CA+=nbOfMonths*450;
                }

            }

        }
        return CA;
    }


}
