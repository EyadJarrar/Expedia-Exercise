package com.expedia.application.converter.date.impl;

import com.expedia.application.converter.date.DateConverter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
public class DefaultDateConverter implements DateConverter {
    @Override
    public LocalDate convert(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
