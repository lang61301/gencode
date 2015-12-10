package me.paddingdun.gen.code.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import com.mysql.jdbc.util.TimezoneDump;

/**
 * 
 * @author paddingdun
 *
 * 2015年10月28日
 */
public class DateHelper {

	/**
	 * default date format: year-month-day hour:minute:second
	 * 默认日期格式(日期和时间);
	 */
	public final static String DATE_FMT_DEFAULT = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * date format1;
	 * 日期格式;
	 */
	public final static String DATE_FMT_1 = "yyyy-MM-dd";
	
	
	/**
	 * format the date to special str;
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String format(Date date, String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	public static Date now(){
		return new Date();
	}
	
	public static void main(String[] args) {
	}
}
