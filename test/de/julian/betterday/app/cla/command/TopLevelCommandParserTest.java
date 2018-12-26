package de.julian.betterday.app.cla.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopLevelCommandParserTest {

    private CommandParser commandParser;

    @BeforeEach
    void setUp() {
        commandParser = new TopLevelCommandParser();
    }

    @Test
    void parseExitTest() {
        assertStringParsesAs("exit", new Exit());
    }

    @Test
    void parseUnknownCommandTest() {
        String text = "alkdsjf";
        assertStringParsesAs(text, new UnknownCommand(text));
    }

    private void assertStringParsesAs(String string, Command expected) {
        Command actual = commandParser.parse(string);
        assertEquals(expected, actual);
    }
}