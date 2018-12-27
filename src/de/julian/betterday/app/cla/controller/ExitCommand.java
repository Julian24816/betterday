package de.julian.betterday.app.cla.controller;

import de.julian.betterday.app.cla.Command;
import de.julian.betterday.app.cla.UI;

class ExitCommand extends Command {
    @Override
    public void execute(UI ui) {
        throw new IllegalStateException("On receiving Exit Command the Command Line Interface should exit immediately.");
    }
}
