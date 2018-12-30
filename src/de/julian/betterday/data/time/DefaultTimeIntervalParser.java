package de.julian.betterday.data.time;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultTimeIntervalParser implements TimeIntervalParser {

    private enum Field {
        DAY("day", "[0-2]\\d|3[01]", Calendar.DAY_OF_MONTH),
        MONTH("month", "0\\d|1[0-2]", Calendar.MONTH, -1),
        YEAR("year", "2\\d{3}", Calendar.YEAR),
        HOUR("hour", "[01]\\d|2[0-3]", Calendar.HOUR_OF_DAY),
        MINUTE("minute", "[0-5]\\d", Calendar.MINUTE);
        
        private String name;
        private String regex;
        private int calendar_constant;
        private int calendar_value_offset;

        Field(String name, String regex, int calendar_constant) {
            this(name, regex, calendar_constant, 0);
        }

        Field(String name, String regex, int calendar_constant, int calendar_value_offset) {
            this.name = name;
            this.regex = regex;
            this.calendar_constant = calendar_constant;
            this.calendar_value_offset = calendar_value_offset;
        }
        String group() {
            return "(?<" + name + ">" + regex + ")";
        }
    }
    private static final Field[] FIELD_PARSE_SEQUENCE = {Field.YEAR, Field.MONTH, Field.DAY, Field.HOUR, Field.MINUTE};

    private static final String START_REGEX =
            Field.DAY.group() + "\\." + Field.MONTH.group() + "\\." + Field.YEAR.group() + " " +
                    Field.HOUR.group() + ":" + Field.MINUTE.group();
    private static final Pattern START_PATTERN = Pattern.compile("^" + START_REGEX + "$");

    private static final String END_REGEX =
            "(" + Field.DAY.group() + "\\.(" + Field.MONTH.group() + "\\." + Field.YEAR.group() + "?)? )?" +
                    Field.HOUR.group() + ":" + Field.MINUTE.group();
    private static final Pattern END_PATTERN = Pattern.compile("^" + END_REGEX + "$");
    private static final Pattern TIME_INTERVAL_PATTERN = Pattern.compile(
            "(?<start>" + removeGroupNames(START_REGEX) + ")" + " - (?<end>" + removeGroupNames(END_REGEX) + ")");

    private static String removeGroupNames(String regex) {
        Matcher matcher = Pattern.compile("\\?<.*?>").matcher(regex);
        return matcher.replaceAll("");
    }

    @Override
    public TimeInterval parse(String timeIntervalString) throws TimeIntervalParseException {
        Matcher matcher = TIME_INTERVAL_PATTERN.matcher(timeIntervalString);
        if (!matcher.find())
            throw new TimeIntervalParseException("Illegal TimeInterval String: " + timeIntervalString);
        return parse(matcher.group("start"), matcher.group("end"));
    }

    private TimeInterval parse(String start, String end) throws TimeIntervalParseException {
        Matcher matcher = START_PATTERN.matcher(start);
        //noinspection AssertWithSideEffects
        assert matcher.find() : "illegal state, illegal timeInterval String should never reach this point";
        return parse(getDate(matcher), end);
    }

    private TimeInterval parse(Date startDate, String end) throws TimeIntervalParseException {
        return new TimeInterval(startDate, parseDate(startDate, end));
    }

    private Date getDate(Matcher matcher) {
        return getDate(new Date(), matcher);
    }

    private Date getDate(Date base, Matcher matcher) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(base);
        for (Field field : FIELD_PARSE_SEQUENCE)
            if (matcher.group(field.name) != null)
                calendar.set(field.calendar_constant,
                        Integer.parseInt(matcher.group(field.name)) + field.calendar_value_offset);
        return calendar.getTime();
    }

    @Override
    public Date parseDate(String dateTimeString) throws DateTimeParseException {
        return parseDate(new Date(), dateTimeString);
    }

    @Override
    public Date parseDate(Date base, String dateTimeString) throws DateTimeParseException {
        Matcher matcher = END_PATTERN.matcher(dateTimeString);
        if (!matcher.find())
            throw new DateTimeParseException("Illegal dateTime String: " + dateTimeString);
        return getDate(base, matcher);
    }
}
