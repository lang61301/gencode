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

	String getTableName();

	String getTableAlias();
	
	String getColumnAlias();

	String getColumnName();

	int getType();

	String getColumnCommon();

	boolean isAutoIncrement();

	boolean isPrimary();

	boolean isNullable();

	int getColumnSize();
}
