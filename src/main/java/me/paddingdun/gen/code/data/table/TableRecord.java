/**
 * 
 */
package me.paddingdun.gen.code.data.table;

import java.io.Serializable;

/**
 * @author paddingdun
 *
 * 2015年12月3日
 */
public class TableRecord implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String columnName;
	private int type;
	private String columnCommon;
	
	
	/**
	 * @param columnName
	 * @param type
	 * @param columnCommon
	 */
	public TableRecord(String columnName, int type, String columnCommon) {
		super();
		this.columnName = columnName;
		this.type = type;
		this.columnCommon = columnCommon;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getColumnCommon() {
		return columnCommon;
	}
	public void setColumnCommon(String columnCommon) {
		this.columnCommon = columnCommon;
	}

}
