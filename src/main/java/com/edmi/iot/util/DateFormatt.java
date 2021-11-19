package com.edmi.iot.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatt {
    private static  final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public static String getDate(Date date){
        return dateFormat.format(date);
    }
}
