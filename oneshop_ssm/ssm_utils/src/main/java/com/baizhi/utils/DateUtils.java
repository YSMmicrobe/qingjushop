package com.baizhi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    /**
     * 日期类型转成自负串类型
     * @param date
     * @param patten
     * @return
     */
    public static String date2String(Date date,String patten){
        SimpleDateFormat sdf = new SimpleDateFormat(patten);
        String dateStr = sdf.format(date);
        return dateStr;
    }
    /**
     * 字符串类型转成日期类型
     */
    public static Date string2Date(String str,String patten) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patten);
        Date date = sdf.parse(str);
        return date;
    }

}
