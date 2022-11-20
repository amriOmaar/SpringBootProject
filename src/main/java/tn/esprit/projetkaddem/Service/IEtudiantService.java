package tn.esprit.projetkaddem.Service;

import tn.esprit.projetkaddem.Entities.Contrat;
import tn.esprit.projetkaddem.Entities.Equipe;
import tn.esprit.projetkaddem.Entities.Etudiant;

import java.util.List;

public interface IEtudiantService {

    public List<Etudiant> getEtudiants();
    public Etudiant getEtudiantById(long id);
    public Etudiant findEtudiantByPnemom(String prenom);
    public Etudiant findEtudiantByNom(String nom);



    public Etudiant saveEtudiant(Etudiant etudiant);
    public List<Etudiant> saveEtudiants(List<Etudiant> etudiants);

    public String deleteEtudiant(Long idEtudiant);
    public Etudiant upadateEtudiant(Etudiant etudiant);



    public void assignEtudiantToDepartement (Long idEtudiant, Long idDepart);

    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant etudiant, Long idContrat, Long idEquipe);








}
