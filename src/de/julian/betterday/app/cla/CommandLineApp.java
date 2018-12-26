package de.julian.betterday.app.cla;

import de.julian.betterday.app.App;

import java.util.Scanner;

public class CommandLineApp extends App {

    private static final String SEPARATOR = "----------------------------------------------------------";
    private static final String WELCOME_MESSAGE = "Hello Julian!\n" +
            "Still using the Command-Line-App? Well, it's you choice...\n" + SEPARATOR + "\n";
    private static final String TEARDOWN_MESSAGE = "Bye.";

    private Scanner scanner;

    @Override
    protected void setup() {
        System.out.println(WELCOME_MESSAGE);
        scanner = new Scanner(System.in);
    }

    @Override
    protected void loop() {
        System.out.println(getMenu());
        getCommand();
        System.out.println("Nothing happens yet.");
        System.out.println(SEPARATOR);
        System.out.println();
        getCommand();
        System.out.println("Nothing happens yet.");
        done();
    }

    private String getMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("nothing on the menu yet.\n");
        stringBuilder.append("sorry.");
        return stringBuilder.toString();
    }

    private void getCommand() {
        System.out.print(getPrompt());
        scanner.next();
    }

    private String getPrompt() {
        return "> ";
    }

    @Override
    protected void teardown() {
        scanner.close();
        System.out.println(TEARDOWN_MESSAGE);
    }
}
