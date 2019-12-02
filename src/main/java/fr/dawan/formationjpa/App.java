package fr.dawan.formationjpa;

import fr.dawan.formationjpa.dao.GenericDAO;
import fr.dawan.formationjpa.entities.Formation;

public class App {
	public static void main(String[] args) {

		Formation formation = new Formation();
		formation.setCode("FOR-DEV001");
		formation.setDuree(5);
		formation.setNom("Java - JPA / Hibernate");
		formation.setPrix(1999.9845678);

		GenericDAO.create(formation);
		System.out.println(formation);
	}
}
