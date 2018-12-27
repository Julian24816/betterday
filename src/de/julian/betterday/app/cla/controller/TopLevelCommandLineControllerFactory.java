package de.julian.betterday.app.cla.controller;

import de.julian.betterday.app.cla.CommandLineController;
import de.julian.betterday.app.cla.CommandLineControllerFactory;

public class TopLevelCommandLineControllerFactory extends CommandLineControllerFactory {
    @Override
    protected CommandLineController getCommandLineController() {
        return new TopLevelCommandLineController();
    }
}
