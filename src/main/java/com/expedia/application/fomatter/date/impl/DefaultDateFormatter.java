package com.expedia.application.fomatter.date.impl;

import com.expedia.application.converter.date.DateConverter;
import com.expedia.application.fomatter.date.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DefaultDateFormatter implements DateFormatter {

    @Autowired
    private DateConverter dateConverter;

    @Override
    public String format(Date date) {
        return dateConverter.convert(date).format(getFormatter());
    }
}
