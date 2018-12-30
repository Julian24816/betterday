package de.julian.betterday.app.commandlineapp.add;

import de.julian.betterday.app.commandlineapp.Command;
import de.julian.betterday.app.commandlineapp.UI;
import de.julian.betterday.data.activity.Activity;

class ConfirmAddCommand extends Command {
    private final Activity activity;

    ConfirmAddCommand(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void execute(UI ui) {
        //TODO ask for confirmation or changes
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ConfirmAddCommand && ((ConfirmAddCommand) obj).activity.equals(activity);
    }
}
