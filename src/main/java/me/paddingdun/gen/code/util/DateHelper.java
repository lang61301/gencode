package me.paddingdun.gen.code.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

/**
 * 
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
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
	
	public final static String[] DATE_PATTERN = new String[]{
			DATE_FMT_DEFAULT, 
			DATE_FMT_1, 
			"yyyy/MM/dd"};
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
	
	public static Date parseDate(String str){
		Date result = null;
		try {
			result = DateUtils.parseDate(str, DATE_PATTERN);
		} catch (ParseException e) {
			result = null;
			e.printStackTrace();
		}
		return result;
	}
	
	public static Date now(){
		return new Date();
	}
	
	public static void main(String[] args) {
	}
}
