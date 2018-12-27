package de.julian.betterday;

import de.julian.betterday.app.commandlineapp.CommandLineApp;
import de.julian.betterday.app.commandlineapp.minimalController.TopLevelCommandLineControllerFactory;

public class Main {
    public static void main(String[] args) {
        new CommandLineApp(new TopLevelCommandLineControllerFactory()).run();
    }
}
