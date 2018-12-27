package de.julian.betterday.app.cla.controller;

import de.julian.betterday.app.cla.Command;

interface CommandParser {
    Command parse(String[] tokens) throws CommandParseException;
    String getHelpMenuDescription();
}
