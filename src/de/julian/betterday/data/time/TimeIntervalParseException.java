package de.julian.betterday.data.time;

import java.text.ParseException;

class TimeIntervalParseException extends Exception {
    TimeIntervalParseException(String message) {
        super(message);
    }
    TimeIntervalParseException(String message, Throwable reason) {
        super(message, reason);
    }
}
