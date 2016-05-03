/**
 * 
 */
package me.paddingdun.gen.code.data.table2;

import me.paddingdun.gen.code.data.table.IDBColumn;

/**
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 2.0
 * @version 2.0
 */
public class BaseTableColumn extends EntityProperty implements IDBColumn {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 表名称;
	 */
	private String tableName;

	/**
	 * 表别名;
	 */
	private String tableAlias;

	/**
	 * 字段名称;
	 */
	private String columnName;

	/**
	 * 字段别名; 如果为空:取字段名称;
	 */
	private String columnAlias;

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
	 * 是否可以为空;
	 */
	private boolean nullable = true;

	/**
	 * 字段长度;
	 */
	private int columnSize;

	public String getColumnAlias() {
		if (columnAlias == null)
			columnAlias = this.columnName;
		return columnAlias;
	}

	public void setColumnAlias(String columnAlias) {
		this.columnAlias = columnAlias;
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

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableAlias() {
		return tableAlias;
	}

	public void setTableAlias(String tableAlias) {
		this.tableAlias = tableAlias;
	}
}
