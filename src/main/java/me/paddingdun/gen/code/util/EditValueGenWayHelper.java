/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.text.MessageFormat;

import org.apache.commons.lang.StringUtils;

import com.google.gson.Gson;

import me.paddingdun.gen.code.data.edit.Datasource;
import me.paddingdun.gen.code.data.edit.EditValueGenWay;
import me.paddingdun.gen.code.data.edit.EditValueGenWayType;
import me.paddingdun.gen.code.data.edit.EditValueShowWay;
import me.paddingdun.gen.code.data.jsp.RenderWayType;
import me.paddingdun.gen.code.data.table2.TableColumn;
import me.paddingdun.gen.code.exception.BusinessException;

/**
 * 
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
 */
public class EditValueGenWayHelper {
	
	public static String javaCodeEdit(TableColumn tableColumn){
		return javaCode(tableColumn, true);
	}
	
	public static String javaCodeNew(TableColumn tableColumn){
		return javaCode(tableColumn, false);
	}
	
	/**
	 * 是否需要存在在update sql中;
	 * @param editValueGenWayJson
	 * @return
	 */
	public static boolean isNotInSetUpdateSql(String editValueGenWayJson){
		EditValueGenWay way = EditValueGenWayHelper.fromJson(editValueGenWayJson);
		if(way != null){
			return way.getEdit() == EditValueGenWayType.nothing;
		}
		return false;
	}
	
	private static String javaCode(TableColumn tc, boolean edit){
		EditValueGenWay way = EditValueGenWayHelper.fromJson(tc.getEditValueGenWayJson());
		if(way != null){
			return EditValueGenWayHelper.javaCode(edit? way.getEdit() : way.getNew1(), tc.getSetMethod());
		}
		return null;
	}
	
	private static EditValueGenWay fromJson(String json){
		EditValueGenWay result = null;
		if(StringUtils.isNotBlank(json))
			result = GsonHelper.create().fromJson(json, EditValueGenWay.class);
		return result;
	}
	
	private static EditValueShowWay fromJson2(String json){
		EditValueShowWay result = null;
		if(StringUtils.isNotBlank(json))
			result = GsonHelper.create().fromJson(json, EditValueShowWay.class);
		return result;
	}
	
	public static String toEditValueShowWayJson(Integer value){
		RenderWayType rwt = RenderWayType.parse(value);
		Gson gson = GsonHelper.create(false, true, true);
		//编辑显示;
		if("edit".equalsIgnoreCase(rwt.getCategory())){
			EditValueShowWay evsw = new EditValueShowWay();
			evsw.setCategory(rwt.getTitle());
			
			switch (rwt) {
			case edit_default:
				break;
			case edit_input:
				break;
			case edit_hidden:
				break;
			case edit_checkbox:
				break;
			case edit_datepicker:
				evsw.setHtml("<input type=\"text\" readOnly class=\"form-control\" id=\"{0}\" name=\"{0}\" onClick=\"WdatePicker('{'maxDate:''#F'{'$dp.$D(\\''{0}\\'')}''})\">");
				break;
			case edit_dropdownlist:
				Datasource ds = new Datasource();
				ds.setVarName("请填写javascript变量名称");
				evsw.setDataSource(ds);
				break;
			default:
				throw new BusinessException("edit:do not have implement RenderWayType:" + rwt);
			}
			
			return gson.toJson(evsw);
		
		//列表;
		}else if("list".equalsIgnoreCase(rwt.getCategory())){
			
		//查询;
		}else if("query".equalsIgnoreCase(rwt.getCategory())){
			
		}
		return null;
	}
	
	private static String javaCode(EditValueGenWayType way, String setMethod){
		if( way == EditValueGenWayType.time ){
			return MessageFormat.format("{0}.{1}({2});", "obj", setMethod, "new java.sql.Timestamp(new java.util.Date().getTime())");
		}else if( way == EditValueGenWayType.date ){
			return MessageFormat.format("{0}.{1}({2});", "obj", setMethod, "new java.sql.Date(new java.util.Date().getTime())");
		}else if( way == EditValueGenWayType.uuid ){
			return MessageFormat.format("{0}.{1}({2});", "obj", setMethod, "java.util.UUID.randomUUID().toString()");
		}else{
			return null;
		}
	}
}
