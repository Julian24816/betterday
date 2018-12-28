package de.julian.betterday.data.time;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class TimeIntervalTest {

    @Test
    void testStringRepresentation() {
        TimeInterval timeInterval = new TimeInterval(
                getDateForHourAndMinute(13,0),
                getDateForHourAndMinute(14,40)
        );
        assertEquals("TimeInterval(2018-12-27 13:00 - 14:40)", timeInterval.toString());
    }

    @Test
    void testArgumentPermutationDoesNotMatter() {
        Date first = getDateForHourAndMinute(12, 0);
        Date second = getDateForHourAndMinute(13, 0);
        TimeInterval one = new TimeInterval(first, second);
        TimeInterval two = new TimeInterval(second, first);
        assertEquals(one, two);
    }

    @Test
    void testAccuracyIsUsedForComparison() {
        TimeInterval one = new TimeInterval(
                getDateForHourAndMinute(11, 56),
                getDateForHourAndMinute(12, 48));
        TimeInterval two = new TimeInterval(
                getDateForHourAndMinute(12, 4),
                getDateForHourAndMinute(12, 53));
        assertEquals(one, two);

        one = new TimeInterval(
                getDateForHourAndMinute(11, 54),
                getDateForHourAndMinute(12, 44));
        two = new TimeInterval(
                getDateForHourAndMinute(12, 6),
                getDateForHourAndMinute(12, 57));
        assertNotEquals(one, two);
    }

    private Date getDateForHourAndMinute(int hour, int minute) {
        return new GregorianCalendar(2018, Calendar.DECEMBER, 27, hour, minute, 0).getTime();
    }
}