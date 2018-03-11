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
	public void test01() throws Throwable {
		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
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
	public void test02() throws Throwable {
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
	public void test03() throws Throwable {
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
		//appt.getRecurNumber();
		//appt.getRecurBy();
		//appt.getRecurDays();
		//appt.getRecurIncrement();
		assertEquals(3, appt.getRecurNumber());
		assertEquals(3, appt.getRecurBy());
		assertEquals(3, appt.getRecurIncrement());
		assertTrue(appt.isRecurring());
		startDay = 32;
		appt.setStartDay(startDay);
		assertFalse(appt.getValid());
		startHour = 25;
		appt.setStartHour(startHour);
		assertFalse(appt.getValid());
		startMinute = 61;
		appt.setStartMinute(startMinute);
		assertFalse(appt.getValid());
		startYear = -1;
		appt.setStartYear(startYear);
		assertFalse(appt.getValid());

	}

	@Test
	public void test04() throws Throwable {
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
		appt.toString();
		assertEquals("\t" + "1/15/2018" + " at 9:30pm" + " ," + "Birthday Party" + ", " + "This is my birthday party." + "\n", appt.toString());
	}

	@Test
	public void test05() throws Throwable {
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
		appt.compareTo(appt);
		assertEquals(0, appt.compareTo(appt));
	}

	@Test
	public void test06() throws Throwable {
		Appt appt1 = new Appt(0, 10, 10, 12, 2018, null, null);
		int[] a = null;
		appt1.setRecurrence(a, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		String b = appt1.toString();

		Appt appt2 = new Appt();
		assertEquals(null, appt2.toString());
	}

	@Test
	public void test07() throws Throwable {
		Appt appt = new Appt(9, 35, -3, -11, 2018, "www", "www");
		assertFalse(appt.getValid());
		appt.setStartDay(3);
		appt.setStartMonth(11);
		assertTrue(appt.getValid());
		int[] a=null;
		Appt appt1 = new Appt(1, 2, 3,4,2018,"sss","sss");
		appt.setRecurrence(a,Appt.RECUR_BY_WEEKLY,1,Appt.RECUR_NUMBER_FOREVER);
		assertTrue(appt.getValid());
	}

	@Test
	public void test08() throws Throwable {
		Appt appt = new Appt(-1, 30, 8, 12, 2018,"title", "description");
		assertFalse(appt.getValid());

		Appt appt1 = new Appt(10, 30, 8, -1, 2018,"title", "description");
		assertFalse(appt1.getValid());

		Appt appt2 = new Appt(10, 30, -1, 12, 2018,"title", "description");
		assertFalse(appt2.getValid());
		appt2.setStartDay(2);
		assertTrue(appt2.getValid());

		Appt appt3 = new Appt(-1, 30, 8, 12, 2018,"title", "description");
		assertFalse(appt3.getValid());
		appt3.setStartHour(24);
		assertFalse(appt3.getValid());
		appt3.setStartHour(5);
		assertTrue(appt3.getValid());

		Appt appt4 = new Appt(10, -1, 8, 12, 2018,"title", "description");
		assertFalse(appt4.getValid());
		appt4.setStartMinute(20);
		assertTrue(appt4.getValid());
		appt4.setStartYear(2000);
		assertTrue(appt4.getValid());

		Appt appt5 = new Appt(10, 20, 8, 12, 2018,"title", "description");
		int[] a = {0,1,2};
		int b = 3;
		appt5.setRecurrence(a,b,b,b);
		Appt appt6 = new Appt(10, 20, 8, 12, 2018,"title", "description");
		appt6.setRecurrence(null,b,b,b);

		assertEquals(a, appt5.getRecurDays());
		assertEquals(b, appt5.getRecurIncrement());
		assertEquals(b, appt5.getRecurNumber());

		appt5.setStartHour(23);
		String c = "\t12/8/2018 at 11:20pm ,title, description\n";
		assertEquals(c,appt5.toString());

		int d = 31;
		assertEquals(d, appt5.compareTo(appt4));

		appt5.setStartHour(11);
		c = "\t12/8/2018 at 11:20am ,title, description\n";
		assertEquals(c,appt5.toString());
		d = 19;
		assertEquals(d, appt5.compareTo(appt4));
		d = -19;
		assertEquals(d, appt4.compareTo(appt5));
	}
}