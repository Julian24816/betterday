package de.julian.betterday.app.cla.command;

import de.julian.betterday.app.cla.Command;
import de.julian.betterday.app.cla.UI;

public class ShowParseError extends Command {
    private String message;
    ShowParseError(CommandParseException e) {
        message = e.getMessage();
    }

    @Override
    public void execute(UI ui) {
        ui.outputLine(message);
    }
}
