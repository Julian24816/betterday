package de.julian.betterday.app.commandlineapp.add;

import de.julian.betterday.app.commandlineapp.controller.CommandParser;
import de.julian.betterday.app.commandlineapp.controller.ControllerExtension;

import java.util.Map;

public class AddCommandControllerExtension implements ControllerExtension {
    @Override
    public void registerCommandsAt(Map<String, CommandParser> commandMap) {
        commandMap.put("add", new AddCommandParser("add", "add a new activity"));
    }
}
