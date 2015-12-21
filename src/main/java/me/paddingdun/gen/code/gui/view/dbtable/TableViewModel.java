/**
 * 
 */
package me.paddingdun.gen.code.gui.view.dbtable;

import me.paddingdun.gen.code.data.tabletree.Table;

/**
 * @author paddingdun
 *
 * 2015年12月21日
 */
public class TableViewModel {
	
	/**
	 * 
	 */
	private Table table;
	
	/**
	 * ibatis中SqlMap的属性占位符;
	 * 1:属性名称;
	 * 2:字段名称;
	 */
	private Integer sqlMapMarkUse;
	
	/**
	 * 是否显示gosn注释;
	 * 1:显示;
	 * 0:不显示;
	 */
	private Integer showGsonAnnotation;

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public Integer getSqlMapMarkUse() {
		return sqlMapMarkUse;
	}

	public void setSqlMapMarkUse(Integer sqlMapMarkUse) {
		this.sqlMapMarkUse = sqlMapMarkUse;
	}

	public Integer getShowGsonAnnotation() {
		return showGsonAnnotation;
	}

	public void setShowGsonAnnotation(Integer showGsonAnnotation) {
		this.showGsonAnnotation = showGsonAnnotation;
	}
}
