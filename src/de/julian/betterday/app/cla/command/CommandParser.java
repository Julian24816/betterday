package de.julian.betterday.app.cla.command;

public abstract class CommandParser {
    public abstract Command parse(String string);
    public abstract String getPrompt();
    public abstract String listAvailableCommands();
}
