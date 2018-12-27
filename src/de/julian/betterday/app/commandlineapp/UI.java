package de.julian.betterday.app.commandlineapp;

public interface UI {
    String promptInputLine(String prompt);
    String inputLine();
    void outputLine(String output);
    void separator();
    void close();
}
