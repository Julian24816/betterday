package de.julian.betterday.app.commandlineapp.add;

import de.julian.betterday.app.commandlineapp.Command;
import de.julian.betterday.app.commandlineapp.controller.CommandParseException;
import de.julian.betterday.data.activity.ActivityBuilder;
import de.julian.betterday.data.time.DateTimeParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddCommandParserTest {

    private AddCommandParser parser;

    @BeforeEach
    void setUp() {
        parser = new AddCommandParser();
    }

    @Test
    void testSimpleParsing() {
        try {
            Command actual = parser.parse(new String[]{"add", "sleep", "12:00", "13:00"});
            Command expected = new ConfirmAddCommand(
                    new ActivityBuilder()
                            .setCategory("sleep")
                            .setStartTime("12:00")
                            .setEndTime("13:00")
                            .build());
            assertEquals(expected, actual);
        } catch (CommandParseException | DateTimeParseException e) {
            fail("parsing resulted in an exception", e);
        }
    }

    //TODO implement case where CompleteAddCommand is Returned

}