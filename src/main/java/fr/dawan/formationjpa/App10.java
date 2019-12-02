package fr.dawan.formationjpa;

import java.util.List;
import java.util.Scanner;

import fr.dawan.formationjpa.dao.FormateurDAO;
import fr.dawan.formationjpa.entities.Formateur;

public class App10 {

	public static void main(String[] args) {
		System.out.println("Veuillez saisir un nom, ou une partie de nom");
		Scanner sc = new Scanner(System.in);
		String saisie = sc.nextLine();
		
		List<Formateur> formateurs = FormateurDAO.findByNameNativeSQL(saisie);
		
		System.out.println("LES FORMATEURS dont le nom contient \"" + saisie + "\".");
		for (Formateur formateur : formateurs) {
			System.out.println("\t" + formateur);
		}

		List<Formateur> formateurs2 = FormateurDAO.findByNameHQLConcat(saisie);
		System.out.println("Le même, en HQL");
		for (Formateur formateur : formateurs2) {
			System.out.println("\t" + formateur);
		}
		
		List<Formateur> formateurs3 = FormateurDAO.findByNameHQLParameter1(saisie);
		System.out.println("Le même, en HQL, avec setParameter");
		for (Formateur formateur : formateurs3) {
			System.out.println("\t" + formateur);
		}
		
		List<Formateur> formateurs4 = FormateurDAO.findByNameHQLNamedParameter(saisie);
		System.out.println("Le même, en HQL, avec setParameter");
		for (Formateur formateur : formateurs4) {
			System.out.println("\t" + formateur);
		}
		
		List<Formateur> formateurs5 = FormateurDAO.findByNameWithCriteria(saisie);
		System.out.println("Le même, en HQL, avec criteria");
		for (Formateur formateur : formateurs5) {
			System.out.println("\t" + formateur);
		}
		
		sc.close();
	}
}
