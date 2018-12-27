package de.julian.betterday.app.cla.controller;

import de.julian.betterday.app.cla.Command;
import de.julian.betterday.app.cla.CommandLineController;
import de.julian.betterday.app.cla.UI;
import de.julian.betterday.app.cla.command.ShowCommandParseException;

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
        if (tokens.length == 0 || tokens[0].equals("")) return doNothingCommand();
        if (!commandMap.containsKey(tokens[0])) return unknownCommand(string);
        try {
            return commandMap.get(tokens[0]).parse(tokens);
        } catch (CommandParseException e) {
            return new ShowCommandParseException(e);
        }
    }

    private Command unknownCommand(String string) {
        return new ShowCommandParseException(new CommandParseException("Unknown command '" + string + "'."));
    }

    private Command doNothingCommand() {
        return new Command() {
            @Override
            public void execute(UI ui) {
                // do nothing
            }
        };
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

}
