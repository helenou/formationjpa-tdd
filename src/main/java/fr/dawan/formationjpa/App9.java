package fr.dawan.formationjpa;

import java.util.List;

import fr.dawan.formationjpa.dao.GenericDAO;
import fr.dawan.formationjpa.entities.Formateur;

public class App9 {

	public static void main(String[] args) {
		List<Formateur> formateurs = GenericDAO.findAll(Formateur.class);
		
		System.out.println("TOUS LES FORMATEURS");
		for (Formateur formateur : formateurs) {
			System.out.println("\t" + formateur);
		}
		

		System.out.println("\nLES FORMATEURS du 3ème au 5ème");
		
		formateurs = GenericDAO.findAll(Formateur.class, 2, 3);
		for (Formateur formateur : formateurs) {
			System.out.println("\t" + formateur);
		}

		System.out.println("\nLES FORMATEURS du 6ème au 105è");
		List<Formateur> formateurs2 = GenericDAO.findAll(Formateur.class, 5, 100);
		System.out.println(formateurs2);
		
		System.out.println("\nLES FORMATEURS du 106ème au 1106è");
		List<Formateur> formateurs3 = GenericDAO.findAll(Formateur.class, 107, 1000);
		System.out.println(formateurs3);
	}

}
