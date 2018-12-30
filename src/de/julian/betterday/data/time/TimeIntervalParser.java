package de.julian.betterday.data.time;

import java.util.Date;

public interface TimeIntervalParser {
    TimeInterval parse(String timeIntervalString) throws TimeIntervalParseException;
    Date parseDate(String dateTimeString) throws DateTimeParseException;
    Date parseDate(Date base, String dateTimeString) throws DateTimeParseException;
}
