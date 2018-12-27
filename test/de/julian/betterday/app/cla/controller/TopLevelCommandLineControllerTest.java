package de.julian.betterday.app.cla.controller;

import de.julian.betterday.app.cla.Command;
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
        assertStringParsesAs("exit", new ExitCommand());
    }

    private void assertStringParsesAs(String string, Command expected) {
        Command actual = commandLineControllerImpl.parse(string);
        assertEquals(expected, actual);
    }
}