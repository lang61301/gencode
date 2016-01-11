/**
 * 
 */
package me.paddingdun.gen.code.util;

import org.apache.commons.lang.StringUtils;

/**
 * 工具类;
 * @author paddingdun
 *
 * 2016年1月11日
 */
public class DataTableColumnHelper {
	
	static enum ListColumnType{
		text,
		checkbox,
		number,
		
		/**
		 * 自定义;
		 */
		customer
	}
	
	public static String listCheckbox(String keyName){
		return list(keyName, null, ListColumnType.checkbox, null);
	}
	
	public static String listText(String keyName){
		return list(keyName, null, ListColumnType.text, null);
	}
	
	public static String list(String keyName, String defaultContent, ListColumnType lct, String customer){
		String render = " \"data\":" + keyName + ",\r\n";
		String dc = "";
		if(StringUtils.isNotBlank(defaultContent)){
			dc = defaultContent.trim();
		}
		render += "\"defaultContent\":\"" + dc + "\"";
		
		if(lct == ListColumnType.text){
			
		}else if(lct == ListColumnType.number){
			
		}else if(lct == ListColumnType.checkbox){
			render += ",\"render\":function( data, type, row, meta ){\r\n" + 
					"	return \"<input type='checkbox' class='list_checkbox' value='\" + data + \"'>\"\r\n" + 
					"}";
		}else if(lct == ListColumnType.customer){
			render += "," + customer;
		}
		return render;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
