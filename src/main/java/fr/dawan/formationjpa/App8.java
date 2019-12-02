package fr.dawan.formationjpa;

import fr.dawan.formationjpa.dao.GenericDAO;
import fr.dawan.formationjpa.entities.Formateur;
import fr.dawan.formationjpa.entities.Formation;

public class App8 {

	public static void main(String[] args) {
		// on récupère le formateur ayant l'id 2
		Formateur formateur = GenericDAO.findById(Formateur.class, 2);
		
		System.out.println("Nb de compétences pour " + formateur.getPrenom() + " : " 
		+ formateur.getCompetences().size());
		
		// Pour chaque formation comprise dans la liste de compétence du formateur
		for (Formation formation : formateur.getCompetences()) {
			System.out.println(formation);
		}
	}

}
