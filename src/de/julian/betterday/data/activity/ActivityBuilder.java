package de.julian.betterday.data.activity;

public class ActivityBuilder {
    public ActivityBuilder setCategory(String category) {
        return this;
        //TODO use category manager or sth
    }

    public ActivityBuilder setStartTime(String timeString) {
        return this;
        //TODO parse startTime string
    }

    public ActivityBuilder setEndTime(String timeString) {
        return this;
        //TODO parse endTime string
    }

    public Activity build() {
        return null;
        //TODO create real activity if allowed
    }
}
