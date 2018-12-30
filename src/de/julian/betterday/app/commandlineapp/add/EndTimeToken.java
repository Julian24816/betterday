package de.julian.betterday.app.commandlineapp.add;

import de.julian.betterday.data.activity.ActivityBuilder;
import de.julian.betterday.data.time.DateTimeParseException;

class EndTimeToken extends TimeToken {
    @Override
    void applyTokenTo(String token, ActivityBuilder activityBuilder) {
        try {
            activityBuilder.setEndTime(token);
        } catch (DateTimeParseException ignored) {
            // This should never happen, because tokens have to fit the hh:mm regex,
            // which is accepted by activityBuilder.setEndTime
        }
    }
}
