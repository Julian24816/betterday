package de.julian.betterday.data.activity;

import de.julian.betterday.data.time.TimeInterval;

public class Activity {
    private String category;
    private TimeInterval timeInterval;

    Activity(String category, TimeInterval timeInterval) {
        this.category = category;
        this.timeInterval = timeInterval;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Activity
                && ((Activity) obj).category.equals(category)
                && ((Activity) obj).timeInterval.equals(timeInterval);
    }
}
