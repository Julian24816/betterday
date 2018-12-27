package de.julian.betterday.app.commandlineapp.minimalController;

import de.julian.betterday.app.commandlineapp.CommandLineController;
import de.julian.betterday.app.commandlineapp.CommandLineControllerFactory;

public class TopLevelCommandLineControllerFactory extends CommandLineControllerFactory {
    @Override
    protected CommandLineController getCommandLineController() {
        return new TopLevelCommandLineController();
    }
}
