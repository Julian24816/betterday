package de.julian.betterday.app.commandlineapp;

import de.julian.betterday.app.commandlineapp.controller.ControllerExtension;

public interface CommandLineController {
    String getStartupText();
    String getPrePromptText();
    String getPrompt();
    Command parse(String string);
    boolean isExitCommand(Command command);
    String getExitText();

    String listAvailableCommands();

    void applyExtension(ControllerExtension controllerExtension);
}
