package de.julian.betterday.app.cla.command;

import de.julian.betterday.app.cla.Command;
import de.julian.betterday.app.cla.UI;

class UnknownCommand extends Command {
    private final String text;

    UnknownCommand(String theUnknownCommand) {
        text = theUnknownCommand;
    }

    @Override
    public void execute(UI ui) {
        ui.outputLine("Unknown command '" + text + "'. Use 'help' for a list of commands.");
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof UnknownCommand &&
                ((UnknownCommand) obj).text.equals(text);
    }
}
