package de.julian.betterday.app.cla.controller;

import java.util.Map;

class TopLevelCommandLineController extends CommandLineControllerImpl {

    @Override
    protected void registerCommands(Map<String, CommandParser> commandMap) {
        commandMap.put("exit", NoArgumentsCommandParser.forReusableCommand(
                "exit", "exit the program", new ExitCommand()));
        commandMap.put("help", NoArgumentsCommandParser.forReusableCommand(
                "help", "show this list of commands", HelpCommand.createCommandFor(TopLevelCommandLineController.this)));
    }

    @Override
    public String getPrompt() {
        return "> ";
    }
}
