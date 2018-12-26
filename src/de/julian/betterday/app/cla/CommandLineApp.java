package de.julian.betterday.app.cla;

import de.julian.betterday.app.App;
import de.julian.betterday.app.cla.command.*;
import de.julian.betterday.app.cla.ui.*;

public class CommandLineApp extends App {

    private UI ui;
    private CommandParser commandParser;

    @Override
    protected void setup() {
        ui = new DefaultUI();
        ui.outputLine("Hello Julian!\nStill using the Command-Line-App? Well, it's you choice...");
        ui.separator();
        commandParser = new TopLevelCommandParser();
    }

    @Override
    protected void loop() {
        outputOptions();
        Command command = parseNextCommand();
        if (command instanceof Exit) done();
        else command.execute(ui);
    }

    private void outputOptions() {
        ui.outputLine(commandParser.listAvailableCommands());
    }

    private Command parseNextCommand() {
        String prompt = commandParser.getPrompt();
        String choice = ui.promptInputLine(prompt);
        return commandParser.parse(choice);
    }

    @Override
    protected void teardown() {
        ui.close();
        ui = null;
        System.out.println("Bye.");
    }
}
