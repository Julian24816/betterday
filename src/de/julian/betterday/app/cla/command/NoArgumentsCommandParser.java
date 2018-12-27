package de.julian.betterday.app.cla.command;

import de.julian.betterday.app.cla.Command;
import de.julian.betterday.app.cla.CommandParser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class NoArgumentsCommandParser implements CommandParser {
    private final String key;
    private final Class<? extends Command> commandClass;
    private final String helpMenuDescription;

    NoArgumentsCommandParser(String key, Class<? extends Command> commandClass, String helpMenuDescription) {
        this.helpMenuDescription = helpMenuDescription;
        assert hasDefaultConstructor(commandClass);
        this.key = key;
        this.commandClass = commandClass;
    }

    private boolean hasDefaultConstructor(Class<? extends Command> commandClass) {
        for (Constructor constructor : commandClass.getConstructors())
            if (constructor.getParameterCount() == 0)
                return true;
        return false;
    }

    @Override
    public Command parse(String[] tokens) throws CommandParseException{
        if (tokens.length != 1) ; //TODO output error
        if (!tokens[0].equals(key))
            throw new CommandParseException(String.format("illegal token for %s-command parser: %s", key, tokens[0]));
        try {
            return commandClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
            throw new CommandParseException("unexpected exception while trying to instantiate " + commandClass);
        }
    }

    @Override
    public String getHelpMenuDescription() {
        return helpMenuDescription;
    }
}
