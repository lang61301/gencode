/**
 * 
 */
package me.paddingdun.gen.code.data.table2;

import java.io.Serializable;
import java.util.List;

import me.paddingdun.gen.code.data.jsp.Render;
import me.paddingdun.gen.code.data.table.Sort;

/**
 * 实体对象;
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 2.0
 * @version 2.0
 */
public class Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * modify 2016-03-10
	 * 是否是自动生成主键;
	 */
	private boolean autoPrimary = false;
	
	public boolean isAutoPrimary() {
		for (TableColumn tc : columns) {
			if(tc.isPrimary() && tc.isAutoIncrement()){
				autoPrimary = true;
				break;
			}
		}
		return autoPrimary;
	}
	public void setAutoPrimary(boolean autoPrimary) {
		this.autoPrimary = autoPrimary;
	}
	
	private String entityBeanName;

	/**
	 * query form render;
	 */
	private Render queryFormRender;

	/**
	 * add by 2016年3月21日
	 * bootstrap.validate的js验证js片断;
	 */
	private String editJSValidtors;

	/**
	 * add by 2016年4月6日
	 * 排序字段集合;
	 */
	private List<Sort> sorts;
	
	
	/**
	 * 实体属性集合;
	 */
	private List<IEntityProperty> entityProperties = null;
	
	/**
	 * 表字段集合;
	 */
	private List<TableColumn> tableColumns = null;
	
	/**
	 * 列表字段集合;
	 */
	private List<ListColumn> listColumns = null;
	
	/**
	 * 查询字段集合;
	 */
	private List<QueryColumn> queryColumns = null;
	

}
