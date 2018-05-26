package com.expedia.application.builder.impl;

import com.expedia.application.builder.UrlBuilder;
import com.expedia.application.fomatter.date.impl.DefaultDateFormatter;
import com.expedia.application.model.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.expedia.application.constants.param.RequestParamsNames.*;
import static java.util.Objects.nonNull;
import static org.thymeleaf.util.StringUtils.isEmptyOrWhitespace;

@Component
public class JsonUrlBuilder implements UrlBuilder {

    private static final String AND = "&";
    private static final String EQUALS = "=";
    private static final String SPACE = " ";
    private static final String EMPTY_STRING = "";


    @Autowired
    private DefaultDateFormatter defaultDateFormatter;

    @Override
    public String build(String jsontUrl, RequestParam requestParam) {
        StringBuilder stringBuilder = new StringBuilder(jsontUrl);
        if (!isEmptyOrWhitespace(requestParam.getDestinationName())) {
            stringBuilder.append(AND).append(DESTINATION_NAME).append(EQUALS)
                    .append(requestParam.getDestinationName().replaceAll(SPACE, EMPTY_STRING));
        }
        if (nonNull(requestParam.getMinTripStartDate())) {
            stringBuilder.append(AND).append(MIN_TRIP_START_DATE).append(EQUALS)
                    .append(defaultDateFormatter.format(requestParam.getMinTripStartDate()));
        }
        if (nonNull(requestParam.getMaxTripStartDate())) {
            stringBuilder.append(AND).append(MAX_TRIP_START_DATE).append(EQUALS)
                    .append(defaultDateFormatter.format(requestParam.getMaxTripStartDate()));
        }
        if (nonNull(requestParam.getLengthOfStay())) {
            stringBuilder.append(AND).append(LENGTH_OF_STAY).append(EQUALS).append(requestParam.getLengthOfStay());
        }
        if (nonNull(requestParam.getMinStarRating())) {
            stringBuilder.append(AND).append(MIN_STAR_RATING).append(EQUALS).append(requestParam.getMinStarRating());
        }
        if (nonNull(requestParam.getMaxStarRating())) {
            stringBuilder.append(AND).append(MAX_STAR_RATING).append(EQUALS).append(requestParam.getMaxStarRating());
        }
        return stringBuilder.toString();
    }
}
