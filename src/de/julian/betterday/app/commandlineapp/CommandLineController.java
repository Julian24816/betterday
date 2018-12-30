package de.julian.betterday.app.commandlineapp;

import de.julian.betterday.app.commandlineapp.controller.ControllerExtension;

public interface CommandLineController {
    Command parse(String string);
    String getPrompt();
    String listAvailableCommands();
    boolean isExitCommand(Command command);
    void applyExtension(ControllerExtension controllerExtension);
}
