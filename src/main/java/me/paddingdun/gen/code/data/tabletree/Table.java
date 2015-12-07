/**
 * 
 */
package me.paddingdun.gen.code.data.tabletree;

import java.io.Serializable;

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
	
}
