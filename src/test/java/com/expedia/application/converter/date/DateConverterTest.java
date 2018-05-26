package com.expedia.application.converter.date;


import com.expedia.application.configurer.ApplicationTestConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationTestConfiguration.class)
public class DateConverterTest {


    @Autowired
    private DateConverter dateConverter;

    @Test
    public void givenDateOfToday_WhenConvertDate_ThenShouldReturnLocalDateWithTodaysDate() {
        Assert.assertEquals(dateConverter.convert(new Date()), LocalDate.now());
    }


    @Test
    public void givenDateOfTomorrow_WhenConvertDate_ThenShouldReturnLocalDateWithTomorrowsDate() {
        Assert.assertEquals(dateConverter.convert(getTomorrowsDate()), LocalDate.now().plusDays(1));
    }

    @Test
    public void givenDateOfYesterday_WhenConvertDate_ThenShouldReturnLocalDateWithYesterdaysDate() {
        Assert.assertEquals(dateConverter.convert(getYesterdaysDate()), LocalDate.now().minusDays(1));
    }


    private Date getYesterdaysDate() {
        return Date.from(LocalDate.now().minusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }


    private Date getTomorrowsDate() {
        return Date.from(LocalDate.now().plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
