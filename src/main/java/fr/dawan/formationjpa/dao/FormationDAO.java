package fr.dawan.formationjpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.dawan.formationjpa.entities.Formateur;
import fr.dawan.formationjpa.entities.Formation;
import fr.dawan.formationjpa.entities.SessionFormation;

public class FormationDAO {
	
	public static void createFormation(Formation formation) {
		EntityManager em = GenericDAO.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			// début de la transaction
			tx.begin();
			
			// Insertion de la formation
			em.persist(formation);
			System.out.println("Insertion de " + formation.toString());
			
			// pour chaque session de la formation
			for (SessionFormation session : formation.getSessions()) {
				// insertion de la session de formation
				em.persist(session);
				System.out.println("Insertion de " + session.toString());
				
				if(session.getFormateur() != null) {
					em.persist(session.getFormateur());
				}
			}
			
			// On peut faire cela si on n'a pas ajouté le cascade = PERSIST dans Formateur
			for (Formateur formateur : formation.getFormateursCompetents()) {
				// si le formateur n'existe pas en BDD
				if (formateur.getId() == 0) {
					em.persist(formateur);
				}
				// s'il existe, on le met à jour (éventuellement)
				else {
					em.merge(formateur);
				}
			}
			
			// validation de la transaction
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

}
