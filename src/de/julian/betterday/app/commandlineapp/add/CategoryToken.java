package de.julian.betterday.app.commandlineapp.add;

import de.julian.betterday.data.activity.ActivityBuilder;

class CategoryToken extends TokenType {
    @Override
    boolean fits(String token) {
        return true;
        //TODO use better regex, maybe via category manager
    }

    @Override
    void applyTokenTo(String token, ActivityBuilder activityBuilder) {
        activityBuilder.setCategory(token);
    }
}
