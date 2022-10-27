package tn.esprit.projetkaddem.Service;

import tn.esprit.projetkaddem.Entities.Equipe;

import java.util.List;

public interface IEquipeService {

    public List<Equipe> getEquipes();

    public Equipe saveEquipe(Equipe equipe);
    public List<Equipe> saveEquipes(List<Equipe> equipes);

    public String deleteEquipe(Long idEquipe);
    public Equipe upadateEquipe(Equipe equipe);


    List<Equipe> findByEtudiantsIdEtudiant (Long idEtudiant);





}
