package ca.ubc.cpsc210.fobsystem.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;



import ca.ubc.cpsc210.fobsystem.Fob;
import ca.ubc.cpsc210.fobsystem.FobControlUnit;
import ca.ubc.cpsc210.fobsystem.IllegalValuesException;
import ca.ubc.cpsc210.fobsystem.User;

/**
 * Unit tests for FobControlUnit 
 */
public class FobControlUnitTest {
	
	private FobControlUnit aFobControlUnit;
	
	@Before
	public void runBefore() throws IllegalValuesException {
		aFobControlUnit = new FobControlUnit();
		aFobControlUnit.initializeFobs(createFobs(), createUsers());		
	}
	
	@Test
	public void testFobAccess() {
		Fob f1 = new Fob(25522);
		f1.setDisplaySequence("604-555-5555");
		Fob f2 = new Fob(1);
		f2.setDisplaySequence("604-555-1111");
		assertTrue(aFobControlUnit.hasAccess(f1));
		assertFalse(aFobControlUnit.hasAccess(f2));
	}
	
	@Test
	public void testGenerateReport() {
		Fob f1 = new Fob(25522);
		f1.setDisplaySequence("604-555-5555");
		Fob f2 = new Fob(999);
		f1.setDisplaySequence("604-555-3333");
		aFobControlUnit.hasAccess(f1);
		aFobControlUnit.hasAccess(f2);
		String report = aFobControlUnit.produceReport();
		System.out.println(report);
	}
	
	private List<Fob> createFobs() {
		Fob f1 = new Fob(10056);
		f1.setDisplaySequence("778-555-5555");
		Fob f2 = new Fob(25522);
		f2.setDisplaySequence("778-555-2222");
		Fob f3 = new Fob(999);
		f3.setDisplaySequence("778-555-3333");
		Fob f4 = new Fob(888892);
		f4.setDisplaySequence("778-555-9999");
		
		List<Fob> fobs = new ArrayList<Fob>();
		fobs.add(f1);
		fobs.add(f2);
		fobs.add(f3);
		fobs.add(f4);
		
		return fobs;
	}
	
	private List<User> createUsers() {
		User u1 = new User("Duck", "Huey");
		User u2 = new User("Duck", "Louie");
		User u3 = new User("Duck", "Dewey");
		User u4 = new User("Duck", "Donald");
		
		List<User> users = new ArrayList<User>();
		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(u4);
		
		return users;
	}
}
