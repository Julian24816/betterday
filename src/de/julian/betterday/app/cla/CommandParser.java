package de.julian.betterday.app.cla;

import de.julian.betterday.app.cla.command.CommandParseException;

public interface CommandParser {
    Command parse(String[] tokens) throws CommandParseException;
    String getHelpMenuDescription();
}
