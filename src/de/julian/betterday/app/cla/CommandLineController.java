package de.julian.betterday.app.cla;

public interface CommandLineController {
    Command parse(String string);
    String getPrompt();
    String listAvailableCommands();
}
