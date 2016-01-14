/**
 * 
 */
package me.paddingdun.gen.code.data.tabletree;

import java.io.Serializable;
import java.util.List;

import me.paddingdun.gen.code.data.table.JspColumn;
import me.paddingdun.gen.code.data.table.TableColumn;

/**
 * @author paddingdun
 *
 * 2015年12月3日
 */
public class Table implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cat;
	private String tableName;
	private String tableType;
	private String tableCommon;
	
	/**
	 * @param cat
	 * @param tableName
	 * @param tableType
	 */
	public Table(String cat, String tableName, String tableType) {
		super();
		this.cat = cat;
		this.tableName = tableName;
		this.tableType = tableType;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getTableType() {
		return tableType;
	}
	public void setTableType(String tableType) {
		this.tableType = tableType;
	}
	
	public String getTableCommon() {
		return tableCommon;
	}
	public void setTableCommon(String tableCommon) {
		this.tableCommon = tableCommon;
	}
	@Override
	public String toString() {
		return tableName;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
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
}
