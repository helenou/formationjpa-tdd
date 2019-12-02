package fr.dawan.formationjpa;

import fr.dawan.formationjpa.dao.GenericDAO;
import fr.dawan.formationjpa.entities.Formation;

public class App3 {

	public static void main(String[] args) {
		Formation formation = new Formation();
		formation.setCode("FOR-DEV001");
		formation.setDuree(5);
		formation.setNom("Java - JPA / Hibernate");
		formation.setPrix(1999.99);

		// Création
//		GenericDAO.create(formation);
		System.out.println(formation);
		
		// Suppression
		GenericDAO.delete(Formation.class, formation.getId());
		
		// On tente de récupérer la formation supprimée
		Formation formation2 = GenericDAO.findById(Formation.class, formation.getId());
		System.out.println(formation2 == null);
		
	}

}
