package de.julian.betterday.app.cla.command;

import de.julian.betterday.app.cla.Command;
import de.julian.betterday.app.cla.UI;
import de.julian.betterday.app.cla.controller.CommandParseException;

public class ShowCommandParseException extends Command {
    private String message;
    public ShowCommandParseException(CommandParseException e) {
        message = e.getMessage();
    }

    @Override
    public void execute(UI ui) {
        ui.outputLine(message);
    }
}
