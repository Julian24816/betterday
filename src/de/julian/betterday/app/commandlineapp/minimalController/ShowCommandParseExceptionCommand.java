package de.julian.betterday.app.commandlineapp.minimalController;

import de.julian.betterday.app.commandlineapp.Command;
import de.julian.betterday.app.commandlineapp.UI;

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
