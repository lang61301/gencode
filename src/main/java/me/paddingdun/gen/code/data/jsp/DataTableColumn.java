/**
 * 
 */
package me.paddingdun.gen.code.data.jsp;

import me.paddingdun.gen.code.data.table.TableColumn;

/**
 * jsp页面上表格的包装字段;
 * @author paddingdun
 *
 * 2016年1月11日
 */
public class DataTableColumn extends TableColumn {

	/**
	 * @param columnName
	 * @param type
	 * @param columnCommon
	 */
	public DataTableColumn(String columnName, int type, String columnCommon) {
		super(columnName, type, columnCommon);
	}
	
	private Boolean show = true;
	
	private String showInList;
	
	private String showInEdit;
	

}
