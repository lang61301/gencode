/**
 * 
 */
package me.paddingdun.gen.code.data.jsp;

import me.paddingdun.gen.code.exception.BusinessException;

/**
 * @author paddingdun
 *
 * 2016年1月13日
 */
public enum RenderWayType {

	query_default(1000, "query", "default"),
	query_input(1001, "query", "input"),
	query_dropdownlist(1002, "query", "dropdownlist"),
	query_datepicker(1003, "query", "datepicker"),
	query_checkbox(1004, "query", "checkbox"),
	
	
	list_default(2000, "list", "default"),
	list_text(2001, "list", "text"),
	list_checkbox(2002, "list", "checkbox"),
	list_number(2003, "list", "number"),
	list_customer(2004, "list", "customer"),
	
	edit_default(3000, "edit", "default"),
	edit_input(3001, "edit", "input"),
	edit_dropdownlist(3002, "edit", "dropdownlist"),
	edit_datepicker(3003, "edit", "datepicker"),
	edit_checkbox(3004, "edit", "checkbox"),
	edit_hidden(3005, "edit", "hidden");
	
	private int type;
	private String category;
	private String title;
	private RenderWayType(int type, String category, String title){
		this.type = type;
		this.category = category;
		this.title = title;
	}
	public int getType() {
		return type;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getCategory(){
		return category;
	}
	
	public static RenderWayType parse(int type){
		for (RenderWayType rwt : RenderWayType.values()) {
			if(rwt.getType() == type)
				return rwt;
		}
		throw new BusinessException("can't parse RenderWayType[" + type + "]");
	}
}
