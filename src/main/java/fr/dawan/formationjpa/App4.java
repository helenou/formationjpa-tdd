package fr.dawan.formationjpa;

import java.time.LocalDate;
import java.time.Month;

import fr.dawan.formationjpa.dao.GenericDAO;
import fr.dawan.formationjpa.entities.Formation;
import fr.dawan.formationjpa.entities.SessionFormation;

public class App4 {

	public static void main(String[] args)  {

		Formation formationJPA = new Formation(); // Etat : détachée
		formationJPA.setCode("FOR-DEV002");
		formationJPA.setDuree(2);
		formationJPA.setNom("GIT");
		formationJPA.setPrix(999.99);
		
		SessionFormation sessionNovembre = new SessionFormation();  // Etat : détachée
		sessionNovembre.setDateDebut(LocalDate.of(2019, Month.NOVEMBER, 2));
		sessionNovembre.setNbPlacesMaxi(15);
		sessionNovembre.setNbPlaces(12);
		sessionNovembre.setFormation(formationJPA);
		
		SessionFormation sessionDecembre = new SessionFormation();  // Etat : détachée
		sessionDecembre.setDateDebut(LocalDate.of(2019, Month.DECEMBER, 2));
		sessionDecembre.setNbPlacesMaxi(15);
		sessionDecembre.setNbPlaces(10);
		sessionDecembre.setFormation(formationJPA);
		
		// **********************************************************
		// PREMIERE TENTATIVE
		// **********************************************************
		//GenericDAO.create(formationJPA);
		// avec cascade.PERSIST, pas besoin d'insérer la formation 
		// avant d'insérer la session (la session s'en chargera)
		// on tente d'insérer la session de novembre, 
		// avec le cascade persist formationJPA est aussi insérée
		GenericDAO.create(sessionNovembre); 
		
		// on tente d'insérer la session de décembre, 
		// avec le cascade persist formationJPA est aussi insérée
		// sauf qu'il existe déjà, donc qu'il a un id, et qu'il est détaché
		// donc : EXCEPTION, donc, pas d'insertion
		GenericDAO.create(sessionDecembre);
		
		// Le nombre session à partir de l'objet formation en mémoire
		System.out.println("nombre de sessions dans la formation JPA : " 
				+ formationJPA.getSessions().size());
		
		System.out.println("id de la formation : " + formationJPA.getId());
		
		// récupération de la formation correspondante en base de données
		Formation formationEnBDD = 
				GenericDAO.findById(Formation.class,
						formationJPA.getId()); 
		// détaché, mais qui vient de la base de données
		// on a un fetch eager sur sessions
		
		
		// Le nombre session à partir de l'objet formation provenant de la base de données
		System.out.println("nombre de sessions dans la formation JPA : " 
				+ formationEnBDD.getSessions().size());
		
		
	}

}
