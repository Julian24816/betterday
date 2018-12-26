package de.julian.betterday.app.cla.command;

public class TopLevelCommandParser extends CommandParser {
    @Override
    public Command parse(String string) {
        return new Exit();
    }

    @Override
    public String getPrompt() {
        return "> ";
    }

    @Override
    public String listAvailableCommands() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("*\tExit.");
        return stringBuilder.toString();
    }
}
