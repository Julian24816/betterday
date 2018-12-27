package de.julian.betterday.app.cla.controller;

import de.julian.betterday.app.cla.Command;
import de.julian.betterday.app.cla.CommandLineController;
import de.julian.betterday.app.cla.UI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

abstract class CommandLineControllerImpl implements CommandLineController {
    private final Map<String, CommandParser> commandMap = new HashMap<>();
    private final String menuFormatString;

    protected abstract void registerCommands(Map<String, CommandParser> commandMap);
    public abstract String getPrompt();

    CommandLineControllerImpl() {
        registerCommands(commandMap);
        int maxCommandLength = commandMap.keySet().stream().mapToInt(String::length).max().orElse(0);
        menuFormatString = " %" + maxCommandLength + "s : ";
    }

    public Command parse(String string) {
        String[] tokens = string.trim().split(" ");
        if (isEmptyCommand(tokens)) return doNothingCommand();
        return getCommandOrExceptionDisplayCommand(tokens);
    }

    private boolean isEmptyCommand(String[] tokens) {
        return tokens.length == 0 || tokens[0].equals("");
    }

    private Command doNothingCommand() {
        return new Command() {
            @Override
            public void execute(UI ui) {
                // do nothing
            }
        };
    }

    private Command getCommandOrExceptionDisplayCommand(String[] tokens) {
        try {
            return getCommandOrException(tokens);
        } catch (CommandParseException e) {
            return new ShowCommandParseExceptionCommand(e);
        }
    }

    private Command getCommandOrException(String[] tokens) throws CommandParseException {
        if (!commandMap.containsKey(tokens[0])) throw unknownCommandException(String.join(" ", tokens));
        return commandMap.get(tokens[0]).parse(tokens);
    }

    private CommandParseException unknownCommandException(String string) {
        return new CommandParseException("Unknown command '" + string + "'.");
    }

    public String listAvailableCommands() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, CommandParser> entry : getSortedEntryList())
            appendEntryToStringBuilder(stringBuilder, entry);
        return stringBuilder.toString();
    }

    private void appendEntryToStringBuilder(StringBuilder stringBuilder, Map.Entry<String, CommandParser> entry) {
        stringBuilder.append(String.format(menuFormatString, entry.getKey()));
        stringBuilder.append(entry.getValue().getHelpMenuDescription());
        stringBuilder.append("\n");
    }

    private List<Map.Entry<String, CommandParser>> getSortedEntryList() {
        return commandMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());
    }

    @Override
    public boolean isExitCommand(Command command) {
        return command instanceof ExitCommand;
    }
}
