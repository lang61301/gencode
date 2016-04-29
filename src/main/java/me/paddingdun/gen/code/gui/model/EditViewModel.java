/**
 * 
 */
package me.paddingdun.gen.code.gui.model;

/**
 * 
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 2.0
 * @version 2.0
 */
public class EditViewModel {

	/**
	 * 查询sql;
	 */
	private String querySql;
	
	/**
	 * 删除sql;
	 */
	private String deleteSql;

	public String getQuerySql() {
		return querySql;
	}

	public void setQuerySql(String querySql) {
		this.querySql = querySql;
	}

	public String getDeleteSql() {
		return deleteSql;
	}

	public void setDeleteSql(String deleteSql) {
		this.deleteSql = deleteSql;
	}
}
