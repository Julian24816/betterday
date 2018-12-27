package de.julian.betterday.app.cla.command;

import de.julian.betterday.app.cla.Command;
import de.julian.betterday.app.cla.controller.CommandLineControllerImpl;
import de.julian.betterday.app.cla.controller.TopLevelCommandLineController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopLevelCommandLineControllerTest {

    //TODO many more tests

    private CommandLineControllerImpl commandLineControllerImpl;

    @BeforeEach
    void setUp() {
        commandLineControllerImpl = new TopLevelCommandLineController();
    }

    @Test
    void parseExitTest() {
        assertStringParsesAs("exit", new Exit());
    }

    private void assertStringParsesAs(String string, Command expected) {
        Command actual = commandLineControllerImpl.parse(string);
        assertEquals(expected, actual);
    }
}