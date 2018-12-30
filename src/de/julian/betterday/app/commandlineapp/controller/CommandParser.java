package de.julian.betterday.app.commandlineapp.controller;

import de.julian.betterday.app.commandlineapp.Command;

public abstract class CommandParser {
    private final String helpMenuDescription;

    protected CommandParser(String helpMenuDescription) {
        this.helpMenuDescription = helpMenuDescription;
    }

    public abstract Command parse(String[] tokens) throws CommandParseException;

    String getHelpMenuDescription() {
        return helpMenuDescription;
    }
}
