/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import me.paddingdun.gen.code.IConsant;

/**
 * 路径工具类;
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
 */
public class PathHelper {

	/**
	 * 
	 * @param assembly
	 * @return
	 */
	public static String concatPackageName(String ... assembly){
		return concat(IConsant.PACKAGE_SEPARATE, assembly);
	}
	
	/**
	 * 拼接url映射路径;
	 * @param assembly
	 * @return
	 */
	public static String concatMappingPath(String ... assembly){
		List<String> result = new ArrayList<String>();
		if(assembly.length == 1){
			if(IConsant.URL_PATH_SEPARATE.equals(assembly[0].trim())){
				return IConsant.URL_PATH_SEPARATE;
			}
		}
		for (String s : assembly) {
			if(StringUtils.isNotBlank(s)){
				String[] tmp = s.trim().split(Pattern.quote(IConsant.URL_PATH_SEPARATE));
				for (String s2 : tmp) {
					if(StringUtils.isNotBlank(s2)){
						result.add(s2.trim());
					}
				}
			}
		}
		String rtn = StringUtils.EMPTY;
		String tmp = concat(IConsant.URL_PATH_SEPARATE, result.toArray(new String[0]));
		if(StringUtils.isNotBlank(tmp)){
			rtn = IConsant.URL_PATH_SEPARATE + tmp;
		}
		return rtn;
	}
	
	public static String concatJspMiddlePath(String ... assembly){
		return concat(IConsant.URL_PATH_SEPARATE, assembly);
	}
	
	/**
	 * 获取包名最后一个;
	 * @param packageName
	 * @return
	 */
	public static String lastPackageName(String packageName){
		if(StringUtils.isBlank(packageName)){
			return StringUtils.EMPTY;
		}
		String[] str = packageName.trim().split(Pattern.quote(IConsant.PACKAGE_SEPARATE));
		return str[str.length - 1].trim();
	}

	/**
	 * 拼接字符串, null或者blank,将会跳过;
	 * @param separateString
	 * @param assembly
	 * @return
	 */
	public static String concat(String separateString, String ... assembly){
		StringBuilder sb = new StringBuilder();
		sb.setLength(0);
		int i = 0;
		for (String s : assembly) {
			if(StringUtils.isNotBlank(s)){
				if(i > 0)sb.append(separateString);
				sb.append(s.trim());
				i++;
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
	}
}
