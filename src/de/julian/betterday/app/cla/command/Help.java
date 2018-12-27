package de.julian.betterday.app.cla.command;

import de.julian.betterday.app.cla.Command;
import de.julian.betterday.app.cla.UI;
import de.julian.betterday.app.cla.controller.CommandLineControllerImpl;

public abstract class Help extends Command {
    @Override
    public final void execute(UI ui) {
        ui.outputLine(getCommandLineControllerInstance().listAvailableCommands());
    }

    protected abstract CommandLineControllerImpl getCommandLineControllerInstance();

    public static Help createCommandFor(CommandLineControllerImpl commandLineController) {
        return new Help() {
            @Override
            protected CommandLineControllerImpl getCommandLineControllerInstance() {
                return commandLineController;
            }
        };
    }
}
