package de.julian.betterday.app.cla;

import de.julian.betterday.app.App;

public class CommandLineApp extends App {
    private UI ui;
    private CommandLineController commandLineController;
    private CommandLineControllerFactory defaultControllerFactory;

    public CommandLineApp(CommandLineControllerFactory defaultControllerFactory) {
        this.defaultControllerFactory = defaultControllerFactory;
    }

    @Override
    protected void setup() {
        ui = new DefaultUI();
        ui.outputLine("Hello Julian!\nStill using the Command-Line-App? Well, it's you choice...");
        ui.separator();
        commandLineController = defaultControllerFactory.getCommandLineController();
    }

    @Override
    protected void loop() {
        Command command = null;
        command = parseNextCommand();
        if (commandLineController.isExitCommand(command)) done();
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
