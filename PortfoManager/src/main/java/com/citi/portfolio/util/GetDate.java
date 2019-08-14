package com.citi.portfolio.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {
    // 获取当前日期：yyyy-MM-dd
    public static String getCurrentDate(){
        String pattern="yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format( new Date());
    }
}