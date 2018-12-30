package de.julian.betterday.data.time;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeIntervalTest {

    @Test
    void testArgumentPermutationDoesNotMatter() {
        final String expected = "12:00 - 13:00";
        assertCorrectCreation(expected, 13, 0, 12, 0);
        assertCorrectCreation(expected, 12, 0, 13, 0);
    }

    @Test
    void testRounding() {
        assertCorrectCreation("11:50 - 12:40", 11, 54, 12, 44);

        assertCorrectCreation("12:00 - 12:50", 11, 55, 12, 45);
        assertCorrectCreation("12:00 - 12:50", 12, 4, 12, 54);
        
        assertCorrectCreation("12:10 - 13:00", 12, 5, 12, 55);
    }

    private void assertCorrectCreation(String expected, int hour1, int minute1, int hour2, int minute2) {
        TimeInterval timeInterval = new TimeInterval(
                getDateForHourAndMinute(hour1, minute1),
                getDateForHourAndMinute(hour2, minute2)
        );
        assertEquals("TimeInterval(27.12.2018 " + expected + ")", timeInterval.toString());
    }

    private Date getDateForHourAndMinute(int hour, int minute) {
        return new GregorianCalendar(2018, Calendar.DECEMBER, 27, hour, minute, 0).getTime();
    }
}