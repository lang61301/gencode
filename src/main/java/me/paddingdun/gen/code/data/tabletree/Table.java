/**
 * 
 */
package me.paddingdun.gen.code.data.tabletree;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import me.paddingdun.gen.code.data.jsp.Render;
import me.paddingdun.gen.code.data.table.JspColumn;
import me.paddingdun.gen.code.data.table.QueryColumn;
import me.paddingdun.gen.code.data.table.Sort;
import me.paddingdun.gen.code.data.table.TableColumn;

/**
 * 表;
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 1.0
 * @deprecated
 */
public class Table extends DBTable implements Serializable{

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
	
	/**
	 * @param cat
	 * @param tableName
	 * @param tableType
	 */
	public Table(String cat, String tableName, String tableType) {
		super(cat, tableName, tableType);
	}
	
	public Table(DBTable dbTable){
		this(dbTable.getCat(), dbTable.getTableName(), dbTable.getTableType());
		try {
			BeanUtils.copyProperties(this, dbTable);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return this.getTableId();
	}
	
	private List<TableColumn> columns;

	public List<TableColumn> getColumns() {
		return columns;
	}
	public void setColumns(List<TableColumn> columns) {
		this.columns = columns;
	}
	
	private String entityBeanName;

	public String getEntityBeanName() {
		return entityBeanName;
	}
	public void setEntityBeanName(String entityBeanName) {
		this.entityBeanName = entityBeanName;
	}
	
	/**
	 * 单独弄出一个jspcolumns因为它的列有可能比column多;
	 */
	private List<JspColumn> jspColumns;

	public List<JspColumn> getJspColumns() {
		return jspColumns;
	}
	public void setJspColumns(List<JspColumn> jspColumns) {
		this.jspColumns = jspColumns;
	}
	
	/**
	 * query form render;
	 */
	private Render queryFormRender;

	public Render getQueryFormRender() {
		return queryFormRender;
	}
	public void setQueryFormRender(Render queryFormRender) {
		this.queryFormRender = queryFormRender;
	}
	
	/**
	 * 查询列;
	 */
	private List<QueryColumn> queryColumns;

	public List<QueryColumn> getQueryColumns() {
		return queryColumns;
	}
	public void setQueryColumns(List<QueryColumn> queryColumns) {
		this.queryColumns = queryColumns;
	}
	
	/**
	 * add by 2016年3月21日
	 * bootstrap.validate的js验证js片断;
	 */
	private String editJSValidtors;

	public String getEditJSValidtors() {
		return editJSValidtors;
	}
	public void setEditJSValidtors(String editJSValidtors) {
		this.editJSValidtors = editJSValidtors;
	}
	
	/**
	 * add by 2016年4月6日
	 * 排序字段集合;
	 */
	private List<Sort> sorts;
	
	
	public List<Sort> getSorts() {
		return sorts;
	}

	public void setSorts(List<Sort> sorts) {
		this.sorts = sorts;
	}
}
