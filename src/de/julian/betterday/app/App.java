package de.julian.betterday.app;

public abstract class App {
    private boolean done;

    protected abstract void setup();
    protected abstract void loop();
    protected abstract void teardown();

    protected final void done() {
        done = true;
    }

    private boolean isDone() {
        return done;
    }

    public final void run() {
        setup();
        while (!isDone())
            loop();
        teardown();
    }
}
