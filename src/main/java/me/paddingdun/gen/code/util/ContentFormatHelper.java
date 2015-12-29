/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.io.StringReader;

import net.barenca.jastyle.ASFormatter;
import net.barenca.jastyle.FormatterHelper;

/**
 * @author paddingdun
 *
 * 2015年12月29日
 */
public class ContentFormatHelper {
	
	/**
	 * 格式化java文件内容;
	 * @param raw
	 * @return
	 */
	public static String formatJava(String raw){
		ASFormatter formatter = new ASFormatter();
    	formatter.setJavaStyle();
    	String af = FormatterHelper.format(new StringReader(raw), formatter);
    	return af;
	}

}
