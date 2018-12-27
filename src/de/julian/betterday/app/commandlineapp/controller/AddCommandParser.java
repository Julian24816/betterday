package de.julian.betterday.app.commandlineapp.controller;

import de.julian.betterday.app.commandlineapp.Command;

class AddCommandParser extends CommandParser {
    AddCommandParser(String key, String helpMenuDescription) {
        super(key, helpMenuDescription);
    }

    @Override
    public Command parse(String[] tokens) throws CommandParseException {
        checkAssertions(tokens);
        return new AddCommand();
    }

}
