package de.julian.betterday.app.cla;

import de.julian.betterday.app.App;
import de.julian.betterday.app.cla.command.Exit;
import de.julian.betterday.app.cla.controller.TopLevelCommandLineController;

public class CommandLineApp extends App {
    private UI ui;
    private CommandLineController commandLineController;

    @Override
    protected void setup() {
        ui = new DefaultUI();
        ui.outputLine("Hello Julian!\nStill using the Command-Line-App? Well, it's you choice...");
        ui.separator();
        commandLineController = new TopLevelCommandLineController();
    }

    @Override
    protected void loop() {
        Command command = null;
        command = parseNextCommand();
        if (command instanceof Exit) done();
        else command.execute(ui);
    }

    private Command parseNextCommand() {
        String prompt = commandLineController.getPrompt();
        String choice = ui.promptInputLine(prompt);
        return commandLineController.parse(choice);
    }

    @Override
    protected void teardown() {
        ui.close();
        ui = null;
        System.out.println("Bye.");
    }
}
