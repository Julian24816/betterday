package de.julian.betterday.app.commandlineapp.add;

import de.julian.betterday.app.commandlineapp.Command;
import de.julian.betterday.app.commandlineapp.controller.CommandParseException;
import de.julian.betterday.app.commandlineapp.controller.CommandParser;

import java.util.Arrays;

class AddCommandParser extends CommandParser {
    private static final AddCommandTokensPattern[] PATTERNS = {
            new AddCommandTokensPattern(new CategoryToken(), new StartTimeToken(), new EndTimeToken())
            //TODO more patterns, for example no arguments at all for completely interactive experience
    };
    //TODO help on available patterns

    AddCommandParser() {
        super("add a new activity");
    }

    @Override
    public Command parse(String[] tokens) throws CommandParseException {
        assert tokens.length > 0 : "add-command-parser was called with 0 tokens";
        assert tokens[0].equals("add") : "illegal command name for add-command parser: " + tokens[0];

        return findAndApplyPatternOrThrowException(Arrays.copyOfRange(tokens, 1, tokens.length));
    }

    private Command findAndApplyPatternOrThrowException(String[] tokens) throws CommandParseException {
        for (AddCommandTokensPattern pattern : PATTERNS)
            if (pattern.fits(tokens))
                return pattern.parse(tokens);
        throw new CommandParseException("Illegal argument sequence for add-command: '" + String.join(" ", tokens) + "'");
    }
}
