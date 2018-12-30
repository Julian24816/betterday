package de.julian.betterday.app.commandlineapp.add;

import de.julian.betterday.data.activity.ActivityBuilder;

abstract class TokenType {
    abstract boolean fits(String token);
    abstract void applyTokenTo(String token, ActivityBuilder activityBuilder);
}
