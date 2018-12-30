package de.julian.betterday.app.commandlineapp.add;

import de.julian.betterday.app.commandlineapp.Command;
import de.julian.betterday.data.activity.ActivityBuilder;

class AddCommandTokensPattern {
    private final TokenType[] tokenTypes;

    AddCommandTokensPattern(TokenType... tokenTypes) {
        this.tokenTypes = tokenTypes;
        //TODO assert correct number of token Types
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
//        assert !fits(tokens) : "trying to apply pattern to tokens that do not fit the pattern"; TODO why?
        ActivityBuilder activityBuilder = new ActivityBuilder();
        int index = 0;
        for (TokenType tokenType : tokenTypes)
            tokenType.applyTokenTo(tokens[index++], activityBuilder);
        if (activityBuilder.isComplete()) return new ConfirmAddCommand(activityBuilder.build());
        else return new CompleteAddCommand(activityBuilder);
    }
}
