package de.julian.betterday.app.commandlineapp.add;

abstract class TimeToken extends TokenType{
    @Override
    boolean fits(String token) {
        return token.matches("(?<hour>[01]\\d|2[0-3]):(?<minute>[0-5][0-9])");
    }
}
