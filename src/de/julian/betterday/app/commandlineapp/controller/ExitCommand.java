package de.julian.betterday.app.commandlineapp.controller;

import de.julian.betterday.app.commandlineapp.Command;
import de.julian.betterday.app.commandlineapp.UI;

class ExitCommand extends Command {
    @Override
    public void execute(UI ui) {
        throw new IllegalStateException("On receiving Exit Command the Command Line Interface should exit immediately.");
    }
}
