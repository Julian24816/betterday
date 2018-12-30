package de.julian.betterday.app.commandlineapp.controller;

import de.julian.betterday.app.commandlineapp.Command;

import java.util.Arrays;

abstract class NoArgumentsCommandParser extends CommandParser {
    private final String key;

    protected abstract Command getCommandInstance();

    NoArgumentsCommandParser(String key, String helpMenuDescription) {
        super(helpMenuDescription);
        this.key = key;
    }

    @Override
    public Command parse(String[] tokens) throws CommandParseException {
        assert tokens.length > 0 : key + "-command-parser was called with 0 tokens";
        assert tokens[0].equals(key) : "illegal command name for " + key + "-command parser: " + tokens[0];
        if (tokens.length > 1)
            throw new CommandParseException("illegal arguments for command " + key + ": '" +
                    String.join(" ", Arrays.copyOfRange(tokens, 1, tokens.length)) + "'.");
        return getCommandInstance();
    }

    static NoArgumentsCommandParser forReusableCommand(String key, String helpMenuDescription, Command command) {
        return new NoArgumentsCommandParser(key, helpMenuDescription) {
            @Override
            protected Command getCommandInstance() {
                return command;
            }
        };
    }
}
