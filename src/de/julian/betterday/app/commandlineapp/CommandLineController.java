package de.julian.betterday.app.commandlineapp;

public interface CommandLineController {
    Command parse(String string);
    String getPrompt();
    String listAvailableCommands();
    boolean isExitCommand(Command command);
}
