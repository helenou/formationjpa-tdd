package fr.dawan.formationjpa;

import java.time.LocalDate;
import java.time.Month;

import fr.dawan.formationjpa.dao.GenericDAO;
import fr.dawan.formationjpa.entities.Formation;
import fr.dawan.formationjpa.entities.SessionFormation;

public class App5 {

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
		// DEUXIEME TENTATIVE : 
		// après modification des règles de cascade
		// dans Formation et SessionFormation
		// **********************************************************
		
		// On va sauvegarder la formation, et laisser les cascades créer les sessions
		formationJPA.addSession(sessionNovembre);
		formationJPA.addSession(sessionDecembre);
		GenericDAO.create(formationJPA); 
		
		
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
