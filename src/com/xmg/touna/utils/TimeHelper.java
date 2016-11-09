package com.xmg.touna.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TimeHelper {

	public static final String YYYYMMDD = "yyyyMMdd";
	public static final String DD = "dd";
	public static final int ThisWeek =0;
	public static final int NestWeek =1;
	public static final int LastWeek =-1;

	/** 
     * 时间戳转换成日期格式字符串 
     * @param seconds 精确到秒的字符串 
     * @param formatStr 
     * @return 
     */  
    public static String timeStamp2Date(String seconds,String format) {  
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){  
            return "";  
        }  
        if(format == null || format.isEmpty()) format = "yyyy-MM-dd HH:mm:ss";  
        SimpleDateFormat sdf = new SimpleDateFormat(format);  
        return sdf.format(new Date(Long.valueOf(seconds+"000")));  
    }  
    /** 
     * 日期格式字符串转换成时间戳 
     * @param date 字符串日期 
     * @param format 如：yyyy-MM-dd HH:mm:ss 
     * @return 
     */  
    public static String date2TimeStamp(String date_str,String format){  
        try {  
            SimpleDateFormat sdf = new SimpleDateFormat(format);  
            return String.valueOf(sdf.parse(date_str).getTime()/1000);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return "";  
    }  
	
    
    

	/**
	 * 获取当前的年,月,日
	 * 
	 * get current year ,month ,day, according to your ask that you given
	 * request then return your needs times
	 * */
	public static String[] GetDatefromSystem() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date curDate = new Date(System.currentTimeMillis());
		String date = sdf.format(curDate);
		String[] text = date.split("-");
		return text;
	}

	/**
	 * 
	 * return hour,minute,second
	 * 
	 * @return
	 * */
	public static String[] GetCurentTime() {
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");// 设置日期格式
		Date date = new Date(System.currentTimeMillis());
		String string = df.format(date);
		String[] datesss = string.split(":");
		// System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		return datesss;
	}

	/**
	 * all current times
	 * 
	 * year-month-day hour-minute-second
	 * 
	 * @return
	 * */
	public static String[] GetAllCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
		Date curDate = new Date(System.currentTimeMillis());
		String date = sdf.format(curDate);
		String[] text = date.split(":");
		return text;
	}

	/**
	 * 获取系统的时间戳（10位） java中Date类中的getTime()是获取时间戳的，java中生成的时间戳精确到毫秒级别，
	 * 而unix中精确到秒级别，所以通过java生成的时间戳需要除以1000
	 * 
	 * @return
	 */
	public static int getCurrentTime10() {
		return (int) (System.currentTimeMillis() / 1000);
	}
	
	
	/**
	 * 获取周日-日期(20160424):
	 * 
	 * whichWeek=-1 上上周末  ;
	 * 
	 * whichWeek=0 上周末  ;
	 * 
	 * whichWeek=1 本周末  ;
	 * 
	 * @return
	 */
	public static int getWeekSunday(String formatDate,Integer whichWeek) {
		if(whichWeek==null)
			whichWeek=0;
		SimpleDateFormat format = new java.text.SimpleDateFormat(formatDate);
		Calendar c = Calendar.getInstance();
		int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (day_of_week == 0)
			day_of_week = 7;
		c.add(Calendar.DATE, -day_of_week+whichWeek*7);
		String first = format.format(c.getTime());
		return Integer.valueOf(first);
	}

	/**
	 * 获取系统的时间戳（13位）
	 * 
	 * @return 13位的时间戳
	 */
	public static Long getCurrentTime13() {
		return System.currentTimeMillis();
	}

	/**
	 * 通过时间戳的差获取天数
	 * 
	 * @param deltime
	 * @return
	 */
	public static int getDaysByTimeStamp(int deltime) {
		if (deltime > 24 * 60 * 60)
			return (int) (deltime / (24 * 60 * 60));
		return 0;
	}

	/**
	 * 获取当前时间20160316
	 * 
	 * @param formatDate
	 * @return
	 */
	public static int getDataNow(String formatDate) {
		SimpleDateFormat format = new java.text.SimpleDateFormat(formatDate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, 0);
		String first = format.format(calendar.getTime());
		return Integer.valueOf(first);
	}

	/**
	 * 获取当前月份的日期
	 * 
	 * @param formatDate
	 * @return
	 */
	public static int getDataOfTheMonth(String formatDate) {
		SimpleDateFormat format = new java.text.SimpleDateFormat(formatDate);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		String first = format.format(c.getTime());
		return Integer.valueOf(first);
	}

	/**
	 * 获取本月月的第一天days=1
	 * 
	 * @param formatDate
	 * @param days
	 *            1 第一天，20 第20天
	 * @return
	 */
	public static int getDayOfTheMonth(String formatDate, int days) {
		SimpleDateFormat format = new java.text.SimpleDateFormat(formatDate);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, days);// 设置为1号,当前日期既为本月第一天
		String first = format.format(c.getTime());
		return Integer.valueOf(first);
	}

	/**
	 * 获取本月的最后一天
	 * 
	 * @return
	 */
	public static int getLastDayOfTheMonth(String formatDate) {
		SimpleDateFormat format = new java.text.SimpleDateFormat(formatDate);
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		String first = format.format(c.getTime());
		return Integer.valueOf(first);
	}

	/**
	 * 获取上个月的第一天days=1
	 * 
	 * @param formatDate
	 * @param days
	 *            1 第一天 20 第20天
	 * @return
	 */
	public static int getDayOfTheLastMonth(String formatDate, int days) {
		SimpleDateFormat format = new java.text.SimpleDateFormat(formatDate);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -1);// 前一个月
		c.set(Calendar.DAY_OF_MONTH, days);// 月份的第一天1
		String first = format.format(c.getTime());
		return Integer.valueOf(first);
	}

	/**
	 * 获取上个月的最后一天
	 * 
	 * @return
	 */
	public static int getLastDayOfTheLastMonth(String formatDate) {
		SimpleDateFormat format = new java.text.SimpleDateFormat(formatDate);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -1);// 前一个月
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		String first = format.format(c.getTime());
		return Integer.valueOf(first);
	}

	/**
	 * 获取上上个月的最后一天
	 * 
	 * @return
	 */
	public static int getLastDayOfTheLastLastMonth(String formatDate) {
		SimpleDateFormat format = new java.text.SimpleDateFormat(formatDate);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -2);// 前2个月
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		String first = format.format(c.getTime());
		return Integer.valueOf(first);
	}

	/**
	 * 今天是本周的第几天: 7,1,2,3,4,5,6("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六")
	 * 
	 * @return
	 */
	public static int getWeekDayOfWeek() {
		int[] weekDays = { 7, 1, 2, 3, 4, 5, 6 };
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}

	/**
	 * 获取当周的星期一
	 * 
	 * @return
	 */
	public static int getMondayOfWeekDay() {
		int[] weekDays = { 7, 1, 2, 3, 4, 5, 6 };
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}

	/**
	 * 求延迟后的时间=当前时间-延迟时间
	 * 
	 * @param formatDate
	 *            时间格式
	 * @param delayDate
	 *            延迟的天数
	 * @return 延迟后的时间
	 */
	public static int getDelayDateDay(String formatDate, int delayDate) {
		SimpleDateFormat format = new java.text.SimpleDateFormat(formatDate);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, delayDate);
		String currentTime = format.format(c.getTime());
		return Integer.valueOf(currentTime);
	}
	/**
	 * 返回今天日期的整形数字例：20160317
	 * 
	 * @return
	 */
	public static int getIntToday() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		return (Integer.valueOf(dateFormat.format(new Date())));
	}

	/**
	 * 获得当天的下一天Timespan
	 * 
	 * @return
	 */
	public static int nextDayTimeSpan() {
		// 获取下一天的timespan
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date date = calendar.getTime();
		return (int) (date.getTime() / 1000);
	}

	/**
	 * 获得当天加N天--时间戳
	 * 
	 * @return
	 */
	public static int getAddDayTimeSpan(int addDays) {
		// 获取下一天的timespan
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, addDays);
		Date date = calendar.getTime();
		return (int) (date.getTime() / 1000);
	}



	/**
	 * 获得当天加N天--年月日
	 * 
	 * @return
	 */
	public static int getAddDayToday(int addDays) {
		SimpleDateFormat format = new java.text.SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, addDays);
		String first = format.format(calendar.getTime());
		return Integer.valueOf(first);
	}


	/**
	 * 通过时间戳获取时间20160316
	 * 
	 * @param formatDate
	 * @return
	 */
	public static int getDataByTimeStamp(String formatDate,String TimeStamp) {
		 Long timestamp = Long.parseLong(TimeStamp)*1000;    
		  String date = new java.text.SimpleDateFormat(formatDate).format(new java.util.Date(timestamp));    
		return Integer.valueOf(date);
	}
	
	/**
	 * 获取星期一的时间戳
	 * @param whichWeek 0代表本周 ; -1代表上一周
	 * @return
	 */
	public static int getMondayTimeSpan(int whichWeek) {
		// 获取下一天的timespan
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		calendar.add(Calendar.DAY_OF_WEEK, whichWeek*7);
		Date date = calendar.getTime();
		return (int) (date.getTime() / 1000);
	}

}
