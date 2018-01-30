package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }

	 @Test
	  public void test02()  throws Throwable {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 appt.setStartHour(startHour);
		 appt.setStartMinute(startMinute);
		 appt.setStartDay(startDay);
		 appt.setStartMonth(startMonth);
		 appt.setStartYear(startYear);
		 appt.setTitle(title);
		 appt.setDescription(description);
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());
	 }
	  //add more unit tests as you needed
	  @Test
	  public void test03()  throws Throwable {
		  int startHour = 21;
		  int startMinute = 30;
		  int startDay = 15;
		  int startMonth = 01;
		  int startYear = 2018;
		  String title = "Birthday Party";
		  String description = "This is my birthday party.";
		  Appt appt = new Appt(startHour,
				  startMinute,
				  startDay,
				  startMonth,
				  startYear,
				  title,
				  description);
		  int recurBy = 3;
		  int recurIncrement = 3;
		  int[] recurDays = new int[0];
		  int recurNumber = 3;
		  appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
		  appt.getRecurNumber();
		  appt.getRecurBy();
		  appt.getRecurDays();
		  appt.getRecurIncrement();
		  assertEquals(3, appt.getRecurNumber());
		  assertEquals(3, appt.getRecurBy());
		  assertEquals(3, appt.getRecurIncrement());
	  }
	@Test
	public void test04()  throws Throwable {
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		appt.toString();
		assertEquals("\t" + "1/15/2018" + " at 9:30pm" + " ," + "Birthday Party" + ", " + "This is my birthday party." + "\n", appt.toString());
	}
	@Test
	public void test05() throws Throwable {
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		appt.compareTo(appt);
		assertEquals(0,appt.compareTo(appt));
	}
	@Test
	public void test06()  throws Throwable  {
	 	Appt appt = new Appt(25,61,33,12,0,null,null);
	 	assertFalse(appt.getValid());
		appt.setStartHour(10);
		assertFalse(appt.getValid());
		appt.setStartMinute(10);
		assertFalse(appt.getValid());
		appt.setStartDay(01);
		assertTrue(appt.getValid());
		appt.setStartMonth(13);
		assertFalse(appt.getValid());

		Appt appt1 = new Appt(0,10,10,12,2018,null,null);
		int[] a = null;
		appt1.setRecurrence(a, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		String b = appt1.toString();

		Appt appt2 = new Appt();
		assertEquals(null, appt2.toString());
	}
}
