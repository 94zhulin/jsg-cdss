package com.jsg.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Stream;

public class DateUtils {
    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);

    /**
     * 获取当前时间，精确到微秒
     *
     * @return
     */
    public static String getNowTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        return df.format(new Date());
    }

    /**
     * 获取当前时间之前或之后几个小时minute
     *
     * @param hour
     * @return
     */
    public static String getTimeByHour(int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, hour);
        return new SimpleDateFormat("yyyy-MM-dd HH").format(calendar.getTime());
    }

    /**
     * 获取某天的下几个月的某天
     *
     * @param date
     * @param monthSum
     * @return
     */
    public static String getNextMonthCurrentDay2(String date, int monthSum) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(sdf.parse(date));
            // 取得上一个时间
            calendar.set(Calendar.MONDAY, calendar.get(Calendar.MONDAY) + monthSum);
            // 取得下一个月的当天
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH));
        } catch (Exception e) {
            logger.error("", e);
        }
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取当前日期前几个小时后的字符串
     *
     * @return
     */
    public static String getNowTimeNextHourStr(String date, int hour) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(sdf.parse(date));
            calendar.add(Calendar.HOUR, hour);
        } catch (Exception e) {
            logger.error("", e);
        }
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取当前日期前几个天后的字符串
     *
     * @return
     */
    public static String getNowTimeNextDayStr(String date, int DATE) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(sdf.parse(date));
            calendar.add(Calendar.DATE, DATE);
        } catch (Exception e) {
            logger.error("", e);
        }
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取当前时间若干天前或若干天后的时间时间戳
     *
     * @param day
     * @return
     */
    public static Long getDayStamp(Integer day) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, day);
        Date dayStamp = calendar.getTime();
        return dayStamp.getTime() / 1000;
    }

    /**
     * 获取当前时间之前或之后几分钟 minute
     *
     * @param minute
     * @return
     */
    public static String getTimeByMinute(int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, minute);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(calendar.getTime());
    }

    /**
     * 获取当前时间，精确到秒
     *
     * @return
     */
    public static String getNowTimeForSeconds() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    /**
     * 获取当前时间字符串
     *
     * @return
     */
    public static String getNowTimeStr() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return df.format(new Date());
    }

    /**
     * 获取当前时间字符串
     *
     * @return
     */
    public static String getNowTimeStr_2(Long time) {
        Long timestamp = Long.valueOf(time * 1000);
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ", Locale.CHINA).format(new Date(timestamp));
        return date;
    }

    /**
     * 获取当前时间字符串，精确到秒
     *
     * @return
     */
    public static String getNowTimeStrForSeconds() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(new Date());
    }

    /**
     * 获取当前日期字符串
     *
     * @return
     */
    public static String getNowDateStr() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(new Date());
    }

    /**
     * 获取当前日期前几个月字符串
     *
     * @return
     */
    public static String getNowMothNextStr(int monthSum) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        Date curDate = new Date();
        calendar.setTime(curDate);
        // 取得上一个时间
        calendar.set(Calendar.MONTH, calendar.get(calendar.MONTH) + monthSum);

        return sdf.format(calendar.getTime());
    }

    /**
     * 获取当前日期字符串2
     *
     * @return
     */
    public static String getNowDateStr2() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }

    /**
     * 获取当前日期字符串3
     *
     * @return
     */
    public static String getNowDateStr3() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
        return df.format(new Date());
    }

    /**
     * 日期格式化
     *
     * @param str
     * @return yyyyMMdd
     */
    public static String dateFormat(String str) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date d = null;
        try {
            d = df.parse(str);
        } catch (Exception e) {
            logger.error("", e);
        }
        return df.format(d);
    }

    /**
     * 获取当前时间戳
     *
     * @return
     */
    public static long getTimestamp() {
        long timstamp = 0;
        try {
            timstamp = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").parse(getNowTime()).getTime() / 1000;
        } catch (Exception e) {
            logger.error("", e);
        }
        return timstamp;
    }

    /**
     * 获取当前时间戳(秒）
     *
     * @return
     */
    public static long getTimestamp(String data) {
        long timstamp = 0;
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = df.parse(data);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            timstamp = cal.getTimeInMillis();
        } catch (Exception e) {
            logger.error("", e);
        }
        return timstamp / 1000;
    }

    /**
     * 获取当前时间戳(毫秒）
     *
     * @return
     */
    public static long getTimestampInMillis(String data) {
        long timstamp = 0;
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = df.parse(data);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            timstamp = cal.getTimeInMillis();
        } catch (Exception e) {
            logger.error("", e);
        }
        return timstamp;
    }

    /**
     * 获取从今天开始到下几个月的下一天
     *
     * @param monthSum 取下几个月
     * @return
     */
    public static String getNextMonthNextDay(int monthSum) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date curDate = new Date();
        calendar.setTime(curDate);
        // 取得现在时间
        // System.out.println(sdf.format(curDate));
        // 取得上一个时间
        calendar.set(Calendar.MONDAY, calendar.get(Calendar.MONDAY) + monthSum);
        // 取得下一个月的下一天
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取某天的下个月的下一天
     *
     * @param monthSum
     * @return
     */
    public static String getDayNextMonthNextDay(String date, int monthSum) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(sdf.parse(date));
            // 取得上一个时间
            calendar.set(Calendar.MONDAY, calendar.get(Calendar.MONDAY) + monthSum);
            // 取得下一个月的下一天
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
        } catch (Exception e) {
            logger.error("", e);
        }
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取某天的下几个月的某天
     *
     * @param date
     * @param monthSum
     * @return
     */
    public static String getNextMonthCurrentDay(String date, int monthSum) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(sdf.parse(date));
            // 取得上一个时间
            calendar.set(Calendar.MONDAY, calendar.get(Calendar.MONDAY) + monthSum);
            // 取得下一个月的当天
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH));
        } catch (Exception e) {
            logger.error("", e);
        }
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取从某天开始到下几天
     *
     * @param daySum
     * @return
     */
    public static String getDayNextDay(String date, int daySum) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        try {
            // Date curDate = new Date();
            calendar.setTime(sdf.parse(date));
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + daySum);
        } catch (Exception e) {
            logger.error("", e);
        }

        return sdf.format(calendar.getTime());
    }

    /**
     * 获取从某天开始到下几天
     *
     * @param daySum
     * @return
     */
    public static String getDayNextDay2(String date, int daySum) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(sdf.parse(date));
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + daySum);
        } catch (Exception e) {
            logger.error("", e);
        }

        return sdf.format(calendar.getTime());
    }

    /**
     * 获取从某天开始到下几天
     *
     * @param daySum
     * @return
     */
    public static String getDayNextDay3(String date, int daySum) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(sdf.parse(date));
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + daySum);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sdf.format(calendar.getTime());
    }

    /**
     * 获取从今天开始到下一天
     *
     * @param daySum
     * @return
     */
    public static String getNextDay(int daySum) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date curDate = new Date();
        calendar.setTime(curDate);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + daySum);
        return sdf.format(calendar.getTime());
    }

    public static String addPoint(String str) {
        String a = str;
        if (str.substring(str.lastIndexOf(".") + 1, str.length()).length() == 1) {
            a = str + "0";
        }
        return a;
    }

    /**
     * 获取两日期的相隔天数
     *
     * @param start yyyy-MM-dd
     * @param end   yyyy-MM-dd
     * @return
     */
    public static Long getDaysBetween(String start, String end) {
        long betweenDate = 0;
        try {
            java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
            java.util.Date startDate = df.parse(start);
            java.util.Date endDate = df.parse(end);
            betweenDate = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000);
        } catch (Exception e) {
            logger.error("", e);
        }
        return betweenDate;
    }

    /**
     * 获取两日期相隔月数
     *
     * @param begin
     * @param end
     * @return
     */
    public static int getDiffer(String begin, String end) {
        int difMonth = 0;
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date beginDate = df.parse(begin);
            Date endDate = df.parse(end);
            int beginYear = beginDate.getYear();
            int beginMonth = beginDate.getMonth();
            int endYear = endDate.getYear();
            int endMonth = endDate.getMonth();
            difMonth = (endYear - beginYear) * 12 + (endMonth - beginMonth);
        } catch (Exception e) {
            logger.error("", e);
        }
        return difMonth;
    }

    /**
     * 获取某日期的最后一天日期
     *
     * @param invoiceMonth 格式：201108
     * @return
     */
    public static String getInvoiceMonth(String invoiceMonth) {
        // invoiceMonth 的格式为 201108
        String str = "";
        try {
            String year = invoiceMonth.substring(0, 4);
            String month = invoiceMonth.substring(4, invoiceMonth.length());
            Calendar date = Calendar.getInstance();
            int yeari = Integer.parseInt(year);
            int monthi = Integer.parseInt(month);
            date.set(yeari, monthi - 1, 1);
            int maxDayOfMonth = date.getActualMaximum(Calendar.DAY_OF_MONTH);
            str = year + "-" + monthi + "-" + maxDayOfMonth;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 当月第一天
     *
     * @return
     */
    public static String getFirstDay() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date theDate = calendar.getTime();
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first = df.format(gcLast.getTime());
        return day_first;
    }

    /**
     * 当月最后一天
     *
     * @return
     */
    public static String lastDayOfMonth(String da) {
        String d = null;
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(da);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            cal.roll(Calendar.DAY_OF_MONTH, -1);
            d = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        } catch (Exception e) {
            logger.error("", e);
        }
        return d;
    }

    /**
     * 两日期时间相差的秒数
     *
     * @param start
     * @param end
     * @return
     */
    public static Long getDateBetweenSecond(String start, String end) {
        long betweenDate = 0;
        try {
            java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date startDate = df.parse(start);
            java.util.Date endDate = df.parse(end);
            betweenDate = (endDate.getTime() - startDate.getTime()) / 1000;
        } catch (Exception e) {
            logger.error("", e);
        }
        return betweenDate;
    }

    /**
     * 获取当前季度数
     *
     * @return
     */
    public static Integer getCurrentQuarter() {
        Calendar calendar = Calendar.getInstance();
        Date curDate = new Date();
        calendar.setTime(curDate);
        int month = calendar.get(calendar.MONTH) + 1;
        if (month >= 1 && month < 4)
            return 1;
        else if (month >= 4 && month < 7)
            return 2;
        else if (month >= 7 && month < 10)
            return 3;
        else if (month >= 10 && month < 13)
            return 4;
        else
            return 0;
    }

    /**
     * 获取当前季年份
     *
     * @return
     */
    public static Integer getCurrentYear() {
        Calendar calendar = Calendar.getInstance();
        Date curDate = new Date();
        calendar.setTime(curDate);
        return calendar.get(calendar.YEAR);
    }


    public static List<String> getBetweenDate(String start, String end) {
        List<String> list = new ArrayList<>();
        LocalDate startDate = null;
        LocalDate endDate = null;
        try {
            startDate = LocalDate.parse(start);
            endDate = LocalDate.parse(end);
        } catch (Exception e) {
            throw new RuntimeException("日期格式不正确。（日期示例：2019-12-26）");
        }

        if (start.equals(end)) {
            list.add(start);
            return list;
        }
        long distance = ChronoUnit.DAYS.between(startDate, endDate);
        if (distance < 1) {
            return list;
        }
        Stream.iterate(startDate, d -> {
            return d.plusDays(1);
        }).limit(distance + 1).forEach(f -> {
            list.add(f.toString());
        });
        return list;
    }

    /**
     *  
     * 字符串转换成日期 
     *
     * @param str 
     * @return date 
     */
    public static Date strToDate(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    public static void main(String[] args) {
        System.out.println(getCurrentYear());
    }
}
