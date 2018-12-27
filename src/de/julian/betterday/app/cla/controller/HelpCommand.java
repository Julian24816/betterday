package de.julian.betterday.app.cla.controller;

import de.julian.betterday.app.cla.Command;
import de.julian.betterday.app.cla.CommandLineController;
import de.julian.betterday.app.cla.UI;

abstract class HelpCommand extends Command {
    @Override
    public final void execute(UI ui) {
        ui.outputLine(getCommandLineControllerInstance().listAvailableCommands());
    }

    protected abstract CommandLineController getCommandLineControllerInstance();

    static HelpCommand createCommandFor(CommandLineController commandLineController) {
        return new HelpCommand() {
            @Override
            protected CommandLineController getCommandLineControllerInstance() {
                return commandLineController;
            }
        };
    }
}
