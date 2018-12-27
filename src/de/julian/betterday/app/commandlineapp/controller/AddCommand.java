package de.julian.betterday.app.commandlineapp.controller;

import de.julian.betterday.app.commandlineapp.Command;
import de.julian.betterday.app.commandlineapp.UI;

class AddCommand extends Command {
    @Override
    public void execute(UI ui) {
        ui.outputLine("adds some crazy shit");
        //TODO do sth real
    }
}
