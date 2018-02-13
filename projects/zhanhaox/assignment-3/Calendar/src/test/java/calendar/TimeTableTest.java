package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		 TimeTable timetable=new TimeTable();
		 LinkedList<Appt> appts = new LinkedList<Appt>();
		 GregorianCalendar start = new GregorianCalendar(2018,3,27);
		 GregorianCalendar end = new GregorianCalendar(2018, 4, 20);
		 Appt appt = new Appt(21,30,27,3,2018,null,null);
		 Appt appt2 = new Appt(21,30,20,4,2018,null,null);
		 appts.push(appt);
		 appts.push(appt2);
		 timetable.getApptRange(appts,start,end);
	 }
	 @Test
	  public void test02()  throws Throwable  {
		 TimeTable timetable=new TimeTable();
		 LinkedList<Appt> appts = new LinkedList<Appt>();
		 Appt appt = new Appt(21,30,19,7,2018,null,null);
		 appts.add(appt);
		 timetable.deleteAppt(appts,appt);
		 assertEquals(null,timetable.deleteAppt(appts,appt));
		 GregorianCalendar day1 = new GregorianCalendar(2018, 12, 9);
		 GregorianCalendar day2 = new GregorianCalendar(2018, 12, 8);
		 LinkedList<Appt> appts1 = new LinkedList<Appt>();
		 TimeTable timetable1 = new TimeTable();
		 Appt appt1 = new Appt(11, 30, 18, 12, 2018,"title", "description");
		 Appt appt2 = new Appt(12, 30, 03, 12, 2018,"title", "description");
		 Appt appt3 = new Appt(13, 30, 04, 12, 2018,"title", "description");
		 Appt appt4 = new Appt(14, 30, 05, 12, 2018,"title", "description");

		 appts1.add(appt1);
		 appts1.add(appt2);
		 appts1.add(appt3);
		 appts1.add(appt4);
		 int [] a = {0,1,2,3};
		 LinkedList<CalDay> cal_1 = new LinkedList<CalDay>();
		 assertEquals(0, cal_1.size());
//		 assertEquals(0, cal_1.get(0).getMonth());
//		 assertEquals(0, cal_1.get(0).getSizeAppts());
		 cal_1 = timetable1.getApptRange(appts, day2, day1);
		 LinkedList<Appt> appts2 = timetable1.permute(appts1, a);
		 assertEquals(4, appts2.size());
		 assertEquals(12, appts2.getFirst().getStartMonth());
		 assertEquals(18, appts2.getFirst().getStartDay());
		 assertEquals("title", appts2.getFirst().getTitle());
		 assertEquals("description", appts2.getFirst().getDescription());

		 assertEquals(12, appts2.get(2).getStartMonth());
		 assertEquals(4, appts2.get(2).getStartDay());
		 assertEquals("title", appts2.get(2).getTitle());
		 assertEquals("description", appts2.get(2).getDescription());

		 assertEquals(12, appts2.get(3).getStartMonth());
		 assertEquals(5, appts2.get(3).getStartDay());
		 assertEquals("title", appts2.get(3).getTitle());
		 assertEquals("description", appts2.get(3).getDescription());

//		 assertTrue(appt.isRecurring());
		 assertEquals(0,appt.getRecurDays().length);
		 assertFalse(appt1.isRecurring());
		 assertEquals(0,appt1.getRecurDays().length);
	 }
	 @Test
	 public void test03()  throws Throwable  {
		 LinkedList<Appt> appts = new LinkedList<Appt>();
		 int[] a={0,1,2};
		 Appt appt = new Appt(10, 30, 8, 12, 2018,"null", "null");
		 appt.setRecurrence( a, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		 appts.add(appt);
		 Appt appt1 = new Appt(12, 30, 8, 12, 2018,"null", "null");
		 appt1.setRecurrence( a, Appt.RECUR_BY_YEARLY, 1, Appt.RECUR_NUMBER_FOREVER);
		 appts.add(appt1);
		 Appt appt2 = new Appt(12, 30, 9, 12, 2018,"null", "null");
		 appt2.setRecurrence( a, Appt.RECUR_BY_MONTHLY, 1, Appt.RECUR_NUMBER_FOREVER);
		 appts.add(appt2);
		 Appt appt3 = new Appt(16, 30, 9, 12, 2018,"null", "null");
		 appt3.setRecurrence( a, Appt.RECUR_BY_MONTHLY, 1, Appt.RECUR_NUMBER_FOREVER);
		 appts.add(appt3);

		 TimeTable timetable = new TimeTable();

		 timetable.deleteAppt(appts, appt);
		 timetable.deleteAppt(appts, appt1);
		 timetable.deleteAppt(appts, appt2);
		 timetable.deleteAppt(appts, appt3);

		 Appt appt4 = null;
		 appts.add(appt4);
		 assertEquals(null, timetable.deleteAppt(appts,appt4));

		 Appt appt5 = new Appt();
		 appts.add(appt5);
		 assertEquals(null, timetable.deleteAppt(appts,appt5));
	 }
	 @Test
		public void test04() throws Throwable{
		 GregorianCalendar day1 = new GregorianCalendar(2018, 12, 9);
		 GregorianCalendar day2 = new GregorianCalendar(2018, 12, 8);
		 GregorianCalendar day3 = new GregorianCalendar(2020, 12, 1);

		 LinkedList<CalDay> cal = new LinkedList<CalDay>();
		 LinkedList<Appt> appts = new LinkedList<Appt>();

		 int[] recurDaysArr={2,3,4};
		 Appt appt1 = new Appt(10, 30, 8, 12, 2018,"title1", "description1");
		 appt1.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		 appts.add(appt1);

		 Appt appt2 = new Appt(12, 30, 8, 12, 2018,"title2", "description2");
		 appt2.setRecurrence( recurDaysArr, Appt.RECUR_BY_YEARLY, 1, Appt.RECUR_NUMBER_FOREVER);
		 appts.add(appt2);

		 Appt appt3 = new Appt(12, 30, 9, 12, 2018,"title3", "description3");
		 appt3.setRecurrence( recurDaysArr, Appt.RECUR_BY_MONTHLY, 1, Appt.RECUR_NUMBER_FOREVER);
		 appts.add(appt3);

		 Appt appt4 = new Appt(16, 30, 9, 12, 2018,"title4", "description4");
		 appt4.setRecurrence( recurDaysArr, Appt.RECUR_BY_MONTHLY, 1, Appt.RECUR_NUMBER_FOREVER);
		 appts.add(appt4);

		 TimeTable timetable = new TimeTable();

		 cal = timetable.getApptRange(appts, day2, day1);

		 LinkedList<CalDay> cal1 = new LinkedList<CalDay>();
		 cal1 = timetable.getApptRange(appts, day2, day3);

		 Appt appt_5 = new Appt(12, 11, 15, 5, 2018,"title5", "description5");
		 appt_5.setRecurrence( recurDaysArr, Appt.RECUR_BY_MONTHLY, 1, Appt.RECUR_NUMBER_FOREVER);
		 appts.add(appt_5);

	 }

	@Test
	public void test05() throws Throwable{
		TimeTable timetable = new TimeTable();
		LinkedList<Appt> appts = new LinkedList<Appt>();
		GregorianCalendar firstDay = new GregorianCalendar(2018, 12, 07);
		GregorianCalendar lastDay = new GregorianCalendar(2018, 12, 12);
		Appt appt = new Appt(21,30,07,12,2018,"Birthday Party",null);
		Appt appt1 = new Appt(21,30,07,12,2018,null,null);
		appts.push(appt);
		appts.push(appt1);

		LinkedList<CalDay> calDays = timetable.getApptRange(appts, firstDay, lastDay);
		assertTrue(calDays!=null);
		assertEquals(0, calDays.get(0).getMonth());
		assertEquals(2019, calDays.get(0).getYear());
		assertEquals(7, calDays.get(0).getDay());
		assertEquals(2, calDays.get(0).getSizeAppts());
		assertEquals("", calDays.get(0).getAppts().getFirst().getTitle());
	}

//add more unit tests as you needed
}
