package tn.esprit.projetkaddem.Service;

import tn.esprit.projetkaddem.Entities.Departement;
import tn.esprit.projetkaddem.Entities.Etudiant;

import java.util.List;

public interface IDepartementService {


    public List<Departement> getAllDepartements();

    public Departement getDepartementByID(Long idDep);

    public Departement saveDepartement(Departement departement);


    public List<Departement> saveDepartements(List<Departement> departements);

    public String deleteDepartement(Long idDepartement);


    public Departement upadateDepartement(Long idDepartement, Departement departement);

    /*public Departement findDepartementByEtudiants(String option);*/


}
