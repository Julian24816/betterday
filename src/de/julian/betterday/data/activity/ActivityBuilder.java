package de.julian.betterday.data.activity;

import de.julian.betterday.data.time.DateTimeParseException;
import de.julian.betterday.data.time.TimeInterval;

import java.util.Date;

public class ActivityBuilder {
    private String category;
    private Date startDate, endDate;

    public ActivityBuilder() {
        //TODO create constructor that initializes all values based on an Activity instance
    }

    public ActivityBuilder setCategory(String category) {
        this.category = category;
        return this;
        //TODO use category manager or sth
    }

    public ActivityBuilder setStartTime(String startTime) throws DateTimeParseException {
        return setStartTime(TimeInterval.getParser().parseDate(startTime));
    }

    //TODO set startTime to last end time by default
    private ActivityBuilder setStartTime(Date startDate) {
        this.startDate = startDate;
        assertStartDateLiesBeforeEndDate();
        return this;
    }

    private void assertStartDateLiesBeforeEndDate() {
        if (endDate == null) return;
        assert startDate.before(endDate) : "start date does not lie before end date";
    }

    //TODO set end time to 10min after start time by default
    public ActivityBuilder setEndTime(String endTime) throws DateTimeParseException {
        this.endDate = TimeInterval.getParser().parseDate(endTime);
        moveEndDateAfterStartDateIfNecessary();
        return this;
    }

    private void moveEndDateAfterStartDateIfNecessary() {
        if (startDate == null) return;
        assert endDate != null;
        while (endDate.before(startDate))
            endDate = incrementByOneDay(endDate);
    }

    private Date incrementByOneDay(Date date) {
        return new Date(date.getTime() + 1000 * 60 * 60 * 24);
    }

    public boolean isComplete() {
        return category != null && startDate != null && endDate != null;
        //TODO see equals method
    }

    public Activity build() {
        return new Activity(category, new TimeInterval(startDate, endDate));
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ActivityBuilder
                && ((ActivityBuilder) obj).category.equals(category)
                && ((ActivityBuilder) obj).startDate.equals(startDate)
                && ((ActivityBuilder) obj).endDate.equals(endDate);
        //TODO be careful when adding new members to activity
    }
}
