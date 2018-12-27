package de.julian.betterday.app.cla.controller;

import de.julian.betterday.app.cla.Command;
import de.julian.betterday.app.cla.UI;

class ShowCommandParseExceptionCommand extends Command {
    private String message;
    ShowCommandParseExceptionCommand(CommandParseException e) {
        message = e.getMessage();
    }

    @Override
    public void execute(UI ui) {
        ui.outputLine(message);
    }
}
