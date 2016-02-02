/**
 * 
 */
package me.paddingdun.gen.code.data.table;

import me.paddingdun.gen.code.data.jsp.Render;

/**
 * @author paddingdun
 *
 * 2016年1月13日
 */
public class JspColumn extends TableColumn {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param columnName
	 * @param type
	 * @param columnCommon
	 */
	public JspColumn(String columnName, int type, String columnCommon) {
		super(columnName, type, columnCommon);
	}
	
	/**jsp 使用************************************************************/
	/**
	 * query;
	 * 
	 * modify by:2016-02-02
	 * 由于布局问题, 查询代码需要一次生成, 所以将其提升到table的queryFormRender;
	 * 
	 */
//	private Render queryRender;
	/**
	 * list;
	 */
	private Render listRender;
	/**
	 * add or edit;
	 */
	private Render editRender;


//	public Render getQueryRender() {
//		return queryRender;
//	}
//	public void setQueryRender(Render queryRender) {
//		this.queryRender = queryRender;
//	}
	public Render getListRender() {
		return listRender;
	}
	public void setListRender(Render listRender) {
		this.listRender = listRender;
	}
	public Render getEditRender() {
		return editRender;
	}
	public void setEditRender(Render editRender) {
		this.editRender = editRender;
	}

}
