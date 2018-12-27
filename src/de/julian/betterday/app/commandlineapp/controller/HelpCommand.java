package de.julian.betterday.app.commandlineapp.controller;

import de.julian.betterday.app.commandlineapp.Command;
import de.julian.betterday.app.commandlineapp.CommandLineController;
import de.julian.betterday.app.commandlineapp.UI;

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
