package de.julian.betterday.app.commandlineapp.controller;

import java.util.Map;

public class TopLevelCommandLineController extends CommandLineControllerImpl {

    @Override
    protected void registerCommands(Map<String, CommandParser> commandMap) {
        commandMap.put("exit", NoArgumentsCommandParser.forReusableCommand(
                "exit", "exit the program", new ExitCommand()));

        //TODO allow arguments for help command
        commandMap.put("help", NoArgumentsCommandParser.forReusableCommand(
                "help", "show this list of commands", HelpCommand.createCommandFor(TopLevelCommandLineController.this)));
    }

    @Override
    public String getStartupText() {
        return "Hello Julian!\nStill using the Command-Line-App? Well, it's you choice...";
    }

    @Override
    public String getPrePromptText() {
        return null;
    }

    @Override
    public String getPrompt() {
        return "> "; //TODO print last add date before prompt (via extension?)
    }

    @Override
    public String getExitText() {
        return "Bye.";
    }
}
