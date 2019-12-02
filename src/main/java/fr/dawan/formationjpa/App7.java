package fr.dawan.formationjpa;

import java.util.UUID;

import fr.dawan.formationjpa.dao.GenericDAO;
import fr.dawan.formationjpa.entities.Formateur;
import fr.dawan.formationjpa.entities.Formation;

public class App7 {

	public static void main(String[] args) {

		// créer des formateurs (3)
		Formateur formateur1 = new Formateur();
		formateur1.setEstInterne(true);
		formateur1.setMatricule(UUID.randomUUID().toString());
		formateur1.setNom("Derkaoui");
		formateur1.setPrenom("Michel");
		
		Formateur formateur2 = new Formateur();
		formateur2.setEstInterne(true);
		formateur2.setMatricule(UUID.randomUUID().toString());
		formateur2.setNom("Lorent");
		formateur2.setPrenom("Haja");
		
		Formateur formateur3 = new Formateur();
		formateur3.setEstInterne(true);
		formateur3.setMatricule(UUID.randomUUID().toString());
		formateur3.setNom("Zein");
		formateur3.setPrenom("Bernard");
		
		// créer des formations (3)
		Formation formation = new Formation();
		formation.setCode("FOR-DEV004");
		formation.setDuree(5);
		formation.setNom("Java - JEE");
		formation.setPrix(1999.99);
		
		Formation formation2 = new Formation();
		formation2.setCode("FOR-DEV005");
		formation2.setDuree(5);
		formation2.setNom("GIT");
		formation2.setPrix(2999.99);
		
		Formation formation3 = new Formation();
		formation3.setCode("FOR-DEV006");
		formation3.setDuree(3);
		formation3.setNom("Agile");
		formation3.setPrix(799.99);
		
		// associer des formations à des formateurs
		// et/ou associer des formateurs à des formations
		formateur2.addCompetences(formation);		
		formateur2.addCompetences(formation2);
		
		// mettre à jour la base de données
		GenericDAO.create(formateur1);
		GenericDAO.create(formateur2);
		GenericDAO.create(formateur3);

	}

}
