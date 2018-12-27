package de.julian.betterday.app.commandlineapp.minimalController;

import de.julian.betterday.app.commandlineapp.Command;

interface CommandParser {
    Command parse(String[] tokens) throws CommandParseException;
    String getHelpMenuDescription();
}
