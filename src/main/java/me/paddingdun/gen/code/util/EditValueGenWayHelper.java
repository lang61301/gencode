/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.text.MessageFormat;

import org.apache.commons.lang.StringUtils;

import me.paddingdun.gen.code.data.edit.EditValueGenWay;
import me.paddingdun.gen.code.data.edit.EditValueGenWayType;
import me.paddingdun.gen.code.data.table.JspColumn;
import me.paddingdun.gen.code.data.table.TableColumn;

/**
 * @author paddingdun
 *
 * 2016年3月10日
 */
public class EditValueGenWayHelper {
	
	public static String javaCodeEdit(JspColumn jspColumn){
		return javaCode(jspColumn, true);
	}
	
	public static String javaCodeNew(JspColumn jspColumn){
		return javaCode(jspColumn, false);
	}
	
	public static boolean isNotInSetUpdateSql(TableColumn column){
		EditValueGenWay way = EditValueGenWayHelper.fromJson(column.getEditValueGenWayJson());
		if(way != null){
			return way.getEdit() == EditValueGenWayType.nothing;
		}
		return false;
	}
	
	private static String javaCode(JspColumn jspColumn, boolean edit){
		EditValueGenWay way = EditValueGenWayHelper.fromJson(jspColumn.getEditValueGenWayJson());
		if(way != null){
			return EditValueGenWayHelper.javaCode(edit? way.getEdit() : way.getNew1(), jspColumn.getSetMethod());
		}
		return null;
	}
	
	private static EditValueGenWay fromJson(String json){
		EditValueGenWay result = null;
		if(StringUtils.isNotBlank(json))
			result = GsonHelper.create().fromJson(json, EditValueGenWay.class);
		return result;
	}
	
	private static String javaCode(EditValueGenWayType way, String setMethod){
		if( way == EditValueGenWayType.time ){
			return MessageFormat.format("{0}.{1}({2});", "obj", setMethod, "new java.sql.Timestamp(new java.util.Date().getTime())");
		}else if( way == EditValueGenWayType.date ){
			return MessageFormat.format("{0}.{1}({2});", "obj", setMethod, "new java.sql.Date(new java.util.Date().getTime())");
		}else{
			return null;
		}
	}
}