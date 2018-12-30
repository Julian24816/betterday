package de.julian.betterday.app.commandlineapp;

import de.julian.betterday.app.App;
import de.julian.betterday.app.commandlineapp.controller.TopLevelCommandLineController;

public class CommandLineApp extends App {
    private UI ui;
    private CommandLineController commandLineController;

    public CommandLineApp(CommandLineController commandLineController) {
        this.commandLineController = commandLineController;
    }

    @Override
    protected void setup() {
        ui = new DefaultUI();
        ui.outputLine(commandLineController.getStartupText());
        ui.separator();
    }

    @Override
    protected void loop() {
        Command command = null;
        command = parseNextCommand();
        if (commandLineController.isExitCommand(command)) done();
        else command.execute(ui);
    }

    private Command parseNextCommand() {
        final String prePromptText = commandLineController.getPrePromptText();
        if (prePromptText != null) ui.outputLine(prePromptText);
        String prompt = commandLineController.getPrompt();
        String choice = ui.promptInputLine(prompt);
        return commandLineController.parse(choice);
    }

    @Override
    protected void teardown() {
        ui.outputLine(commandLineController.getExitText());
        ui.close();
        ui = null;
    }
}
