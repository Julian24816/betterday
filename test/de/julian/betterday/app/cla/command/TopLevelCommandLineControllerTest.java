package de.julian.betterday.app.cla.command;

import de.julian.betterday.app.cla.Command;
import de.julian.betterday.app.cla.CommandLineController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopLevelCommandLineControllerTest {

    //TODO many more tests

    private CommandLineController commandLineController;

    @BeforeEach
    void setUp() {
        commandLineController = new TopLevelCommandLineController();
    }

    @Test
    void parseExitTest() {
        assertStringParsesAs("exit", new Exit());
    }

    private void assertStringParsesAs(String string, Command expected) {
        Command actual = commandLineController.parse(string);
        assertEquals(expected, actual);
    }
}