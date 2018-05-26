package com.expedia.application.constants.violation;

public final class ViolationConstants {

    public static final String MAX_TRIP_START_DATE_SHOULD_BE_NOT_BE_BEFORE_TODAY = "Max trip start date should be not be before today";
    public static final String MIN_TRIP_START_DATE_SHOULD_NOT_BE_BEFORE_TODAY = "Min trip start date should not be before today";
    public static final String MIN_HOTEL_STAR_RATING_SHOULD_NOT_BE_LESS_OR_EQUAL_TO_ZERO = "Min hotel star rating should not be less or equal to zero";
    public static final String MAX_HOTEL_STAR_RATING_CANNOT_BE_MORE_THAN_FIVE = "Max hotel star rating cannot be more than five";
    public static final String LENGTH_OF_STAY_SHOULD_NOT_BE_LESS_OR_EQUAL_TO_ZERO = "Length of stay should not be less or equal to zero";

    private ViolationConstants() {

    }
}
