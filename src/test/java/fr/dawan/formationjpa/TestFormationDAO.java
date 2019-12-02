package fr.dawan.formationjpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.dawan.formationjpa.dao.GenericDAO;
import fr.dawan.formationjpa.entities.Formation;

public class TestFormationDAO {

	private long fid= 0;
	
	private final String CODE_FORMATION = "XXYO-TDD";
	private final int DUREE_FORMATION = 3;
	private final String NOM_FORMATION = "TDD en Java";
	private final Double PRIX_FORMATION = 1234.99;
	
	@Before
	public void init() {
		System.out.println("Initialisation avant chaque test");
		
		Formation f = new Formation();
		f.setCode(CODE_FORMATION);
		f.setDuree(DUREE_FORMATION);
		f.setNom(NOM_FORMATION);
		f.setPrix(PRIX_FORMATION);
		
		// Insert to DB
		GenericDAO.create(f);
	
		assertNotEquals(0, f.getId()); // id!=0 si en DB

		fid= f.getId();
	}
	
	@After
	public void cleanUp() {
		System.out.println("Nettoyage après chaque test");
		GenericDAO.delete(Formation.class, fid);
	}
	
	
	@Test
	public void findByIdTest() {
		Formation f= GenericDAO.findById(Formation.class, fid);  
		assertNotNull(f);
		
		assertEquals(CODE_FORMATION, f.getCode());
		assertEquals(DUREE_FORMATION, f.getDuree());
		assertEquals(NOM_FORMATION, f.getNom());
		assertEquals(PRIX_FORMATION, f.getPrix(), 0.01);
		
	}

}
