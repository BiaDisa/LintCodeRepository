package test.first;/*
 * Copyright (C) 2006-2012 Tuniu All rights reserved
 * Author: huangkun xieruidong
 * Date: 2012-11-7
 * Description: date utils
 */



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 日期工具类
 */
public class DateUtil {


    /**
     * 1秒钟的毫秒数
     */
    public static final long MILLIS_PER_SECOND = 1000;

    /**
     * 1分钟的毫秒数
     */
    public static final long MILLIS_PER_MINUTE = 60 * MILLIS_PER_SECOND;

    /**
     * 1小时的毫秒数
     */
    public static final long MILLIS_PER_HOUR = 60 * MILLIS_PER_MINUTE;

    /**
     * 1天的毫秒数
     */
    public static final long MILLIS_PER_DAY = 24 * MILLIS_PER_HOUR;

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final String YYYY_MM_DD = "yyyy.MM.dd";

    /**
     * 获取当前月的起始时间，如：2012-09-01 00:00:00.000
     *
     * @return 当前月的起始时间
     */
    public static Date getStartOfMonth() {
        return getStartOfMonth(0);
    }

    /**
     * 获取当前月距amount个月的起始时间，如：2012-09月前一个月（amount = -1）的起始日期：2012-08-01
     * 00:00:00.000
     *
     * @param amount 间隔月份
     * @return 当前月之前amount个月的起始时间
     */
    public static Date getStartOfMonth(int amount) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, amount);
        cal.set(Calendar.HOUR_OF_DAY, cal.getMinimum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getMinimum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getMinimum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * 获取当前月的结束时间，如：2012-09-30 23:59:59.999
     *
     * @return 当前月的结束时间
     */
    public static Date getEndOfMonth() {
        return getEndOfMonth(0);
    }

    /**
     * 获取距当前月amount个月的结束时间，如：2012-09月前一个月（amount = 1）的起始日期：2012-08-31
     * 23:59:59.999
     *
     * @param amount 间隔月份
     * @return 距当前月amount个月的结束时间
     */
    public static Date getEndOfMonth(int amount) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, amount + 1);
        cal.set(Calendar.HOUR_OF_DAY, cal.getMaximum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getMaximum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getMaximum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMaximum(Calendar.MILLISECOND));
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    /**
     * 时间字符串转化为日期类型，格式为yyyy-MM-dd HH:mm:ss
     *
     * @param dateTime 时间字符串，格式为yyyy-MM-dd HH:mm:ss
     * @return Date
     */
    public static Date parseDateTime(String dateTime) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTime);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date parseDate(String dateTime, String format) {
        try {
            return new SimpleDateFormat(format).parse(dateTime);
        } catch (ParseException e) {
            return null;
        }
    }



    /**
     * 时间字符串转化为日期类型，格式为HH:mm
     *
     * @param date 时间字符串，格式为HH:mm
     * @return Date
     */
    public static Date parseTime(String date) {
        try {
            return new SimpleDateFormat("HH:mm").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 格式化日期类型为字符串，格式为yyyy-MM-dd HH:mm:ss
     *
     * @param dateTime 日期类型
     * @return 时间字符串，格式为yyyy-MM-dd HH:mm:ss
     */
    public static String formatDateTime(Date dateTime) {
        if (dateTime == null) {
            return null;
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateTime);
    }


    /**
     * 获取与当前时间的间隔时间
     *
     * @param flag  DAY OR HOUR OR MINUTE
     * @param value
     * @return
     */
    public static String getEndTime(String flag, int value) {
        Calendar calendar = Calendar.getInstance();
        if (flag.equals("DAY")) {
            calendar.add(Calendar.DAY_OF_MONTH, -value);
        } else if (flag.equals("HOUR")) {
            calendar.add(Calendar.HOUR_OF_DAY, -value);
        } else if (flag.equals("MINUTE")) {
            calendar.add(Calendar.MINUTE, -value);
        }
        Date dateTime = calendar.getTime();
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateTime);
    }

    /**
     * 格式化日期类型为字符串，格式为yyyy-MM-dd
     *
     * @param date 日期类型
     * @return 时间字符串，格式为yyyy-MM-dd
     */
    public static String formatDate(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static String formatYear(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat("yyyy").format(date);
    }

    /**
     * 格式化日期类型为字符串，格式为HH:mm
     *
     * @param date 日期类型
     * @return 时间字符串，格式为HH:mm
     */
    public static String formatTime(Date date) {
        if (null == date) {
            return null;
        }

        return new SimpleDateFormat("HH:mm").format(date);
    }


    /**
     * 格式化日期类型为字符串，格式为HH
     *
     * @param date 日期类型
     * @return 时间字符串，格式为HH
     */
    public static String formatHour(Date date) {
        if (null == date) {
            return null;
        }

        return new SimpleDateFormat("HH").format(date);
    }

    /**
     * 格式化日期类型为字符串，格式为HH:mm:ss.SSS
     *
     * @param date 日期类型
     * @return 时间字符串，格式为HH:mm:ss.SSS
     */
    public static String formatTime2(Date date) {
        if (null == date) {
            return null;
        }

        return new SimpleDateFormat("HH:mm:ss.SSS").format(date);
    }

    /**
     * 格式化日期类型为字符串，格式为MM-dd
     *
     * @param date
     * @return
     */
    public static String formateDay(Date date) {
        if (null == date) {
            return null;
        }

        return new SimpleDateFormat("MM-dd").format(date);
    }


    /**
     * @return 当前时间
     */
    public static Date getCurrentTime() {
        return Calendar.getInstance().getTime();
    }

    /**
     * @param dayAmount
     * @return
     */
    public static Date afterNowOfDay(int dayAmount) {
        return addDays(Calendar.getInstance().getTime(), dayAmount);
    }

    /**
     * 获取两个日期之间的天数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static Long getBetweenDays(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return null;
        }
        Long day = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000);
        return day;
    }

    // -----------------------------------------------------------------------

    /**
     * <p>
     * Checks if two date objects are on the same day ignoring time.
     * </p>
     *
     * <p>
     * 28 Mar 2002 13:45 and 28 Mar 2002 06:01 would return true. 28 Mar 2002
     * 13:45 and 12 Mar 2002 13:45 would return false.
     * </p>
     *
     * @param date1 the first date, not altered, not null
     * @param date2 the second date, not altered, not null
     * @return true if they represent the same day
     * @throws IllegalArgumentException if either date is <code>null</code>
     * @since 2.1
     */
    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return isSameDay(cal1, cal2);
    }

    /**
     * <p>
     * Checks if two calendar objects are on the same day ignoring time.
     * </p>
     *
     * <p>
     * 28 Mar 2002 13:45 and 28 Mar 2002 06:01 would return true. 28 Mar 2002
     * 13:45 and 12 Mar 2002 13:45 would return false.
     * </p>
     *
     * @param cal1 the first calendar, not altered, not null
     * @param cal2 the second calendar, not altered, not null
     * @return true if they represent the same day
     * @throws IllegalArgumentException if either calendar is <code>null</code>
     * @since 2.1
     */
    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1
                .get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
    }


    /**
     * Adds a number of months to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date   the date, not null
     * @param amount the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addMonths(Date date, int amount) {
        return add(date, Calendar.MONTH, amount);
    }

    /**
     * Adds a number of days to a date returning a new object. The original date
     * object is unchanged.
     *
     * @param date   the date, not null
     * @param amount the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addDays(Date date, int amount) {
        return add(date, Calendar.DAY_OF_MONTH, amount);
    }

    /**
     * Adds to a date returning a new object. The original date object is
     * unchanged.
     *
     * @param date          the date, not null
     * @param calendarField the calendar field to add to
     * @param amount        the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }

    public static String now() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(Calendar.getInstance().getTime());
    }

    //---------------------------------------------------------------------------------------------------

    /**
     * 加减指定的日期的年份。
     *
     * @param date   --指定的日期
     * @param amount --数量可以为负数
     * @return 计算后的结果
     */
    public static Date addYears(Date date, int amount) {
        return add(date, Calendar.YEAR, amount);
    }

    //---------------------------------------------------------------------------------------------------

    /**
     * 加减指定的日期的小时数
     *
     * @param date   --指定的日期
     * @param amount --加减数量
     * @return 计算后的结果
     */
    public static Date addHours(Date date, int amount) {
        return add(date, Calendar.HOUR_OF_DAY, amount);
    }

    //---------------------------------------------------------------------------------------------------

    /**
     * 加减指定的日期的分钟数
     *
     * @param date   --指定的日期
     * @param amount --加减数量
     * @return 计算后的结果
     */
    public static Date addMinutes(Date date, int amount) {
        return add(date, Calendar.MINUTE, amount);
    }

    //---------------------------------------------------------------------------------------------------

    /**
     * 加减指定的日期的秒数
     *
     * @param date   --指定的日期
     * @param amount --加减数量
     * @return 计算后的结果
     */
    public static Date addSeconds(Date date, int amount) {
        return add(date, Calendar.SECOND, amount);
    }

    //---------------------------------------------------------------------------------------------------

    /**
     * 加减指定的日期的毫秒数
     *
     * @param date   --指定的日期
     * @param amount --加减数量
     * @return 计算后的结果
     */
    public static Date addMilliseconds(Date date, int amount) {
        return add(date, Calendar.MILLISECOND, amount);
    }

    //---------------------------------------------------------------------------------------------------

    /**
     * 设置指定日期重新的年份
     *
     * @param date   --指定的日期
     * @param amount --年份
     * @return 设置后的日期
     */
    public static Date setYears(Date date, int amount) {
        return set(date, Calendar.YEAR, amount);
    }

    //---------------------------------------------------------------------------------------------------

    /**
     * 设置指定日期的月份
     *
     * @param date   --指定的日期
     * @param amount --月份
     * @return 设置后的日期
     */
    public static Date setMonths(Date date, int amount) {
        return set(date, Calendar.MONTH, amount);
    }

    //---------------------------------------------------------------------------------------------------

    /**
     * 设置指定日期的天数
     *
     * @param date   --指定的日期
     * @param amount --天数
     * @return 设置后的日期
     */
    public static Date setDays(Date date, int amount) {
        return set(date, Calendar.DAY_OF_MONTH, amount);
    }

    //---------------------------------------------------------------------------------------------------

    /**
     * 设置指定日期的小时
     *
     * @param date   --指定日期
     * @param amount --小时数
     * @return 设置后的日期
     */
    public static Date setHours(Date date, int amount) {
        return set(date, Calendar.HOUR_OF_DAY, amount);
    }

    //---------------------------------------------------------------------------------------------------

    /**
     * 设置指定日期的分钟数
     *
     * @param date   --指定日期
     * @param amount --分钟数
     * @return 设置后的日期
     */
    public static Date setMinutes(Date date, int amount) {
        return set(date, Calendar.MINUTE, amount);
    }

    //---------------------------------------------------------------------------------------------------

    /**
     * 设置指定日期的秒
     *
     * @param date   --指定日期
     * @param amount --秒
     * @return 设置后的日期
     */
    public static Date setSeconds(Date date, int amount) {
        return set(date, Calendar.SECOND, amount);
    }

    //---------------------------------------------------------------------------------------------------

    /**
     * 设置指定日期的毫秒
     *
     * @param date   --指定日期
     * @param amount --毫秒
     * @return 设置后的日期
     */
    public static Date setMilliSeconds(Date date, int amount) {
        return set(date, Calendar.MILLISECOND, amount);
    }

    //---------------------------------------------------------------------------------------------------

    /**
     * 设置指定日期的各域
     *
     * @param date          --指定日期
     * @param calendarFiled --域包括年、月、日、时、分、秒、毫秒
     * @param amount        --数量
     * @return 设置后日期
     */
    public static Date set(Date date, int calendarFiled, int amount) {
        if (null == date) {
            throw new IllegalArgumentException("The date must not be null");
        } else {

        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(calendarFiled, amount);
        return c.getTime();
    }

    //---------------------------------------------------------------------------------------------------

    /**
     * 把日期转换成日历
     *
     * @param date --日期格式
     * @return 日历格式
     */
    public static Calendar toCalendar(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c;
    }


    //----------------------------------------------------------------------------------------------------

    /**
     * 两个日期相加
     *
     * @param d1 --日期1
     * @param d2 --日期2
     * @return 相加后的日期
     */
    public static Date addTwo(Date d1, Date d2) {
        if (null == d1 || null == d2) {
            return null;
        } else {

        }
        return new Date(d1.getTime() + d2.getTime());
    }

    //-----------------------------------------------------------------------------------------------------

    /**
     * 计算两个日期之间相差的年，不足一年的被舍去，d1和d2都不能为null
     *
     * @param d1 --日期1
     * @param d2 --日期2
     * @return d1和d2相差的年份
     */
    public static int minusToYear(Date d1, Date d2) {
        if (null == d1 || null == d2) {
            throw new IllegalArgumentException("d1和d2都不能为null");
        } else {

        }
        Calendar cl1 = Calendar.getInstance();
        Calendar cl2 = Calendar.getInstance();
        cl1.setTime(d1);
        cl2.setTime(d2);
        return cl1.get(Calendar.YEAR) - cl2.get(Calendar.YEAR);
    }

    //----------------------------------------------------------------------------------------------------

    /**
     * 计算两个日期之间的月份，不足一月的被舍去，d1和d2都不能为null
     *
     * @param d1 --日期1
     * @param d2 --日期2
     * @return d1和d2之间相差月份
     */
    public static int minusToMonth(Date d1, Date d2) {

        if (null == d1 || null == d2) {
            throw new IllegalArgumentException("d1和d2都不能为null");
        } else {

        }
        Calendar cl1 = Calendar.getInstance();
        Calendar cl2 = Calendar.getInstance();
        cl1.setTime(d1);
        cl2.setTime(d2);
        return (cl1.get(Calendar.YEAR) - cl2.get(Calendar.YEAR)) * 12 + cl1.get(Calendar.MONTH) - cl2.get(Calendar.MONTH);
    }
    //----------------------------------------------------------------------------------------------------

    /**
     * 计算两个日期之间的天数，不足一天的被舍去，d1和d2都不能为null
     *
     * @param d1 --日期1
     * @param d2 --日期2
     * @return d1和d2之间相差的天数
     */
    public static int minusToDay(Date d1, Date d2) {

        return (int) (minusToMilliSecond(d1, d2) / MILLIS_PER_DAY);
    }

    //----------------------------------------------------------------------------------------------------

    /**
     * 计算两个日期之间的小时数，不足一小时的被舍去，d1和d2都不能为null
     *
     * @param d1 --日期1
     * @param d2 --日期2
     * @return d1和d2之间相差的小时数
     */
    public static int minusToHours(Date d1, Date d2) {

        return (int) (minusToMilliSecond(d1, d2) / MILLIS_PER_HOUR);
    }
    //----------------------------------------------------------------------------------------------------

    /**
     * 计算两个日期之间的分钟数不足一分钟的被舍去，d1和d2都不能为null
     *
     * @param d1 --日期1
     * @param d2 --日期2
     * @return d1和d2之间相差的分钟数
     */
    public static long minusToMinutes(Date d1, Date d2) {

        return minusToMilliSecond(d1, d2) / MILLIS_PER_MINUTE;
    }

    //----------------------------------------------------------------------------------------------------

    /**
     * 计算两个日期之间的秒数不足以秒的被舍去，d1和d2都不能为null
     *
     * @param d1 --日期1
     * @param d2 --日期2
     * @return d1和d2之间相差的秒数
     */
    public static long minusToSeconds(Date d1, Date d2) {

        return minusToMilliSecond(d1, d2) / MILLIS_PER_SECOND;
    }

    //-----------------------------------------------------------------------------------------------------

    /**
     * 计算两个日期之间的毫秒数，d1和d2都不能为null
     *
     * @param d1 --日期1
     * @param d2 --日期2
     * @return d1和d2之间相差的毫秒数
     */
    public static long minusToMilliSecond(Date d1, Date d2) {
        if (null == d1 || null == d2) {
            throw new IllegalArgumentException("d1和d2都不能为null");
        } else {

        }
        return d1.getTime() - d2.getTime();
    }

    /**
     * 计算两个日期之间的毫秒数，d1和d2都不能为null
     *
     * @param d1 --日期1
     * @param d2 --日期2
     * @return d1和d2之间相差的秒数
     */
    public static long minusToSecond(Date d1, Date d2) {
        if (null == d1 || null == d2) {
            throw new IllegalArgumentException("d1和d2都不能为null");
        } else {

        }
        return (d1.getTime() - d2.getTime()) / 1000;
    }

    /**
     * 将日期数据格式化成指定格式的字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String formatSelfDate(Date date, String format) {
        if (null == date || null == format) {
            return null;
        }
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 获取日期中的天（31）
     *
     * @param date 时间
     * @return 天
     */
    public static int getDate(Date date) {

        if (null == date) {
            return -1;
        }

        Calendar cl = Calendar.getInstance();
        cl.setTime(date);

        return cl.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取日期中的小时（24）
     *
     * @param date 时间
     * @return 小时
     */
    public static int getHour(Date date) {

        if (null == date) {
            return -1;
        }

        Calendar cl = Calendar.getInstance();
        cl.setTime(date);

        return cl.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取时间中的分钟
     *
     * @param date 时间
     * @return 分钟
     */
    public static int getMin(Date date) {
        if (null == date) {
            return -1;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 获取这一天的开始时间
     *
     * @param day 某天
     * @return 某天的开始时间
     */
    public static Date getStartOfDay(Date day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    public static Date getEndOfDay(Date day) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 获取当月的第一天
     */
    public static Date getStartDayOfMonth(Date day) {
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(day);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        return gcLast.getTime();
    }

    /**
     * 获取当月的最后一天
     */
    public static Date getEndDayOfMonth(Date day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        calendar.add(Calendar.MONTH, 1);    //加一个月
        calendar.set(Calendar.DATE, 1);        //设置为该月第一天
        calendar.add(Calendar.DATE, -1);    //再减一天即为上个月最后一天
        return calendar.getTime();
    }

    /**
     * 加day天
     *
     * @param day
     * @return
     */
    public static String getAddDay(int day) {
        String orgDate = null;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, day);
        Date newDate = calendar.getTime();
        orgDate = formatDate(newDate);
        return orgDate;
    }

    /**
     * 获取本周一的日期
     */
    public static Date getStartDayOfWeek(Date day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    /**
     * 获取本周末的日期
     */
    public static Date getEndDayOfWeek(Date day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        cal.add(Calendar.WEEK_OF_MONTH, 1);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return cal.getTime();
    }

    public static int getHourInt(long time) {
        return (int) (time / (60 * 60));
    }

    public static int getMinuteInt(long time) {
        if (time > (60 * 60)) {
            return (int) ((time % (60 * 60)) / (60));
        } else {
            return (int) (time / (60));
        }
    }

    public static int getSecondInt(long time) {
        if (time > (60)) {
            return (int) ((time % (60)));
        } else {
            return (int) (time);
        }
    }

    /**
     * 获取当日是周几
     * 周一 -----周日
     * 1 ----  7
     */

    public static int getNumberOfWeek(Date date) {
        if (date == null) {
            return -1;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        //1-日  2-周一  ......7--周六
        int weekday = c.get(Calendar.DAY_OF_WEEK);
        if (weekday == 1) {
            weekday = 7;
        } else {
            weekday = weekday - 1;
        }
        return weekday;
    }


    /**
     * 获得下次开奖日期
     */
    public static String getNextPrizeDate() {
        Date thisDay = new Date();

        int weekNum = getNumberOfWeek(thisDay);

        if (weekNum == -1) {
            return null;
        }
        Map<Integer, Integer> addMap = new HashMap<>();
        addMap.put(1, 1);
        addMap.put(2, 2);
        addMap.put(3, 1);
        addMap.put(4, 3);
        addMap.put(5, 2);
        addMap.put(6, 1);
        addMap.put(7, 2);

        return new SimpleDateFormat("yyyy-MM-dd").format(addDays(thisDay, addMap.get(weekNum)));
    }

    /**
     * 获取年份
     *
     * @return
     */
    public static String getCurrentYear() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return sdf.format(date);
    }

    /**
     * 获取当天开始时间
     *
     * @return
     */
    public static Date getStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    /**
     * 获取当天结束时间
     *
     * @return
     */
    public static Date getEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    /**
     * yyyy-MM-dd to yyyy/MM/dd
     */

    public static String changeTimeFormat(String date) {
        return date.replace("-", "/");
    }


    /**
     * yyyy/MM/dd to yyyy-MM-dd
     */

    public static String formatTimeChange(String date) {
        return date.replace("/", "-");
    }


    public static String convertFormat(Date date) {
        if (null == date) {
            return null;
        }
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);
    }

    public static Date convert(LocalDate localDate) {
        ZonedDateTime zdt = localDate.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zdt.toInstant());
    }

    /**
     * 判断日期是否是今天
     *
     * @param date
     * @return
     */
    public static boolean isToday(Date date) {
        Calendar current = Calendar.getInstance();

        Calendar today = Calendar.getInstance();
        today.set(Calendar.YEAR, current.get(Calendar.YEAR));
        today.set(Calendar.MONTH, current.get(Calendar.MONTH));
        today.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH));
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);

        Calendar tomorrow = Calendar.getInstance();
        tomorrow.set(Calendar.YEAR, current.get(Calendar.YEAR));
        tomorrow.set(Calendar.MONTH, current.get(Calendar.MONTH));
        tomorrow.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH) + 1);
        tomorrow.set(Calendar.HOUR_OF_DAY, 0);
        tomorrow.set(Calendar.MINUTE, 0);
        tomorrow.set(Calendar.SECOND, 0);
        current.setTime(date);

        return current.after(today) && current.before(tomorrow);
    }

    /*
     * 获取指定天前多少天
     */
    public static String getLastWeekStr(long day) {
        return LocalDateTime.now().plusDays(day).format(DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS));
    }

    /*
     * 获取上周当天23:59:59
     */
    private static String lastMaxWeekStr(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS);
        return dateTimeFormatter.format(localDateTime.with(LocalTime.MAX));
    }


    /*
     *  距离几天前23:59:59
     */
    public static String getMaxWeekStr(long day) {
        return DateUtil.lastMaxWeekStr(DateUtil.convert(LocalDate.now().plusDays(day)));
    }

    /*
     * 获取当前日期
     */
    public static String getCurrentDateStr() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS));
    }

    /*
     *获取年月日
     */
    public static String getYyMmDd(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(YYYY_MM_DD);
        return dateTimeFormatter.format(localDateTime);
    }

    /*
     * 字符串转LocalDateTime
     */
    public static LocalDateTime parseYyMmDdDate(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(YYYY_MM_DD);
        return LocalDateTime.from(
                LocalDate.parse(date, dateTimeFormatter).atStartOfDay());
    }

    /*
     * 获取指定日期00：00：00开始
     */
    private static String getDayMinStr(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS);
        return dateTimeFormatter.format(localDateTime.with(LocalTime.MIN));
    }

    /*
     * 获得距离当前几天,周一00开始
     */
    public static String getWeekMinStr(int day) {
        final Date currentDate = getStartWeekDate(day);
        return getDayMinStr(currentDate);
    }

    /*
     *获取 指定天数周一日期
     */
    private static Date getStartWeekDate(int day) {
        LocalDate now = LocalDate.now();
        LocalDate gapNow = now.minusDays(day);
        int dayWeek = gapNow.getDayOfWeek().getValue();
        //获得开始时间
        LocalDate minNow = gapNow.minusDays(dayWeek - 1);

        ZoneId zone = ZoneId.systemDefault();
        Instant instant = minNow.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    public static void main(String[] args) {

    }
    public static Date parse(String date, String formater) {
        SimpleDateFormat sdf = new SimpleDateFormat(formater);
        Date result = null;

        try {
            result = sdf.parse(date);
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return result;
    }

}
