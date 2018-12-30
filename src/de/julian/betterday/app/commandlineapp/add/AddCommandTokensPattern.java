package de.julian.betterday.app.commandlineapp.add;

import de.julian.betterday.app.commandlineapp.Command;

class AddCommandTokensPattern {
    private final TokenType[] tokenTypes;

    AddCommandTokensPattern(TokenType... tokenTypes) {
        this.tokenTypes = tokenTypes;
    }

    boolean fits(String[] tokens) {
        if (tokens.length != tokenTypes.length) return false;
        int index = 0;
        for (TokenType tokenType : tokenTypes)
            if (!tokenType.fits(tokens[index++]))
                return false;
        return true;
    }

    Command applyTo(String[] tokens) {
        return new AddCommand();
        //TODO implement
    }
}
