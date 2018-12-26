package de.julian.betterday.app.cla.command;

public class Exit extends Command {
    @Override
    public void execute() {
        throw new IllegalStateException("On receiving Exit Command the Command Line Interface should exit immediately.");
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Exit;
    }
}
