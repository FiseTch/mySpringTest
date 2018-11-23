package com.fise.util;

import org.joda.time.DateTime;
import org.joda.time.Days;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.Date;

public class MyDateUtils {


    /**
     * @param s
     * @return
     * @throws UnsupportedEncodingException
     * @user: tongchaohua
     * @Title: changeEncode
     * @Description: 防止乱码
     * @return: String
     */
    public static String changeEncode(String s) throws UnsupportedEncodingException {
        return (s == null || s.equals("")) ? null : URLDecoder.decode(s.trim(), "UTF-8");
    }


    /**
     * @param str
     * @param len
     * @return
     * @user: tongchaohua
     * @Title: valueOfString
     * @Description: 给字符串加0
     * @return: String
     */
    private static String valueOfString(String str, int len) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len - str.length(); i++) {
            sb.append("0");
        }
        return (sb.length() == 0) ? (str) : (sb.toString() + str);
    }


    /**
     * 计算给定日期与系统当前日期相差的天数
     *
     * @param time
     * @return
     */
    public static int dayToNow(Long time) {
        DateTime startTime = new DateTime(time);
        DateTime endTime = new DateTime(Calendar.getInstance());
        return Days.daysBetween(startTime, endTime).getDays();
    }

    /**
     * 计算给定日期与系统当前日期相差的天数
     *
     * @param time 转入的日期格式为Date，
     * @return
     */
    public static int dayToNow(Date time) {
        return dayToNow(time.getTime());
    }


    /**
     * @param calendar
     * @return
     * @user: tongchaohua
     * @Title: getTimeString
     * @Description: 将时间化为字母
     * @return: String
     */
    private static String getTimeString(Calendar calendar) {
        StringBuffer sb = new StringBuffer();
        sb.append(String.valueOf(calendar.get(Calendar.YEAR)))
                .append(valueOfString(String.valueOf(calendar.get(Calendar.MONTH) + 1), 2))
                .append(valueOfString(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)), 2))
                .append(valueOfString(String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)), 2))
                .append(valueOfString(String.valueOf(calendar.get(Calendar.MINUTE)), 2))
                .append(valueOfString(String.valueOf(calendar.get(Calendar.SECOND)), 2))
                .append(valueOfString(String.valueOf(calendar.get(Calendar.MILLISECOND)), 3));
        return sb.toString();
    }

}
