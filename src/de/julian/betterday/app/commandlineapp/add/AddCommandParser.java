package de.julian.betterday.app.commandlineapp.add;

import de.julian.betterday.app.commandlineapp.Command;
import de.julian.betterday.app.commandlineapp.controller.CommandParseException;
import de.julian.betterday.app.commandlineapp.controller.CommandParser;

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
