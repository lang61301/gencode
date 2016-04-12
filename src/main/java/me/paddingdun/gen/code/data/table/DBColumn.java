/**
 * 
 */
package me.paddingdun.gen.code.data.table;

import java.io.Serializable;

/**
 * @author paddingdun
 * 数据库字段;
 * 2016年3月10日
 */
public class DBColumn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 字段名称;
	 */
	private String columnName;
	/**
	 * 数据库字段对应的java.sql.
	 */
	private int type;
	/**
	 * 字段注释;
	 */
	private String columnCommon;
	
	/**
	 * 是否自增长;
	 */
	private boolean autoIncrement;
	/**
	 * 是否是主键;
	 */
	private boolean primary;
	
	/**
	 * add by 2016年3月17日
	 * 是否可以为空;
	 */
	private boolean nullable = true;
	
	/**
	 * add by 2016年3月17日
	 * 字段长度;
	 */
	private int columnSize;
	
	/**
	 * 字段别名;
	 */
	private String columnAlias;
	
	public String getColumnAlias() {
		if(columnAlias == null)
			columnAlias = this.getColumnName();
		return columnAlias;
	}
	public void setColumnAlias(String columnAlias) {
		this.columnAlias = columnAlias;
	}
	
	/**
	 * @param columnName
	 * @param type
	 * @param columnCommon
	 */
	public DBColumn(String columnName, int type, String columnCommon) {
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
	public boolean isAutoIncrement() {
		return autoIncrement;
	}
	public void setAutoIncrement(boolean autoIncrement) {
		this.autoIncrement = autoIncrement;
	}
	public boolean isPrimary() {
		return primary;
	}
	public void setPrimary(boolean primary) {
		this.primary = primary;
	}

	public boolean isNullable() {
		return nullable;
	}
	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}

	public int getColumnSize() {
		return columnSize;
	}

	public void setColumnSize(int columnSize) {
		this.columnSize = columnSize;
	}
	
}
