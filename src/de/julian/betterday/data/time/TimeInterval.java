package de.julian.betterday.data.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeInterval {
    private static final int ACCURACY_IN_MINUTES = 10;
    private static final int ACCURACY_IN_MILLISECONDS = ACCURACY_IN_MINUTES * 60_000;
    private Date begin, end;

    TimeInterval(Date begin, Date end) {
        Date first = begin.before(end) ? begin : end;
        Date second = end.after(begin) ? end : begin;
        this.begin = roundToAccuracy(first);
        this.end = roundToAccuracy(second);
    }

    private static Date roundToAccuracy(Date date) {
        long milliseconds = date.getTime() + ACCURACY_IN_MILLISECONDS/2;
        return new Date(milliseconds / ACCURACY_IN_MILLISECONDS * ACCURACY_IN_MILLISECONDS);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof TimeInterval
                && ((TimeInterval) obj).begin.equals(begin) && ((TimeInterval) obj).end.equals(end);
    }

    @Override
    public String toString() {
        DateFormat longDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        DateFormat shortDateFormat = getShortestPossibleDateFormatForDifference(begin, end);
        return "TimeInterval(" + longDateFormat.format(begin) + " - " + shortDateFormat.format(end) + ')';
    }

    private static DateFormat getShortestPossibleDateFormatForDifference(Date base, Date other) {
        Calendar baseCalendar = getCalendar(base);
        Calendar otherCalendar = getCalendar(other);
        if (differentAtField(baseCalendar, otherCalendar, Calendar.YEAR)) return new SimpleDateFormat("yyyy-MM-dd HH:mm");
        if (differentAtField(baseCalendar, otherCalendar, Calendar.MONTH)) return new SimpleDateFormat("MM-dd HH:mm");
        if (differentAtField(baseCalendar, otherCalendar, Calendar.DAY_OF_MONTH)) return new SimpleDateFormat("dd HH:mm");
        return new SimpleDateFormat("HH:mm");
    }

    private static boolean differentAtField(Calendar baseCalendar, Calendar otherCalendar, int field_constant) {
        return baseCalendar.get(field_constant) != otherCalendar.get(field_constant);
    }

    private static Calendar getCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}
