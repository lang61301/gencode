/**
 * 
 */
package me.paddingdun.gen.code.data.table2;

import java.util.List;

import me.paddingdun.gen.code.data.jsp.Render;
import me.paddingdun.gen.code.data.table.Sort;
import me.paddingdun.gen.code.data.tabletree.DBTable;

/**
 * 实体对象;
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 2.0
 * @version 2.0
 */
public class Entity extends DBTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 实体bean类名;
	 */
	private String entityBeanName;

	/**
	 * query form render;
	 */
	private Render queryFormRender;

	/**
	 * bootstrap.validate的js验证js片断;
	 */
	private String editJSValidtors;

	/**
	 * 实体属性集合;
	 */
	private List<IEntityProperty> entityProperties;
	
	/**
	 * 表字段集合;
	 */
	private List<TableColumn> tableColumns;
	
	/**
	 * 列表字段集合;
	 */
	private List<ListColumn> listColumns;
	
	/**
	 * 查询字段集合;
	 */
	private List<QueryColumn> queryColumns;
	
	/**
	 * 排序字段集合;
	 */
	private List<Sort> sorts;
	
	/**
	 * 是否含有自动增长且为主键的字段;
	 * @return
	 */
	public boolean isAutoPrimary() {
		if(tableColumns != null)
			for (TableColumn tc : tableColumns) {
				if(tc.isPrimary() && tc.isAutoIncrement()){
					return true;
				}
			}
		return false;
	}

	public String getEntityBeanName() {
		return entityBeanName;
	}

	public void setEntityBeanName(String entityBeanName) {
		this.entityBeanName = entityBeanName;
	}

	public Render getQueryFormRender() {
		return queryFormRender;
	}

	public void setQueryFormRender(Render queryFormRender) {
		this.queryFormRender = queryFormRender;
	}

	public String getEditJSValidtors() {
		return editJSValidtors;
	}

	public void setEditJSValidtors(String editJSValidtors) {
		this.editJSValidtors = editJSValidtors;
	}

	public List<IEntityProperty> getEntityProperties() {
		return entityProperties;
	}

	public void setEntityProperties(List<IEntityProperty> entityProperties) {
		this.entityProperties = entityProperties;
	}

	public List<TableColumn> getTableColumns() {
		return tableColumns;
	}

	public void setTableColumns(List<TableColumn> tableColumns) {
		this.tableColumns = tableColumns;
	}

	public List<ListColumn> getListColumns() {
		return listColumns;
	}

	public void setListColumns(List<ListColumn> listColumns) {
		this.listColumns = listColumns;
	}

	public List<QueryColumn> getQueryColumns() {
		return queryColumns;
	}

	public void setQueryColumns(List<QueryColumn> queryColumns) {
		this.queryColumns = queryColumns;
	}

	public List<Sort> getSorts() {
		return sorts;
	}

	public void setSorts(List<Sort> sorts) {
		this.sorts = sorts;
	}
}
