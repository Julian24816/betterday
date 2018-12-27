package de.julian.betterday.app.commandlineapp.controller;

import java.util.Map;

class TopLevelCommandLineController extends CommandLineControllerImpl {

    @Override
    protected void registerCommands(Map<String, CommandParser> commandMap) {
        commandMap.put("exit", NoArgumentsCommandParser.forReusableCommand(
                "exit", "exit the program", new ExitCommand()));

        //TODO allow arguments for help command
        commandMap.put("help", NoArgumentsCommandParser.forReusableCommand(
                "help", "show this list of commands", HelpCommand.createCommandFor(TopLevelCommandLineController.this)));
        commandMap.put("add", new AddCommandParser("add", "add a new activity"));
    }

    @Override
    public String getPrompt() {
        return "> ";
    }
}
