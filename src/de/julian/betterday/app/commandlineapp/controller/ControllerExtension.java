package de.julian.betterday.app.commandlineapp.controller;

import java.util.Map;

public interface ControllerExtension {
    void registerCommandsAt(Map<String, CommandParser> commandMap);
}
