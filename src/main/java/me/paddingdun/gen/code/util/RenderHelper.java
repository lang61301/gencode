/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import me.paddingdun.gen.code.data.jsp.Render;
import me.paddingdun.gen.code.data.jsp.RenderWayType;
import me.paddingdun.gen.code.data.table2.ListColumn;
import me.paddingdun.gen.code.data.table2.QueryColumn;
import me.paddingdun.gen.code.data.table2.TableColumn;
import me.paddingdun.gen.code.exception.BusinessException;
import me.paddingdun.gen.code.gui.model.TableViewModel;

/**
 * 
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
 */
public class RenderHelper {
	
	public static String list(String keyName, String title, RenderWayType rwt, String customer, String groupCheckboxClassName){
		String t = "";
		if(StringUtils.isNotBlank(title)){
			t = title.trim();
		}
		String render = JspSnippetHelper.getSnippet("list_text", keyName, t);
		switch (rwt) {
		case list_text:

			break;
		case list_number:

			break;
		case list_checkbox:
			render = JspSnippetHelper.getSnippet("list_checkbox", keyName, groupCheckboxClassName);
			break;
		case list_customer:
			String cu = JspSnippetHelper.getSnippet("list_snippet_default_customer");
			if(StringUtils.isNotBlank(customer)){
				cu = customer.trim();
			}
			cu = "," + cu;
			render = JspSnippetHelper.getSnippet("list_customer", keyName, t, cu);
			break;
		default:
			throw new BusinessException("list:do not have implement RenderWayType:" + rwt);
		}
		return render;
	}
	
	public static String edit(String keyName, String title, RenderWayType rwt){
		//增加一个占位符,为以后增加easyui validatebox 验证字符串;
		String mark = "{0}";
		String render = JspSnippetHelper.getSnippet(RenderWayType.edit_input.name(), keyName, title, mark);
		
		switch (rwt) {
		case edit_input:
			break;
		case edit_hidden:
			render = JspSnippetHelper.getSnippet(RenderWayType.edit_hidden.name(), keyName);
			break;
		case edit_checkbox:
			render = JspSnippetHelper.getSnippet(RenderWayType.edit_checkbox.name(), keyName, title, mark);
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
	
	public static String query(String keyName, String title, RenderWayType rwt, int colWidth){
		String render = JspSnippetHelper.getSnippet("query_input", title, colWidth, keyName);
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

	
	private static String keyName(TableColumn column){
		return column.getPropertyName();
	}
	
	/**
	 * 别名为key;
	 * @param column
	 * @return
	 */
	private static String keyName(ListColumn column){
		return column.getColumnAlias();
	}
	
	private static String keyName(QueryColumn column){
		return column.getPropertyName();
	}
	
	/**
	 * 列表render入口;
	 * @param model
	 * @param column
	 * @param sqlMapMarkUse
	 * @param show
	 * @return
	 */
	public static Render createListRender(TableViewModel model, ListColumn column, boolean show){
		String keyName = keyName(column);
		RenderWayType rwt =  RenderWayType.parse(column.getListRenderWay());
		Render render = new Render();
		render.setTitle(column.getListTitle());
		render.setShow(show);
		if(RenderWayType.list_default == rwt){
//			if(column.isPrimary()){
//				rwt = RenderWayType.list_checkbox;
//				render.setTitle(JspSnippetHelper.getSnippet("list_snippet_checkbox_title", model.getHeadGroupCheckboxClassName()));
//			}else{
//				rwt = RenderWayType.list_text;
//			}
			rwt = RenderWayType.list_text;
		}
		render.setRender(list(keyName, column.getListTitle(), rwt, "", model.getGroupCheckboxClassName()));
		return render;
	}
	
	/**
	 * 2016-03-08 新增;
	 * 查询render入口;
	 * @param column
	 * @param sqlMapMarkUse
	 * @param colWidth
	 * @param queryRenderWay
	 * @return
	 */
	private static Render createQueryRender( QueryColumn column, int colWidth, int queryRenderWay){
		String keyName = keyName(column);
		RenderWayType rwt =  RenderWayType.parse(queryRenderWay);
		Render render = new Render();
		render.setTitle(column.getTitle());
		render.setShow(true);
		if(RenderWayType.query_default == rwt){
			rwt = RenderWayType.query_input;
		}
		render.setRender(query(keyName, render.getTitle(), rwt, colWidth));
		return render;
	}
	
	/**
	 * 操作Render;
	 * @param column
	 * @param show
	 * @return
	 */
	public static Render createListOperateRender(ListColumn column, boolean show, TableColumn key){
		Render render = new Render();
		render.setTitle(column.getListTitle());
		render.setShow(show);
		render.setRender(JspSnippetHelper.getSnippet("list_snippet_operate", key.getColumnAlias()));
		return render;
	}
	
	/**
	 * 不显示的Render;
	 * @return
	 */
	public static Render createDisAllowShowRender(){
		Render render = new Render();
		render.setShow(false);
		return render;
	}
	
	/**
	 * 编辑Render入口;
	 * @param column
	 * @param sqlMapMarkUse
	 * @param show
	 * @return
	 */
	public static Render createEditRender(TableColumn column, boolean show){
		String keyName = keyName(column);
		RenderWayType rwt =  RenderWayType.parse(column.getEditRenderWay());
		Render render = new Render();
		render.setTitle(column.getColumnTitle());
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
	
	/**
	 * 创建查询显示render;
	 * @param queryColumns	查询列集合;
	 * @param showColumnCount 分几列显示;
	 * @param sqlMapMarkUse
	 * @param show
	 * @return
	 */
	public static Render createQueryFormRender(String entityName, List<QueryColumn> queryColumns, Integer showColumnCount, boolean show){
		Render render = new Render();
		render.setShow(show);
		if(!show) return render;
		
		//为空不显示查询form;
		if(queryColumns.isEmpty()){
			render.setShow(false);
			return render;
		}
		
		int size = queryColumns.size();
		
		Integer[] validColumnCount = new Integer[]{3, 4};
		boolean valid = false;
		for (Integer v : validColumnCount) {
			if(v.equals(showColumnCount)){
				valid = true;
				break;
			}
		}
		if(!valid){
			showColumnCount = Integer.valueOf("4");
		}
		int colWidth = (12 - showColumnCount.intValue() * 2) / showColumnCount.intValue();
		
		Map<Integer, List<String>> map = new LinkedHashMap<Integer, List<String>>();
		for (int i = 0; i < size; i++) {
			QueryColumn qc = queryColumns.get(i);
			int key = i / showColumnCount;
			List<String> l = map.get(key);
			if(l == null){
				l = new ArrayList<String>();
				map.put(key, l);
			}
			Render r = createQueryRender(qc, colWidth, qc.getRenderWayType());
			l.add(r.getRender());
			
			if(i == (size -1)){
				//添加查询按钮;
				l.add(JspSnippetHelper.getSnippet("query_button", entityName));
			}
		}
		
		//<%--单行高度87px, 增加一行增加高度45px --%>
		StringBuilder sb = new StringBuilder();
		int height = 42;
		for (List<String> l : map.values()) {
			sb.append(JspSnippetHelper.getSnippet("query_form", StringUtils.join(l, "")));
			height += 45;
		}
		render.setHeight(height);
		render.setRender(sb.toString());
		return render;
	}
	
}
