/**
 * 
 */
package me.paddingdun.gen.code.data.table;

import java.io.Serializable;

/**
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 2.0
 * @version 2.0
 */
public interface IDBColumn extends Serializable{

	/**
	 * table name;
	 * @param tableName
	 */
	void setTableName(String tableName);
	String getTableName();

	/**
	 * table alias;
	 * @param tableAlias
	 */
	void setTableAlias(String tableAlias);
	String getTableAlias();
	
	/**
	 * column alias;
	 * @param columnAlias
	 */
	void setColumnAlias(String columnAlias);
	String getColumnAlias();

	/**
	 * column name;
	 * @param columnName
	 */
	void setColumnName(String columnName);
	String getColumnName();

	/**
	 * column java sql type;
	 * @param type
	 */
	void setType(int type);
	int getType();

	/**
	 * column comment;
	 * @param columnCommon
	 */
	void setColumnCommon(String columnCommon);
	String getColumnCommon();

	/**
	 * whether the column is auto increment;
	 * @param autoIncrement
	 */
	void setAutoIncrement(boolean autoIncrement);
	boolean isAutoIncrement();

	/**
	 * whether the column is primary key;
	 * @param primary
	 */
	void setPrimary(boolean primary);
	boolean isPrimary();

	/**
	 * whether the column is nullable;
	 * @param nullable
	 */
	void setNullable(boolean nullable);
	boolean isNullable();

	/**
	 * column size;
	 * @param columnSize
	 */
	void setColumnSize(int columnSize);
	int getColumnSize();
}
