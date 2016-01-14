/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.text.MessageFormat;

import org.apache.commons.lang.StringUtils;

import me.paddingdun.gen.code.data.jsp.Render;
import me.paddingdun.gen.code.data.jsp.RenderWayType;
import me.paddingdun.gen.code.data.table.JspColumn;
import me.paddingdun.gen.code.exception.BusinessException;

/**
 * 
 * @author paddingdun
 *
 * 2016年1月13日
 */
public class RenderHelper {
	
	public static String list(String keyName, String defaultContent, RenderWayType rwt, String customer){
		String render = " {\"data\":" + keyName + ",\r\n";
		String dc = "";
		if(StringUtils.isNotBlank(defaultContent)){
			dc = defaultContent.trim();
		}
		render += "\"defaultContent\":\"" + dc + "\"";
		
		String cu = "render\":function( data, type, row, meta ){\r\n" + 
				"	return data;\r\n" + 
				"}";
		if(StringUtils.isNotBlank(customer)){
			cu = customer.trim();
		}
		
		switch (rwt) {
		case list_text:

			break;
		case list_number:

			break;
		case list_checkbox:
			render += ",\"render\":function( data, type, row, meta ){\r\n" + 
					"	return \"<input type='checkbox' class='list_checkbox' value='\" + data + \"'>\";\r\n" + 
					"}";
			break;
		case list_customer:
			render += "," + cu;
			break;
		default:
			throw new BusinessException("list:do not have implement RenderWayType:" + rwt);
		}
		
		render += "}";
		
		return render;
	}
	
	public static String edit(String keyName, String title, RenderWayType rwt){
		String render = JspSnippetHelper.getSnippet(RenderWayType.edit_input.name());
		
		switch (rwt) {
		case edit_input:
			render = MessageFormat.format(render, keyName, title);
			break;
		case edit_hidden:
			render = MessageFormat.format(JspSnippetHelper.getSnippet(RenderWayType.edit_hidden.name()), keyName);
			break;
		case edit_checkbox:
			render = MessageFormat.format(JspSnippetHelper.getSnippet(RenderWayType.edit_checkbox.name()), keyName, title);
			break;
		case edit_datepicker:

			break;
		case edit_dropdownlist:

			break;
		default:
			throw new BusinessException("edit:do not have implement RenderWayType:" + rwt);
		}
		return render;
	}
	
	public static String query(String keyName, RenderWayType rwt){
		String render = "";
		
		switch (rwt) {
		case query_input:

			break;
		case query_checkbox:

			break;
		case query_datepicker:

			break;
		case query_dropdownlist:

			break;
		default:
			throw new BusinessException("query:do not have implement RenderWayType:" + rwt);
		}
		return render;
	}

	
	private static String keyName(JspColumn column, Integer sqlMapMarkUse){
		return Integer.valueOf("1").equals(sqlMapMarkUse) ? column.getPropertyName() : column.getColumnName();
	}
	
	public static Render createListRender(JspColumn column, Integer sqlMapMarkUse, boolean show){
		String keyName = keyName(column, sqlMapMarkUse);
		RenderWayType rwt =  RenderWayType.parse(column.getListRenderWay());
		Render render = new Render();
		render.setTitle(column.getColumnCommon());
		render.setShow(show);
		if(RenderWayType.list_default == rwt){
			if(column.isPrimary()){
				rwt = RenderWayType.list_checkbox;
				render.setTitle("");
			}else{
				rwt = RenderWayType.list_text;
			}
		}
		render.setRender(list(keyName, "", rwt, ""));
		return render;
	}
	
	public static Render createQueryRender(JspColumn column, Integer sqlMapMarkUse, boolean show){
		return null;
	}
	
	public static Render createEditRender(JspColumn column, Integer sqlMapMarkUse, boolean show){
		String keyName = keyName(column, sqlMapMarkUse);
		RenderWayType rwt =  RenderWayType.parse(column.getEditRenderWay());
		Render render = new Render();
		render.setTitle(column.getColumnCommon());
		render.setShow(show);
		if(RenderWayType.edit_default == rwt){
			if(column.isPrimary()){
				rwt = RenderWayType.edit_hidden;
			}else{
				rwt = RenderWayType.edit_input;
			}
		}
		render.setRender(edit(keyName, render.getTitle(), rwt));
		return render;
	}
	
}
