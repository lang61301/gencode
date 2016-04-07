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
import me.paddingdun.gen.code.data.table.JspColumn;
import me.paddingdun.gen.code.data.table.QueryColumn;
import me.paddingdun.gen.code.exception.BusinessException;
import me.paddingdun.gen.code.gui.view.dbtable.TableViewModel;

/**
 * 
 * @author paddingdun
 *
 * 2016年1月13日
 */
public class RenderHelper {
	
	public static String list(String keyName, String defaultContent, RenderWayType rwt, String customer, String groupCheckboxClassName){
		String dc = "";
		if(StringUtils.isNotBlank(defaultContent)){
			dc = defaultContent.trim();
		}
		String render = JspSnippetHelper.getSnippet("list_text", keyName, dc);
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
			render = JspSnippetHelper.getSnippet("list_customer", keyName, dc, cu);
			break;
		default:
			throw new BusinessException("list:do not have implement RenderWayType:" + rwt);
		}
		return render;
	}
	
	public static String edit(String keyName, String title, RenderWayType rwt){
		String render = JspSnippetHelper.getSnippet(RenderWayType.edit_input.name(), keyName, title);
		
		switch (rwt) {
		case edit_input:
			break;
		case edit_hidden:
			render = JspSnippetHelper.getSnippet(RenderWayType.edit_hidden.name(), keyName);
			break;
		case edit_checkbox:
			render = JspSnippetHelper.getSnippet(RenderWayType.edit_checkbox.name(), keyName, title);
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

	
	private static String keyName(JspColumn column, Integer sqlMapMarkUse){
		return Integer.valueOf("1").equals(sqlMapMarkUse) ? column.getPropertyName() : column.getColumnName();
	}
	
	private static String keyName(QueryColumn column, Integer sqlMapMarkUse){
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
	public static Render createListRender(TableViewModel model, JspColumn column, Integer sqlMapMarkUse, boolean show){
		String keyName = keyName(column, sqlMapMarkUse);
		RenderWayType rwt =  RenderWayType.parse(column.getListRenderWay());
		Render render = new Render();
		render.setTitle(column.getColumnTitle());
		render.setShow(show);
		if(RenderWayType.list_default == rwt){
			if(column.isPrimary()){
				rwt = RenderWayType.list_checkbox;
				render.setTitle(JspSnippetHelper.getSnippet("list_snippet_checkbox_title", model.getHeadGroupCheckboxClassName()));
			}else{
				rwt = RenderWayType.list_text;
			}
		}
		render.setRender(list(keyName, "", rwt, "", model.getGroupCheckboxClassName()));
		return render;
	}
	
	/**
	 * 2016-03-08
	 * 已经修改不使用JspColumn作为查询参数;
	 * 修改为QueryColumn作为查询参数;
	 * 
	 * 查询render入口;
	 * @param model
	 * @param column
	 * @param sqlMapMarkUse
	 * @param show
	 * @return
	 * @deprecated
	 */
	@SuppressWarnings("unused")
	private static Render createQueryRender(JspColumn column, Integer sqlMapMarkUse, int colWidth){
		String keyName = keyName(column, sqlMapMarkUse);
		RenderWayType rwt =  RenderWayType.parse(column.getQueryRenderWay());
		Render render = new Render();
		render.setTitle(column.getColumnTitle());
		render.setShow(true);
		if(RenderWayType.query_default == rwt){
			rwt = RenderWayType.query_input;
		}
		render.setRender(query(keyName, render.getTitle(), rwt, colWidth));
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
	private static Render createQueryRender(QueryColumn column, Integer sqlMapMarkUse, int colWidth, int queryRenderWay){
		String keyName = keyName(column, sqlMapMarkUse);
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
	public static Render createListOperateRender(JspColumn column, boolean show){
		Render render = new Render();
		render.setTitle(column.getColumnTitle());
		render.setShow(show);
		render.setRender(JspSnippetHelper.getSnippet("list_snippet_operate"));
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
	public static Render createEditRender(JspColumn column, Integer sqlMapMarkUse, boolean show){
		String keyName = keyName(column, sqlMapMarkUse);
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
	public static Render createQueryFormRender(List<QueryColumn> queryColumns, Integer showColumnCount, Integer sqlMapMarkUse, boolean show){
		Render render = new Render();
		render.setShow(show);
		if(!show) return render;
		
		//为空不显示查询form;
		if(queryColumns.isEmpty()){
			render.setShow(false);
			return render;
		}
		
		int size = queryColumns.size();
		
		Integer[] validColumnCount = new Integer[]{2, 3};
		boolean valid = false;
		for (Integer v : validColumnCount) {
			if(v.equals(showColumnCount)){
				valid = true;
				break;
			}
		}
		if(!valid){
			showColumnCount = Integer.valueOf("3");
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
			Render r = createQueryRender(qc, sqlMapMarkUse, colWidth, qc.getRenderWayType());
			l.add(r.getRender());
		}
		
		StringBuilder sb = new StringBuilder();
		for (List<String> l : map.values()) {
			sb.append(JspSnippetHelper.getSnippet("query_form", StringUtils.join(l, "")));
		}
		render.setRender(sb.toString());
		return render;
	}
	
}
