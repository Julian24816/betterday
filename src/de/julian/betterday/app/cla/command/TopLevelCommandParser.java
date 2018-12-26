package de.julian.betterday.app.cla.command;

public class TopLevelCommandParser extends CommandParser {
    @Override
    public Command parse(String string) {
        if (string.equals("exit"))
            return new Exit();
        return new UnknownCommand(string);
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
