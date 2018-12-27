package de.julian.betterday;

import de.julian.betterday.app.cla.CommandLineApp;
import de.julian.betterday.app.cla.controller.TopLevelCommandLineControllerFactory;

public class Main {
    public static void main(String[] args) {
        new CommandLineApp(new TopLevelCommandLineControllerFactory()).run();
    }
}
