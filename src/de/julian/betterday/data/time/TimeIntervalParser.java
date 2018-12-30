package de.julian.betterday.data.time;

interface TimeIntervalParser {
    TimeInterval parse(String timeIntervalString) throws TimeIntervalParseException;
}
