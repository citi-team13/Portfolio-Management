package com.citi.portfolio.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类(yyyy-MM-dd)
 */
public class DateUtil {
    /**
     * 获取今天
     * @return String
     * */
    public static String getToday(){
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    /**
     * 获取昨天
     * @return String
     * */
    public static String getYestoday(){
        Calendar cal= Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        Date time=cal.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time);
    }
}
