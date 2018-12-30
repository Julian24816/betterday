package de.julian.betterday.app.commandlineapp.controller;

import de.julian.betterday.app.commandlineapp.Command;

public abstract class CommandParser {
    private final String key;
    private final String helpMenuDescription;

    protected CommandParser(String key, String helpMenuDescription) {
        this.key = key;
        this.helpMenuDescription = helpMenuDescription;
    }

    public abstract Command parse(String[] tokens) throws CommandParseException;

    String getHelpMenuDescription() {
        return helpMenuDescription;
    }

    protected void checkAssertions(String[] tokens) {
        assert tokens.length > 0 : key + "-command-parser was called with 0 tokens";
        assert tokens[0].equals(key) : "illegal command name for " + key + "-command parser: " + tokens[0];
    }

    String getKey() {
        return key;
    }
}
