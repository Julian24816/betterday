package de.julian.betterday.app.cla;

public interface CommandLineController {
    Command parse(String tokens);
    String getPrompt();
    String listAvailableCommands();
}
