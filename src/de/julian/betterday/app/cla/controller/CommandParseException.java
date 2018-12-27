package de.julian.betterday.app.cla.controller;

class CommandParseException extends Exception {
    private static final String HELP_MESSAGE = " Use 'help' for a list of commands.";

    CommandParseException(String message) {
        this(message, true);
    }

    private CommandParseException(String message, boolean helpNecessary) {
        super(helpNecessary ? message + HELP_MESSAGE : message);
    }
}