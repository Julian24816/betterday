package de.julian.betterday.app.cla;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class DefaultUI implements UI {
    private PrintStream outputStream;
    private Scanner scanner;

    private DefaultUI(InputStream inputStream, PrintStream outputStream) {
        scanner = new Scanner(inputStream);
        this.outputStream = outputStream;
    }

    DefaultUI() {
        this(System.in, System.out);
    }

    @Override
    public String promptInputLine(String prompt) {
        System.out.print(prompt);
        return inputLine();
    }

    @Override
    public String inputLine() {
        return scanner.nextLine();
    }

    @Override
    public void outputLine(String output) {
        outputStream.println(output);
    }

    @Override
    public void separator() {
        outputLine("----------------------------------------------------------");
    }

    @Override
    public void close() {
        scanner.close();
    }
}
