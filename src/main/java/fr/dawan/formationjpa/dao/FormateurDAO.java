package fr.dawan.formationjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fr.dawan.formationjpa.entities.Formateur;

public class FormateurDAO {
	
	/**
	 * Permet de trouver les formateurs possédant ce nom
	 * En sql natif (par exemple MySql)
	 * @param name Le nom du formateur
	 * @return une liste de formateurs
	 */
	@SuppressWarnings("unchecked")
	public static List<Formateur> findByNameNativeSQL(String name) {		
		List<Formateur> resultat = null;
		EntityManager em = GenericDAO.createEntityManager();
		
		// SELECT * FROM trainer WHERE t_lastname like '%ei%' 
		resultat = em.createNativeQuery(
				"SELECT * FROM trainer WHERE t_lastname like '%" + name + "%'", Formateur.class)
				.getResultList();
		
		em.close();
		
		return resultat;
	}
	
	public static List<Formateur> findByNameHQLConcat(String name) {
		List<Formateur> resultat = null;
		EntityManager em = GenericDAO.createEntityManager();
		
		// SELECT * FROM trainer WHERE t_lastname like '%ei%' 
		resultat = em.createQuery(
				"SELECT f "
				+ " FROM Formateur f "
				+ " WHERE f.nom like '%" + name + "%'", 
					Formateur.class)
				.getResultList();

		em.close();
		
		return resultat;
	}
	
	public static List<Formateur> findByNameHQLParameter1(String name) {
		List<Formateur> resultat = null;
		EntityManager em = GenericDAO.createEntityManager();
		
		// SELECT * FROM trainer WHERE t_lastname like '%ei%' 
		resultat = em.createQuery(
				"SELECT f "
				+ " FROM Formateur f "
				+ " WHERE f.nom like ?1 "
				+ " ORDER BY f.nom, f.prenom ", // si plusieurs params : ?1 ?2...
				// + " AND f.prenom like ?2"
					Formateur.class)
				.setParameter(1, "%" + name + "%") // 1 vient remplacer ?1
				.getResultList();

		em.close();
		
		return resultat;
	}
	
	public static List<Formateur> findByNameHQLNamedParameter(String name) {
		List<Formateur> resultat = null;
		EntityManager em = GenericDAO.createEntityManager();
		
		// SELECT * FROM trainer WHERE t_lastname like '%ei%' 
		resultat = em.createQuery(
				"SELECT f "
				+ " FROM Formateur f "
				+ " WHERE f.nom like :leNom "
				+ " ORDER BY f.nom, f.prenom ",
					Formateur.class)
				.setParameter("leNom", "%" + name + "%") 
				.getResultList();

		em.close();
		
		return resultat;
	}
	
	
	public static List<Formateur> findByNameWithCriteria(String name) {
		List<Formateur> resultat = null;
		EntityManager em = GenericDAO.createEntityManager();
		
		// Builder de requête
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		// Initialisation de la requête
		CriteriaQuery<Formateur> query = criteriaBuilder.createQuery(Formateur.class);
		
		// création du "FROM"
		Root<Formateur> entity = query.from(Formateur.class);
		
		// création du "WHERE", dans lequel on insère le "Like"
		query = query.where(criteriaBuilder.like(entity.get("nom"), "%" + name + "%"));
		
		// on récupère le résultat
		resultat = em.createQuery(query).getResultList();

		em.close();
		return resultat;
	}

}
