package com.expedia.application.fomatter.date;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public interface DateFormatter {

    default DateTimeFormatter getFormatter() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    String format(Date date);
}
