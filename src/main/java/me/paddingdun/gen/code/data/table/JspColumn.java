/**
 * 
 */
package me.paddingdun.gen.code.data.table;

import me.paddingdun.gen.code.data.jsp.Render;
import me.paddingdun.gen.code.util.EditValueGenWayHelper;

/**
 * 
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 1.0
 * @deprecated
 */
public class JspColumn extends TableColumn {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	public String getEditValueJavaCode(){
		return EditValueGenWayHelper.javaCodeEdit(this);
	}
	
	public String getNewValueJavaCode(){
		return EditValueGenWayHelper.javaCodeNew(this);
	}

}
