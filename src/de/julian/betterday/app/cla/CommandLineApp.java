package de.julian.betterday.app.cla;

import de.julian.betterday.app.App;
import de.julian.betterday.app.cla.command.Command;
import de.julian.betterday.app.cla.command.Exit;
import de.julian.betterday.app.cla.ui.DefaultUI;
import de.julian.betterday.app.cla.ui.UI;

public class CommandLineApp extends App {

    private static final String WELCOME_MESSAGE = "Hello Julian!\n" +
            "Still using the Command-Line-App? Well, it's you choice...";
    private static final String TEARDOWN_MESSAGE = "Bye.";

    private UI ui;

    @Override
    protected void setup() {
        ui = new DefaultUI();
        ui.outputLine(WELCOME_MESSAGE);
        ui.separator();
    }

    @Override
    protected void loop() {
        printOptions();
        Command command = parseNextCommand();
        if (command instanceof Exit) done();
        else command.execute();
    }

    private void printOptions() {
        ui.outputLine(getMenu());
    }

    private Command parseNextCommand() {
        ui.promptInputLine(getPrompt());
        return new Exit();
    }

    private String getMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("nothing on the menu yet.\n");
        stringBuilder.append("sorry.");
        return stringBuilder.toString();
    }

    private String getPrompt() {
        return "> ";
    }

    @Override
    protected void teardown() {
        ui.shutdown();
        ui = null;
        System.out.println(TEARDOWN_MESSAGE);
    }
}
