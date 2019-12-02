package fr.dawan.formationjpa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	DemoTestSuite.class, 
	TestFormationDAO.class
})
public class AllTests {

}
