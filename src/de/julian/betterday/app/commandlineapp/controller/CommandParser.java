package de.julian.betterday.app.commandlineapp.controller;

import de.julian.betterday.app.commandlineapp.Command;

interface CommandParser {
    Command parse(String[] tokens) throws CommandParseException;
    String getHelpMenuDescription();
}
