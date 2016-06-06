/**
 * 
 */
package me.paddingdun.gen.code.data.table2;

import me.paddingdun.gen.code.data.table.IDBColumn;

/**
 * @author paddingdun
 *
 * 2016年5月13日
 * @since 2.0
 * @version 2.0
 */
public class WapperDBColumn implements IDBColumn {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IDBColumn dbColumn;
	
	/**
	 * 
	 */
	public WapperDBColumn(IDBColumn dbColumn) {
		this.dbColumn = dbColumn;
	}

	public void setTableName(String tableName) {
		dbColumn.setTableName(tableName);
	}

	public String getTableName() {
		return dbColumn.getTableName();
	}

	public void setTableAlias(String tableAlias) {
		dbColumn.setTableAlias(tableAlias);
	}

	public String getTableAlias() {
		return dbColumn.getTableAlias();
	}

	public void setColumnAlias(String columnAlias) {
		dbColumn.setColumnAlias(columnAlias);
	}

	public String getColumnAlias() {
		return dbColumn.getColumnAlias();
	}

	public void setColumnName(String columnName) {
		dbColumn.setColumnName(columnName);
	}

	public String getColumnName() {
		return dbColumn.getColumnName();
	}

	public void setType(int type) {
		dbColumn.setType(type);
	}

	public int getType() {
		return dbColumn.getType();
	}

	public void setColumnCommon(String columnCommon) {
		dbColumn.setColumnCommon(columnCommon);
	}

	public String getColumnCommon() {
		return dbColumn.getColumnCommon();
	}

	public void setAutoIncrement(boolean autoIncrement) {
		dbColumn.setAutoIncrement(autoIncrement);
	}

	public boolean isAutoIncrement() {
		return dbColumn.isAutoIncrement();
	}

	public void setPrimary(boolean primary) {
		dbColumn.setPrimary(primary);
	}

	public boolean isPrimary() {
		return dbColumn.isPrimary();
	}

	public void setNullable(boolean nullable) {
		dbColumn.setNullable(nullable);
	}

	public boolean isNullable() {
		return dbColumn.isNullable();
	}

	public void setColumnSize(int columnSize) {
		dbColumn.setColumnSize(columnSize);
	}

	public int getColumnSize() {
		return dbColumn.getColumnSize();
	}

	public IDBColumn getDbColumn() {
		return dbColumn;
	}

	public void setDbColumn(IDBColumn dbColumn) {
		this.dbColumn = dbColumn;
	}
}
