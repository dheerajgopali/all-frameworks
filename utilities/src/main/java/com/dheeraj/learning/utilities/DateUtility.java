package com.dheeraj.learning.utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by dgopali on 8/21/2015.
 */
public class DateUtility {
    public static String dateFormat = "yyyy-MM-dd hh:mm:ss";
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);


    public static void main(String[] args) {
        System.out.println(convertMillisToDate("1507020598000"));
    }

    public static String convertMillisToDate(String dateInMillis){
       Calendar calendar = Calendar.getInstance();
       calendar.setTimeInMillis(Long.parseLong(dateInMillis));
       simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
       return simpleDateFormat.format(calendar.getTime());
    }
}
