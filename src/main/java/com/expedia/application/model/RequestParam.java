package com.expedia.application.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class RequestParam {

    private String destinationName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date minTripStartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maxTripStartDate;
    private Integer lengthOfStay;
    private Integer minStarRating;
    private Integer maxStarRating;

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public Date getMinTripStartDate() {
        return minTripStartDate;
    }

    public void setMinTripStartDate(Date minTripStartDate) {
        this.minTripStartDate = minTripStartDate;
    }

    public Date getMaxTripStartDate() {
        return maxTripStartDate;
    }

    public void setMaxTripStartDate(Date maxTripStartDate) {
        this.maxTripStartDate = maxTripStartDate;
    }

    public Integer getLengthOfStay() {
        return lengthOfStay;
    }

    public void setLengthOfStay(Integer lengthOfStay) {
        this.lengthOfStay = lengthOfStay;
    }

    public Integer getMinStarRating() {
        return minStarRating;
    }

    public void setMinStarRating(Integer minStarRating) {
        this.minStarRating = minStarRating;
    }

    public Integer getMaxStarRating() {
        return maxStarRating;
    }

    public void setMaxStarRating(Integer maxStarRating) {
        this.maxStarRating = maxStarRating;
    }
}
