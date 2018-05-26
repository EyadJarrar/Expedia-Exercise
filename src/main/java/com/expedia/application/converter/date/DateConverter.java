package com.expedia.application.converter.date;

import java.time.LocalDate;
import java.util.Date;

public interface DateConverter {

    LocalDate convert(Date date);
}
