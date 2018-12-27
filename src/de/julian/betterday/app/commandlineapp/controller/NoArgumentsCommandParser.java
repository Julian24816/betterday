package de.julian.betterday.app.commandlineapp.controller;

import de.julian.betterday.app.commandlineapp.Command;

import java.util.Arrays;

abstract class NoArgumentsCommandParser extends CommandParser {
    protected abstract Command getCommandInstance();

    NoArgumentsCommandParser(String key, String helpMenuDescription) {
        super(key, helpMenuDescription);
    }

    @Override
    public Command parse(String[] tokens) throws CommandParseException {
        checkAssertions(tokens);
        if (tokens.length > 1)
            throw new CommandParseException("illegal arguments for command " + getKey() + ": '" +
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
