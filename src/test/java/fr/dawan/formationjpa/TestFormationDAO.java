package fr.dawan.formationjpa;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import fr.dawan.formationjpa.dao.GenericDAO;
import fr.dawan.formationjpa.entities.Formation;

public class TestFormationDAO {

	@Test
	public void findByIdTest() {
		Formation f= GenericDAO.findById(Formation.class, 3);  // look for db id 3
		assertNotNull(f);
	}

}
