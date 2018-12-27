package de.julian.betterday.app.cla.command;

import de.julian.betterday.app.cla.Command;
import de.julian.betterday.app.cla.CommandLineController;
import de.julian.betterday.app.cla.CommandParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopLevelCommandLineController implements CommandLineController {
    private static Map<String, CommandParser> map = new HashMap<>();
    static {
        map.put("exit", new NoArgumentsCommandParser("exit", Exit.class, "exit program"));
        map.put("help", new NoArgumentsCommandParser("help", Exit.class, "show this list of commands"));
    }
    private static int maxCommandLength = map.keySet().stream().mapToInt(String::length).max().orElse(0);

    @Override
    public Command parse(String string) {
        String[] tokens = string.split(" ");
        if (tokens.length == 0 || tokens[0].equals("")) return new DoNothingCommand();
        if (map.containsKey(tokens[0]))
            try {
                return map.get(tokens[0]).parse(tokens);
            } catch (CommandParseException e) {
                throw new RuntimeException(e); //TODO add correct error handling
            }
        return new UnknownCommand(tokens[0]);
    }

    @Override
    public String getPrompt() {
        return "> ";
    }

    @Override
    public String listAvailableCommands() {
        String menuFormatString = " %" + maxCommandLength + "s : ";

        List<Map.Entry<String, CommandParser>> entryList = map.entrySet().stream()
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
