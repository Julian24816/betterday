package de.julian.betterday.app.cla.controller;

import de.julian.betterday.app.cla.Command;
import de.julian.betterday.app.cla.command.Exit;
import de.julian.betterday.app.cla.command.Help;

import java.util.Map;

public class TopLevelCommandLineController extends CommandLineControllerImpl {

    @Override
    protected void registerCommands(Map<String, CommandParser> commandMap) {
        commandMap.put("exit", new NoArgumentsCommandParser("exit", "exit the program") {
            @Override
            protected Command getCommandInstance() {
                return new Exit();
            }
        });
        commandMap.put("help", new NoArgumentsCommandParser("help", "show this list of commands") {
            @Override
            protected Command getCommandInstance() {
                return Help.createCommandFor(TopLevelCommandLineController.this);
            }
        });
    }

    @Override
    public String getPrompt() {
        return "> ";
    }
}
