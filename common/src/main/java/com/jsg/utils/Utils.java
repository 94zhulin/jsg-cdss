package com.jsg.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 通用工具类
 *
 * @author weidong
 * @date 2018/7/24
 */
public class Utils {

    private static final Logger logger = LoggerFactory.getLogger(Utils.class);
    /**
     * 地球半径
     */
    private static double EARTH_RADIUS = 6371.393;

    /**
     * 临时手机号
     *
     * @return
     */
    public static String getTem_phone() {
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis + "";
    }

    /**
     * 是否为数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * MD5
     *
     * @param source
     * @return
     */
    public static String md5(String source) {
        String encode = source;
        StringBuilder stringbuilder = new StringBuilder();
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(encode.getBytes());
            byte[] str_encoded = md5.digest();
            for (int i = 0; i < str_encoded.length; i++) {
                if ((str_encoded[i] & 0xff) < 0x10) {
                    stringbuilder.append("0");
                }
                stringbuilder.append(Long.toString(str_encoded[i] & 0xff, 16));
            }
        } catch (Exception e) {
            logger.error("", e);
        }
        return stringbuilder.toString();
    }

    /**
     * 格式化double 为小数两位数
     *
     * @param sum
     * @return
     */
    public static String formatDouble(Double sum) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(sum);
    }

    /**
     * 格式化double 为小数两位数，返回double
     *
     * @param sum
     * @return
     */
    public static Double formatDoubleForDouble(Double sum) {
        DecimalFormat df = new DecimalFormat("0.00");
        return Double.parseDouble(df.format(sum));
    }

    /**
     * 格式化数字，不四舍五入
     *
     * @param sum
     * @return
     */
    public static Double formatDoubleNotFourFive(double sum) {
        BigDecimal b = new BigDecimal(sum);
        double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }

    /**
     * 格式化数字，不四舍五入,不返回小数
     *
     * @param sum
     * @return
     */
    public static Double formatDoubleNotFourFive2(double sum) {
        BigDecimal b = new BigDecimal(sum);
        double f1 = b.setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }

    /**
     * 生成唯一码
     *
     * @return
     */
    public static String getUUID() {
        return java.util.UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * jsp静态化
     *
     * @param sUrl      请求路径
     * @param charset   字符编码
     * @param sSavePath html文件保存路径
     * @param sHtmlFile html文件名
     */
    public static int convert2Html(String sUrl, String charset, String sSavePath, String sHtmlFile) {
        int result = 0;
        try {
            int HttpResult;
            URL url = new URL(sUrl);
            URLConnection urlconn = url.openConnection();
            urlconn.connect(); // 使用 connect 方法建立到远程对象的实际连接
            HttpURLConnection httpconn = (HttpURLConnection) urlconn;
            HttpResult = httpconn.getResponseCode();
            if (HttpResult != HttpURLConnection.HTTP_OK) {

            } else {
                InputStreamReader isr = new InputStreamReader(httpconn.getInputStream(), charset);
                BufferedReader in = new BufferedReader(isr);
                String inputLine;
                if (!sSavePath.endsWith("/")) {
                    sSavePath += "/";
                }
                FileOutputStream fout = new FileOutputStream(sSavePath + sHtmlFile);
                while ((inputLine = in.readLine()) != null) {
                    fout.write((inputLine).getBytes());
                }
                in.close();
                fout.close();
            }
        } catch (Exception e) {
            logger.error("", e);
            result = -1;
        }
        return result;
    }

    /**
     * 获取6位随机数字
     *
     * @return
     */
    public static String getSixRamdomSum() {
        String sum = Double.toString(Math.random() * 900000 + 100000);
        return sum.substring(0, sum.indexOf("."));
    }

    /**
     * 随机20位数字字符串
     *
     * @return
     */
    public static String getRamdomTwentySumStr() {
        return DateUtils.getNowTimeStr() + getSixRamdomSum();
    }

    /**
     * 获取3位随机数字
     *
     * @return
     */
    public static String getThreeRamdomSum() {
        String sum = Double.toString(Math.random() * 900 + 100);
        return sum.substring(0, sum.indexOf("."));
    }

    /**
     * 获取过去多少个月的月份名称
     */
    public static String[] getPreMonths(int monthSum) {
        String[] nextMonths = new String[monthSum];
        for (int i = 1; i < monthSum + 1; i++) {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MONTH, -i);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
            String date = format.format(cal.getTime());
            nextMonths[i - 1] = date;
        }
        return nextMonths;
    }

    /**
     * 获取今天星期几
     *
     * @return
     */
    public static String getTodayWeek() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(System.currentTimeMillis()));
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        return Integer.toString(dayOfWeek);
    }

    /**
     * 某月最后一天
     *
     * @return
     */
    public static String getLastDayOfMonth(String da) {
        String d = null;
        try {
            Date date = new SimpleDateFormat("yyyy-MM").parse(da);
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
     * 获取本周第一天日期
     *
     * @return
     */
    public static String getWeekFirstDay() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        // 获取本周一的日期
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return df.format(cal.getTime());
    }

    /**
     * 获取本周最后一天日期
     *
     * @return
     */
    public static String getWeekLastDay() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        // 增加一个星期，才是我们中国人理解的本周日的日期
        cal.add(Calendar.WEEK_OF_YEAR, 1);
        return df.format(cal.getTime());
    }

    /**
     * 某月第一天
     *
     * @return
     */
    public static String getFirstDayOfMonth(String da) {
        String d = null;
        try {
            Date date = new SimpleDateFormat("yyyy-MM").parse(da);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            d = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        } catch (Exception e) {
            logger.error("", e);
        }
        return d;
    }

    /**
     * 密码是否符合规范（[a-zA-Z\d]{6,20}）
     *
     * @return
     */
    public static boolean isValidPassword(String password) {
        if (null == password) {
            return false;
        }
        return password.matches("^([^\\s'‘’]{6,20})$");
    }

    /**
     * 是否有效手机号码
     *
     * @param mobileNum
     * @return
     */
    public static boolean isMobileNum(String mobileNum) {
        if (null == mobileNum) {
            return false;
        }
        return mobileNum.matches("^((13[0-9])|(14[4,7])|(15[^4,\\D])|(17[6-8])|(18[0-9]))(\\d{8})$");
    }

    /**
     * 是否有效邮箱
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        if (null == email) {
            return false;
        }
        return email.matches("^([a-zA-Z0-9])+([a-zA-Z0-9_.-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$");
    }

    public static long stringToTimeStamp(String str) {
        long ts = 0;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = simpleDateFormat.parse(str);
            ts = date.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ts;

    }

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 计算两个经纬度之间的距离
     *
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return
     */
    public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(
                Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 1000);
        return s;
    }

    /**
     * 按位数截取字符
     */
    public static List<String> getbusString(String data) {
        List<String> param = new ArrayList<String>();

        if (data != null) {
            int length = data.length();
            for (int i = 1; i <= length; i++) {
                String substring = data.substring(0, i);
                param.add(substring);
            }
        }
        return param;
    }

    /**
     * 按位数截 取字符
     */
    public static Map<String, Object> getSearchQueryParam(String data) {
        Map<String, Object> param = new HashMap<String, Object>();
        String hierarchy = "fs_chr";
        if (data != null) {
            int length = data.length();
            for (int i = 1; i <= length; i++) {
                String substring = data.substring(0, i);
                param.put(hierarchy + i, substring);

            }
        }
        return param;
    }

    /**
     * 时间毫秒值.除以一千
     */

    public static Long currentTimeM() {

        return System.currentTimeMillis() / 1000;
    }

    /**
     * 获取今天零点零分零秒的时间戳（单位：秒）
     *
     * @return
     */
    public static Long getZeroClockTimeStamp() {
        // 当前时间毫秒数
        long current = System.currentTimeMillis();
        // 今天零点零分零秒的毫秒数
        long zero = current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();
        return zero / 1000;
    }

    /**
     * 根据用户生日计算年龄
     */
    public static int getAgeByBirthday(String birthday) {
        int age = 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(birthday);
            Calendar cal = Calendar.getInstance();
            if (cal.before(birthday)) {
                throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
            }
            int yearNow = cal.get(Calendar.YEAR);
            int monthNow = cal.get(Calendar.MONTH) + 1;
            int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

            cal.setTime(date);
            int yearBirth = cal.get(Calendar.YEAR);
            int monthBirth = cal.get(Calendar.MONTH) + 1;
            int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

            age = yearNow - yearBirth;

            if (monthNow <= monthBirth) {
                if (monthNow == monthBirth) {
                    if (dayOfMonthNow < dayOfMonthBirth) {
                        age--;
                    }
                } else {
                    age--;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return age;
    }

}
