package de.julian.betterday.app.cla.command;

import de.julian.betterday.app.cla.Command;
import de.julian.betterday.app.cla.CommandLineController;
import de.julian.betterday.app.cla.CommandParser;
import de.julian.betterday.app.cla.UI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopLevelCommandLineController implements CommandLineController {
    private final Map<String, CommandParser> commandMap = new HashMap<>();
    private final int maxCommandLength;

    public TopLevelCommandLineController() {
        commandMap.put("exit", new NoArgumentsCommandParser("exit", "exit the program") {
            @Override
            protected Command getCommandInstance() {
                return new Exit();
            }
        });
        commandMap.put("help", new NoArgumentsCommandParser("help", "show this list of commands") {
            @Override
            protected Command getCommandInstance() {
                return Help.createCommandFor(TopLevelCommandLineController.this);
            }
        });
        maxCommandLength = commandMap.keySet().stream().mapToInt(String::length).max().orElse(0);
    }

    @Override
    public Command parse(String string) {
        String[] tokens = string.trim().split(" ");
        if (tokens.length == 0 || tokens[0].equals("")) return doNothingCommand();
        if (!commandMap.containsKey(tokens[0])) return unknownCommand(string);
        try {
            return commandMap.get(tokens[0]).parse(tokens);
        } catch (CommandParseException e) {
            return new ShowParseError(e);
        }
    }

    private Command unknownCommand(String string) {
        return new ShowParseError(new CommandParseException("Unknown command '" + string + "'."));
    }

    private Command doNothingCommand() {
        return new Command() {
            @Override
            public void execute(UI ui) {
                // do nothing
            }
        };
    }

    @Override
    public String getPrompt() {
        return "> ";
    }

    @Override
    public String listAvailableCommands() {
        String menuFormatString = " %" + maxCommandLength + "s : ";

        List<Map.Entry<String, CommandParser>> entryList = commandMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());

        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, CommandParser> entry : entryList) {
            stringBuilder.append(String.format(menuFormatString, entry.getKey()));
            stringBuilder.append(entry.getValue().getHelpMenuDescription());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
