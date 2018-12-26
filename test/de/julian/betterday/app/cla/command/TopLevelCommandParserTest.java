package de.julian.betterday.app.cla.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopLevelCommandParserTest {

    @Test
    void parse() {
        CommandParser commandParser = new TopLevelCommandParser();
        Command expected = new Exit();
        Command actual = commandParser.parse("exit");
        assertEquals(expected, actual);
    }
}