package tn.esprit.projetkaddem.Service;

import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projetkaddem.Entities.Contrat;
import tn.esprit.projetkaddem.Entities.Equipe;
import tn.esprit.projetkaddem.Entities.Niveau;
import tn.esprit.projetkaddem.Repository.ContratRepository;
import tn.esprit.projetkaddem.Repository.EquipeRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class EquipeService implements IEquipeService {


    EquipeRepository equipeRepository;
    ContratRepository contratRepository;


    @Override
    public List<Equipe> getEquipes(){
        return equipeRepository.findAll();
    }

    @Override
    public Equipe saveEquipe(Equipe equipe){
        return equipeRepository.save(equipe);
    }

    @Override
    public List<Equipe> saveEquipes(List<Equipe> equipes){
        return equipeRepository.saveAll(equipes);
    }


    @Override
    public String deleteEquipe(Long idEquipe){
        equipeRepository.deleteById(idEquipe);
        return "Equipe supprimé !" +idEquipe;
    }

    @Override
    public Equipe upadateEquipe(Equipe equipe){

        return equipeRepository.save(equipe);

    }

    @Override
    public List<Equipe> findEquipeByDetailEquipeThematique(String tg) {
        return equipeRepository.findEquipeByDetailEquipeThematique(tg);
    }


    @Override
    public void faireEvoluerEquipes() {

        int dureEnMois=0;

        List<Equipe> equipes = equipeRepository.findAll();
        List<Contrat> contrats = contratRepository.findAll();

        for (int i=0; i<=equipes.size(); i++){
            for (int j=0; j<=contrats.size(); j++){
                Contrat c=contrats.get(j);
                int dd=Integer.parseInt(c.getDateDebutContrat().toString());
                int df=Integer.parseInt(c.getDateFinContrat().toString());
                dureEnMois = df - dd;
            }
            Equipe equi=equipes.get(i);
            if (dureEnMois==12 | equi.getNiveau().toString()=="JUNIOR"){
                equi.setNiveau(Niveau.SENIOR);
            }else if (dureEnMois==12 | equi.getNiveau().toString()=="SENIOR"){
                equi.setNiveau(Niveau.EXPERT);
            }else{
                System.out.println("Conditions non respectés");
            }
        }
    }
}
