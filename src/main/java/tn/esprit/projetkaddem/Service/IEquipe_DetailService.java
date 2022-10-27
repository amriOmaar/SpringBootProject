package tn.esprit.projetkaddem.Service;

import tn.esprit.projetkaddem.Entities.Equipe_Detail;

import java.util.List;

public interface IEquipe_DetailService {


    public List<Equipe_Detail> getDetailEquipes();

    public Equipe_Detail saveDetailEquipe(Equipe_Detail Equipe_Detail);
    public List<Equipe_Detail> saveDetailEquipes(List<Equipe_Detail> Equipe_Detail);

    public String deleteDetailEquipe(Long idDetailEquipe);
    public Equipe_Detail upadateDetailEquipe(Equipe_Detail detailEquipe);

    public List<Equipe_Detail> findByThematiqueLike (String thematique);


}
