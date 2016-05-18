/**
 * 
 */
package me.paddingdun.gen.code.data.tabletree;

import java.io.Serializable;

/**
 * @author paddingdun
 *
 * 2016年5月12日
 * @since 2.0
 * @version 2.0
 */
public interface IDBTable extends Serializable {

	void setCat(String catalog);
	/**
	 * database name;
	 * @return
	 */
	String getCat();
	

	void setTableName(String tableName);
	/**
	 * table/view name;
	 * @return
	 */
	String getTableName();

	void setTableType(String tableType);
	/**
	 * table type : "TABLE":"VIEW";
	 * @return
	 */
	public String getTableType();

	void setTableCommon(String common);
	/**
	 * table comment;
	 * @return
	 */
	public String getTableCommon();
}
