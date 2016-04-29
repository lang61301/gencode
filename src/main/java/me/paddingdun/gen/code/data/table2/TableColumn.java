/**
 * 
 */
package me.paddingdun.gen.code.data.table2;

import me.paddingdun.gen.code.data.jsp.RenderWayType;

/**
 * 表字段;
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 2.0
 * @version 2.0
 */
public class TableColumn extends EntityProperty {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 编辑中是否显示;
	 */
	private boolean editRenderShow = true;
	
	/**
	 * 编辑中显示方式;
	 * 用来定义编辑列显示方式;
	 */
	private int editRenderWay  = RenderWayType.edit_default.getType();
	
	/**
	 * 填值方式;
	 * 新增和编辑时,该字段值的生成方式;
	 */
	private String editValueGenWayJson;
	
	/**
	 * JS验证;
	 * add by 2016年3月17日
	 * 新增和编辑时, 验证规则json;
	 * jquery.bootstrap.validate
	 */
	private String editValidateJson;
	
	
	
//	/**
//	 * 判断该字段是否可以存在updatesql中的set语句中;
//	 * @return
//	 */
//	public boolean isNotInSetUpdateSql(){
//		return EditValueGenWayHelper.isNotInSetUpdateSql(this);
//	}
}
