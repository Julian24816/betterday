package de.julian.betterday.app.cla.command;

import de.julian.betterday.app.cla.Command;
import de.julian.betterday.app.cla.CommandLineController;
import de.julian.betterday.app.cla.UI;

abstract class Help extends Command {
    @Override
    public final void execute(UI ui) {
        ui.outputLine(getCommandLineControllerInstance().listAvailableCommands());
    }

    protected abstract CommandLineController getCommandLineControllerInstance();
}
