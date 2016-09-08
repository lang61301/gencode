/**
 * 
 */
package me.paddingdun.gen.code.gui.model;

import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import me.paddingdun.gen.code.data.table.IDBColumn;
import me.paddingdun.gen.code.data.tabletree.IDBTable;

/**
 * 
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 2.0
 * @version 2.0
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EditViewModel {

	/**
	 * 查询sql;
	 */
	private String querySql;
	
	/**
	 * 删除sql;
	 */
	private String deleteSql;
	
	/**
	 * 生成查询sqldbcolumn list;
	 */
	private List<IDBColumn> querySqlDBColumnList;
	
	/**
	 * 表格生成的dbtable;
	 */
	private IDBTable dbTable;
	
	/**
	 * 是否生成权限语句;
	 * add by 2016年9月8日
	 */
	private boolean showPermission;
	
	/**
	 * 查询权限常量;
	 * add by 2016年9月8日
	 */
	private String queryPermission;
	
	/**
	 * 编辑权限常量;
	 * add by 2016年9月8日
	 */
	private String editPermission;

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

	public List<IDBColumn> getQuerySqlDBColumnList() {
		return querySqlDBColumnList;
	}

	public void setQuerySqlDBColumnList(List<IDBColumn> querySqlDBColumnList) {
		this.querySqlDBColumnList = querySqlDBColumnList;
	}

	public IDBTable getDbTable() {
		return dbTable;
	}

	public void setDbTable(IDBTable dbTable) {
		this.dbTable = dbTable;
	}

	public boolean isShowPermission() {
		return showPermission;
	}

	public void setShowPermission(boolean showPermission) {
		this.showPermission = showPermission;
	}

	public String getQueryPermission() {
		return queryPermission;
	}

	public void setQueryPermission(String queryPermission) {
		this.queryPermission = queryPermission;
	}

	public String getEditPermission() {
		return editPermission;
	}

	public void setEditPermission(String editPermission) {
		this.editPermission = editPermission;
	}
}
