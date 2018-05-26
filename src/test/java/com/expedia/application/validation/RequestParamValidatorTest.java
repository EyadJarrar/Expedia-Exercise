package com.expedia.application.validation;

import com.expedia.application.configurer.ApplicationTestConfiguration;
import com.expedia.application.model.RequestParam;
import com.expedia.application.usecase.impl.RequestParamValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static com.expedia.application.constants.TestConstants.CANADA;
import static com.expedia.application.constants.param.RequestParamsNames.*;
import static com.expedia.application.constants.violation.ViolationConstants.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationTestConfiguration.class)
public class RequestParamValidatorTest {


    private RequestParam requestParam;

    @Autowired
    private RequestParamValidator requestParamValidator;

    @Before
    public void setUp() {
        requestParam = getValidRequestParam();
    }


    @Test
    public void givenValidRequestParam_WhenExecuteValidation_ThenViolationsShouldBeEmpty() {
        Assert.assertTrue(requestParamValidator.execute(requestParam).isEmpty());
    }


    @Test
    public void givenRequestParamWithInvalidLengthOfStay_WhenExecuteValidation_ThenViolationsShouldContainLengthOfStayErrorMessage() {
        requestParam.setLengthOfStay(-1);
        Assert.assertEquals(LENGTH_OF_STAY_SHOULD_NOT_BE_LESS_OR_EQUAL_TO_ZERO, requestParamValidator.execute(requestParam).get(LENGTH_OF_STAY));
    }


    @Test
    public void givenRequestParamWithInvalidMinimumTripStartDate_WhenExecuteValidation_ThenViolationsShouldContainMinimumTripStartDateErrorMessage() {
        requestParam.setMinTripStartDate(getYesterdayDate());
        Assert.assertEquals(MIN_TRIP_START_DATE_SHOULD_NOT_BE_BEFORE_TODAY, requestParamValidator.execute(requestParam).get(MIN_TRIP_START_DATE));
    }

    @Test
    public void givenRequestParamWithInvalidMaximumTripStartDate_WhenExecuteValidation_ThenViolationsShouldContainMaximumTripStartDateErrorMessage() {
        requestParam.setMaxTripStartDate(getYesterdayDate());
        Assert.assertEquals(MAX_TRIP_START_DATE_SHOULD_BE_NOT_BE_BEFORE_TODAY, requestParamValidator.execute(requestParam).get(MAX_TRIP_START_DATE));
    }


    @Test
    public void givenRequestParamWithInvalidMinimumStarRating_WhenExecuteValidation_ThenViolationsShouldContainMinimumStarRatingErrorMessage() {
        requestParam.setMinStarRating(-1);
        Assert.assertEquals(MIN_HOTEL_STAR_RATING_SHOULD_NOT_BE_LESS_OR_EQUAL_TO_ZERO, requestParamValidator.execute(requestParam).get(MIN_STAR_RATING));
    }

    @Test
    public void givenRequestParamWithInvalidMaximumStarRating_WhenExecuteValidation_ThenViolationsShouldContainMaximumStarRatingErrorMessage() {
        requestParam.setMaxStarRating(6);
        Assert.assertEquals(MAX_HOTEL_STAR_RATING_CANNOT_BE_MORE_THAN_FIVE, requestParamValidator.execute(requestParam).get(MAX_STAR_RATING));
    }

    private RequestParam getValidRequestParam() {
        RequestParam requestParam = new RequestParam();
        requestParam.setDestinationName(CANADA);
        requestParam.setLengthOfStay(1);
        requestParam.setMinTripStartDate(new Date());
        requestParam.setMaxTripStartDate(new Date());
        requestParam.setMinStarRating(1);
        requestParam.setMaxStarRating(5);
        return requestParam;
    }

    private Date getYesterdayDate() {
        return Date.from(LocalDate.now().minusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());


    }
}
