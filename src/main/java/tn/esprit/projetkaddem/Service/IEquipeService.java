package tn.esprit.projetkaddem.Service;

import tn.esprit.projetkaddem.Entities.Equipe;
import tn.esprit.projetkaddem.Repository.EquipeRepository;

import java.util.List;

public interface IEquipeService {

    public List<Equipe> getEquipes();

    public Equipe saveEquipe(Equipe equipe);
    public List<Equipe> saveEquipes(List<Equipe> equipes);

    public String deleteEquipe(Long idEquipe);
    public Equipe upadateEquipe(Equipe equipe);

   // List<Equipe> findEquipeByDetailEquipeThematiqueLike(String thematique);

    List<Equipe> findEquipeByDetailEquipeThematique(String tg);

    void faireEvoluerEquipes();



}
