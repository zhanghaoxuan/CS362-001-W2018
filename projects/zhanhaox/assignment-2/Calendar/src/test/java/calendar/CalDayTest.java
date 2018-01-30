package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable {
	 	 CalDay calday1 = new CalDay();
		 GregorianCalendar cal = new GregorianCalendar(2018,6,28);
		 CalDay calday = new CalDay(cal);
		 calday.isValid();
		 calday.getSizeAppts();
		 calday.getDay();
		 calday.getMonth();
		 calday.getYear();
		 calday.toString();
		 assertTrue(calday.isValid());
		 assertEquals(0, calday.getSizeAppts());
		 assertEquals(28,calday.getDay());
		 assertEquals(6,calday.getMonth());
		 assertEquals(2018,calday.getYear());
		 assertEquals("\t --- " + "6/28/2018" + " --- \n" +
				 " --- -------- Appointments ------------ --- \n" + "\n",calday.toString());
	 }
	 @Test
	  public void test02()  throws Throwable {
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

		 GregorianCalendar cal = new GregorianCalendar();
		 CalDay calday = new CalDay(cal);
		 calday.addAppt(appt);
		 calday.iterator();
//		 assertEquals(null, calday.iterator());
	 }

	@Test
	public void test03()  throws Throwable {
	 	int[]a = {0,1,2};
		LinkedList<Appt> appts = new LinkedList<Appt>();
		Appt appt = new Appt(10,20,8,12,2018,null,null);
		appt.setRecurrence(a, Appt.RECUR_BY_WEEKLY,1, Appt.RECUR_NUMBER_FOREVER);
		appts.add(appt);

		Appt appt1 = new Appt(10,20,9,12,2018,null,null);
		appt.setRecurrence(a, Appt.RECUR_BY_WEEKLY,1, Appt.RECUR_NUMBER_FOREVER);
		appts.add(appt1);

		Appt appt2 = new Appt(10,20,10,12,2018,null,null);
		appt.setRecurrence(a, Appt.RECUR_BY_MONTHLY,1, Appt.RECUR_NUMBER_FOREVER);
		appts.add(appt2);

		GregorianCalendar cal = new GregorianCalendar(2018, 01, 01);
		CalDay calday = new CalDay(cal);

		calday.setAppts(appts);

		Appt appt3 = new Appt();

		Appt appt4 = new Appt(10,20,10,12,2018,null,null);
		appt.setRecurrence(a, Appt.RECUR_BY_MONTHLY,1, Appt.RECUR_NUMBER_FOREVER);
		appts.add(appt4);

		calday.addAppt(appt);
		calday.addAppt(appt1);
		calday.addAppt(appt2);
		calday.addAppt(appt3);
		calday.addAppt(appt4);

		String b = calday.toString();

		LinkedList<Appt> appts1 = new LinkedList<Appt>();
		CalDay calday1 = new CalDay();
		calday1.setAppts(appts1);
	}

	@Test
	public void test04()  throws Throwable {
	 	CalDay calday1 = new CalDay();
	 	assertEquals(null, calday1.iterator());

		Appt appt = new Appt(21,30,15,01,2018,null,null);
		Appt appt1 = new Appt(20,00,10,01,2018,null,null);

		GregorianCalendar cal=new GregorianCalendar(01, 01, 2018);
		CalDay calday=new CalDay(cal);
		calday.addAppt(appt);
		calday.addAppt(appt1);
	}
//add more unit tests as you needed
}
