package de.julian.betterday.data.time;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class TimeIntervalTest {

    @Test
    void testStringRepresentation() {
        assertStringRepresentation("TimeInterval(2018-12-27 13:00 - 14:40)", 13, 0, 14, 40);
    }

    @Test
    void testArgumentPermutationDoesNotMatter() {
        assertStringRepresentation("TimeInterval(2018-12-27 12:00 - 13:00)", 13, 0, 12, 0);
        assertStringRepresentation("TimeInterval(2018-12-27 12:00 - 13:00)", 12, 0, 13, 0);
    }

    @Test
    void testAccuracyIsUsedForComparison() {
        assertStringRepresentation("TimeInterval(2018-12-27 12:00 - 12:50)", 11, 56, 12, 53);
        assertStringRepresentation("TimeInterval(2018-12-27 12:00 - 12:50)", 12, 4, 12, 48);

        assertStringRepresentation("TimeInterval(2018-12-27 11:50 - 12:40)", 11, 54, 12, 44);
        assertStringRepresentation("TimeInterval(2018-12-27 12:10 - 13:00)", 12, 6, 12, 57);
    }

    private void assertStringRepresentation(String expectedStringRepresentation, int hour1, int minute1, int hour2, int minute2) {
        TimeInterval timeInterval = new TimeInterval(
                getDateForHourAndMinute(hour1, minute1),
                getDateForHourAndMinute(hour2, minute2)
        );
        assertEquals(expectedStringRepresentation, timeInterval.toString());
    }

    private Date getDateForHourAndMinute(int hour, int minute) {
        return new GregorianCalendar(2018, Calendar.DECEMBER, 27, hour, minute, 0).getTime();
    }
}