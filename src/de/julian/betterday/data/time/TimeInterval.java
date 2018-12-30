package de.julian.betterday.data.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeInterval {
    private static final int ACCURACY_IN_MINUTES = 10;
    private static final int ACCURACY_IN_MILLISECONDS = ACCURACY_IN_MINUTES * 60_000;

    private static final TimeIntervalParser PARSER = new DefaultTimeIntervalParser();

    private Date begin, end;

    public TimeInterval(Date begin, Date end) {
        if (begin.before(end))
            _init(begin, end);
        else _init(end, begin);
    }

    public static TimeIntervalParser getParser() {
        return PARSER;
    }

    private void _init(Date begin, Date end) {
        this.begin = roundToAccuracy(begin);
        this.end = roundToAccuracy(end);
    }

    private static Date roundToAccuracy(Date date) {
        long milliseconds = date.getTime() + ACCURACY_IN_MILLISECONDS/2;
        return new Date(milliseconds / ACCURACY_IN_MILLISECONDS * ACCURACY_IN_MILLISECONDS);
    }

    public static TimeInterval parse(String timeIntervalString) throws TimeIntervalParseException{
        return PARSER.parse(timeIntervalString);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof TimeInterval
                && ((TimeInterval) obj).begin.equals(begin) && ((TimeInterval) obj).end.equals(end);
    }

    @Override
    public String toString() {
        DateFormat longDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        DateFormat shortDateFormat = getShortestPossibleDateFormatForDifference(begin, end);
        return "TimeInterval(" + longDateFormat.format(begin) + " - " + shortDateFormat.format(end) + ')';
    }

    private static DateFormat getShortestPossibleDateFormatForDifference(Date base, Date other) {
        Calendar baseCalendar = getCalendar(base);
        Calendar otherCalendar = getCalendar(other);
        if (differentAtField(baseCalendar, otherCalendar, Calendar.YEAR)) return new SimpleDateFormat("dd.MM.yyyy HH:mm");
        if (differentAtField(baseCalendar, otherCalendar, Calendar.MONTH)) return new SimpleDateFormat("dd.MM. HH:mm");
        if (differentAtField(baseCalendar, otherCalendar, Calendar.DAY_OF_MONTH)) return new SimpleDateFormat("dd. HH:mm");
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
