package de.julian.betterday.app.cla.command;

import de.julian.betterday.app.cla.Command;
import de.julian.betterday.app.cla.UI;

public class Exit extends Command {
    @Override
    public void execute(UI ui) {
        throw new IllegalStateException("On receiving Exit Command the Command Line Interface should exit immediately.");
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Exit;
    }
}
