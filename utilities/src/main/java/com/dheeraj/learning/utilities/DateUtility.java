package com.dheeraj.learning.utilities;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by dgopali on 8/21/2015.
 */
public class DateUtility {
    public static void main(String[] args) {
        Locale locale = new Locale("en", "HK");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
        String date = dateFormat.format(new Date());
        System.out.print(date);
/*
        DateTimeFormatter.ofLocalizedDateTime( FormatStyle.FULL )
                .withLocale( Locale.CANADA_FRENCH );*/
    }
}
