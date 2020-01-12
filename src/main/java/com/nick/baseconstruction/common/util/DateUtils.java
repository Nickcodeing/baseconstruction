package com.nick.baseconstruction.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static void method(){

    }

    public static String getCurrentTime(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = simpleDateFormat.format(date);
        return format;
    }
}
