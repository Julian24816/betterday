package de.julian.betterday.data.time;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultTimeIntervalParserTest {

    private TimeIntervalParser parser;

    @BeforeEach
    void setUp() {
        parser = new DefaultTimeIntervalParser();
    }

    @Test
    void testSpecialCaseParsing() {
        // 12:00 was interpreted as 00:00 when we still used SimpleDateFormat.parse
        assertCorrectParsing("30.12.2018 12:00 - 13:00");
    }

    @Test
    void testCorrectParsing() {
        assertCorrectParsing("30.12.2018 13:00 - 14:00");
        assertCorrectParsing("30.12.2018 09:00 - 14:00");
        assertCorrectParsing("30.12.2018 11:00 - 12:00");
    }

    private void assertCorrectParsing(String timeIntervalString) {
        try {
            TimeInterval timeInterval = parser.parse(timeIntervalString);
            assertEquals("TimeInterval(" + timeIntervalString + ")", timeInterval.toString());
        } catch (TimeIntervalParseException e) {
            fail("A Parse Exception occurred", e);
        }
    }

}