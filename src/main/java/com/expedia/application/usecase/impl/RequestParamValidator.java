package com.expedia.application.usecase.impl;

import com.expedia.application.converter.date.DateConverter;
import com.expedia.application.model.RequestParam;
import com.expedia.application.usecase.Usecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static com.expedia.application.constants.param.RequestParamsNames.*;
import static com.expedia.application.constants.violation.ViolationConstants.*;
import static java.util.Objects.nonNull;

@Component
public class RequestParamValidator implements Usecase<RequestParam, Map<String, String>> {


    @Autowired
    private DateConverter dateConverter;

    @Override
    public Map<String, String> execute(RequestParam requestParam) {
        HashMap<String, String> violations = new HashMap<>();
        if (nonNull(requestParam.getMinTripStartDate())) {
            validateMinTripStartDate((dateConverter.convert(requestParam.getMinTripStartDate())), violations);
        }
        if (nonNull(requestParam.getMaxTripStartDate())) {
            validateMaxTripStartDate(dateConverter.convert(requestParam.getMaxTripStartDate()), violations);
        }
        validateMinHotelStarRating(requestParam.getMinStarRating(), violations);
        validateMaxHotelStarRating(requestParam.getMaxStarRating(), violations);
        validateLengthOfStay(requestParam.getLengthOfStay(), violations);
        return violations;
    }

    private void validateLengthOfStay(Integer lengthOfStay, Map<String, String> violations) {
        if (nonNull(lengthOfStay) && lengthOfStay <= 0) {
            violations.put(LENGTH_OF_STAY, LENGTH_OF_STAY_SHOULD_NOT_BE_LESS_OR_EQUAL_TO_ZERO);
        }
    }

    private void validateMaxHotelStarRating(Integer maxStarRating, Map<String, String> violations) {
        if (nonNull(maxStarRating) && maxStarRating > 5) {
            violations.put(MAX_STAR_RATING, MAX_HOTEL_STAR_RATING_CANNOT_BE_MORE_THAN_FIVE);
        }
    }

    private void validateMinHotelStarRating(Integer minStarRating, Map<String, String> violations) {
        if (nonNull(minStarRating) && minStarRating <= 0) {
            violations.put(MIN_STAR_RATING, MIN_HOTEL_STAR_RATING_SHOULD_NOT_BE_LESS_OR_EQUAL_TO_ZERO);
        }
    }

    private void validateMaxTripStartDate(LocalDate maxTripStartDate, Map<String, String> violations) {
        if (LocalDate.now().isAfter(maxTripStartDate)) {
            violations.put(MAX_TRIP_START_DATE, MAX_TRIP_START_DATE_SHOULD_BE_NOT_BE_BEFORE_TODAY);
        }
    }

    private void validateMinTripStartDate(LocalDate minTripStartDate, Map<String, String> violations) {
        if (LocalDate.now().isAfter(minTripStartDate)) {
            violations.put(MIN_TRIP_START_DATE, MIN_TRIP_START_DATE_SHOULD_NOT_BE_BEFORE_TODAY);
        }
    }
}
