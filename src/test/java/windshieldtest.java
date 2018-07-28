import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class windshieldtest {
	public static windshieldWiper tcase;


	@Test
	public void windshield_test1()
	{
	try{
		tcase = new windshieldWiper(0, "OFF", 1);
		tcase.senseLeverUp();
		assertEquals("INT",tcase.getLeverPosition());
		assertEquals(4, tcase.getWiperSpeed());
	}
	catch (LeverErrorException e) {
		fail("Error resolving lever position");
		}
	}
	
	@Test
	public void windshield_test2()
	{
	try{
		tcase = new windshieldWiper(4, "INT", 1);
		tcase.senseDialUp();
		assertEquals("INT", tcase.getLeverPosition());
		assertEquals(2,tcase.getDialPosition());
		assertEquals(6, tcase.getWiperSpeed());
	}
	catch (DialErrorException e) {
		fail("Error resolving dial position");
		}
	}
	
	@Test
	public void windshield_test3()
	{
	try{
		tcase = new windshieldWiper(6, "INT", 2);
		tcase.senseDialUp();
		assertEquals(3,tcase.getDialPosition());
		assertEquals(12, tcase.getWiperSpeed());
	}
	catch (DialErrorException e) {
		fail("Error resolving dial position");
		}
	}
	
	@Test
	public void windshield_test4()
	{
	try{
		tcase = new windshieldWiper(12, "INT", 3);
		tcase.senseLeverUp();
		assertEquals("LOW",tcase.getLeverPosition());
		assertEquals(30, tcase.getWiperSpeed());
	}
	catch (LeverErrorException e) {
		fail("Error resolving lever position");
		}
	}

@Test
	public void windshield_test5()
	{
	try{
		tcase = new windshieldWiper(30, "LOW", 3);
		tcase.senseLeverUp();
		assertEquals("HIGH",tcase.getLeverPosition());
		assertEquals(60, tcase.getWiperSpeed());
	}
	catch (LeverErrorException e) {
		fail("Error resolving lever position");
		}
	}
	
	@Test
	public void windshield_test6()
	{
	try{
		tcase = new windshieldWiper(60, "HIGH", 3);
		tcase.senseLeverDown();
		assertEquals("LOW",tcase.getLeverPosition());
		assertEquals(30, tcase.getWiperSpeed());
	}
	catch (LeverErrorException e) {
		fail("Error resolving lever position ");
		}
	}
	
	@Test
	public void windshield_test7()
	{
	try{
		tcase = new windshieldWiper(30, "LOW", 3);
		tcase.senseLeverDown();
		assertEquals("INT",tcase.getLeverPosition());
		assertEquals(12, tcase.getWiperSpeed());
		assertEquals(3,tcase.getDialPosition());
	}
	catch (LeverErrorException e) {
		fail("Error resolving lever position");
		}
	}
	
	@Test
	public void windshield_test8()
	{
	try{
		tcase = new windshieldWiper(12, "INT", 3);
		tcase.senseDialDown();
		assertEquals(2,tcase.getDialPosition());
		assertEquals(6, tcase.getWiperSpeed());
	}
	catch (DialErrorException e) {
		fail("Error resolving dial position");
		}
	}
	
	@Test
	public void windshield_test9()
	{
	try{
		tcase = new windshieldWiper(6, "INT", 2);
		tcase.senseDialDown();
		assertEquals(1,tcase.getDialPosition());
		assertEquals(4, tcase.getWiperSpeed());
	}
	catch (DialErrorException e) {
		fail("Error resolving dial position");
		}
	}
	
	@Test
	public void windshield_test10()
	{
	try{
		tcase = new windshieldWiper(4, "INT", 1);
		tcase.senseLeverDown();
		assertEquals("OFF",tcase.getLeverPosition());
		assertEquals(0, tcase.getWiperSpeed());
	}
	catch (LeverErrorException e) {
		fail("Error resolving lever position");
		}
	}
	
	
	@AfterClass
	public static void free_memory()
	{
		tcase = null;
	}
	

}
