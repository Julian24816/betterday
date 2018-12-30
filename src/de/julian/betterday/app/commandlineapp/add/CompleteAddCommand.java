package de.julian.betterday.app.commandlineapp.add;

import de.julian.betterday.app.commandlineapp.Command;
import de.julian.betterday.app.commandlineapp.UI;
import de.julian.betterday.data.activity.ActivityBuilder;

class CompleteAddCommand extends Command {
    private ActivityBuilder activityBuilder;

    CompleteAddCommand(ActivityBuilder activityBuilder) {
        this.activityBuilder = activityBuilder;
    }

    @Override
    public void execute(UI ui) {
        //TODO implement
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CompleteAddCommand && ((CompleteAddCommand) obj).activityBuilder.equals(activityBuilder);
    }
}
