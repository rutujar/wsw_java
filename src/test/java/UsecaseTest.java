import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class UsecaseTest {

	private static windshieldWiper tcase;
	
	@BeforeClass
	public static void setUpObjects()
	{
		tcase = new windshieldWiper(0, "OFF", 1);
	}
	
	@Test
	public void usecase()
	{
	try
	{
		tcase.senseLeverUp();		
		assertEquals("INT", tcase.getLeverPosition());
		assertEquals (4, tcase.getWiperSpeed());
		
	}
	catch (LeverErrorException e) {
		fail("Cannnot resolve Lever issues");
	}
	
	try
	{
		tcase.senseDialUp();
		assertEquals(2, tcase.getDialPosition());
		assertEquals (6, tcase.getWiperSpeed());
		
	}
	catch (DialErrorException e1)
	{
		fail("Cannot resolve Dial issues");
	}
	
	tcase.setLeverPosition("HIGH");
	assertEquals("HIGH", tcase.getLeverPosition());
	assertEquals (60, tcase.getWiperSpeed());
	
	
	try
	{
		tcase.senseDialUp();
		assertEquals(3, tcase.getDialPosition());
		
		
	}
	catch (DialErrorException e3) 
	{
		fail ("Cannot resolve Dial issues");
	}
	
tcase.setLeverPosition("INT");
assertEquals("INT", tcase.getLeverPosition());
assertEquals (12, tcase.getWiperSpeed());

tcase.setLeverPosition("OFF");
assertEquals("OFF", tcase.getLeverPosition());
assertEquals(0, tcase.getWiperSpeed());

	}
	
	
	
}
