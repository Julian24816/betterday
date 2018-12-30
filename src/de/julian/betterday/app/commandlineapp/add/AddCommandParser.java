package de.julian.betterday.app.commandlineapp.add;

import de.julian.betterday.app.commandlineapp.Command;
import de.julian.betterday.app.commandlineapp.controller.CommandParser;

class AddCommandParser extends CommandParser {
    AddCommandParser() {
        super("add a new activity");
    }

    @Override
    public Command parse(String[] tokens) {
        assert tokens.length > 0 : "add-command-parser was called with 0 tokens";
        assert tokens[0].equals("add") : "illegal command name for add-command parser: " + tokens[0];
        return new AddCommand();
    }

}
