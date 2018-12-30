package de.julian.betterday;

import de.julian.betterday.app.commandlineapp.CommandLineApp;
import de.julian.betterday.app.commandlineapp.CommandLineController;
import de.julian.betterday.app.commandlineapp.add.AddCommandControllerExtension;
import de.julian.betterday.app.commandlineapp.controller.TopLevelCommandLineController;

public class LaunchCLA {
    public static void main(String[] args) {
        CommandLineController commandLineController = new TopLevelCommandLineController();
        commandLineController.applyExtension(new AddCommandControllerExtension());
        new CommandLineApp(commandLineController).run();
    }
}
