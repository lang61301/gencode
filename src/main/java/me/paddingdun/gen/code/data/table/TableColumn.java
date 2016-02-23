/**
 * 
 */
package me.paddingdun.gen.code.data.table;

import java.io.Serializable;

import me.paddingdun.gen.code.data.jsp.RenderWayType;

/**
 * @author paddingdun
 *
 * 2015年12月3日
 */
public class TableColumn implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String columnName;
	private int type;
	private String columnCommon;
	private boolean autoIncrement;
	private boolean primary;
	
	
	/**
	 * @param columnName
	 * @param type
	 * @param columnCommon
	 */
	public TableColumn(String columnName, int type, String columnCommon) {
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



	private String javaType;
	private String propertyName;
	private String getMethod;
	private String setMethod;


	public String getJavaType() {
		return javaType;
	}
	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getGetMethod() {
		return getMethod;
	}
	public void setGetMethod(String getMethod) {
		this.getMethod = getMethod;
	}
	public String getSetMethod() {
		return setMethod;
	}
	public void setSetMethod(String setMethod) {
		this.setMethod = setMethod;
	}
	
	private boolean gson = true;


	public boolean isGson() {
		return gson;
	}
	public void setGson(boolean gson) {
		this.gson = gson;
	}
	
	
	/***jsp使用********************************************************************************/
	/**
	 * 是否显示;
	 */
	private boolean queryRenderShow = false;
	/**
	 * 是否显示;
	 */
	private boolean listRenderShow = true;
	/**
	 * 是否显示;
	 */
	private boolean editRenderShow = true;
	
	/**
	 * 用来定义查询显示方式;
	 */
	private int queryRenderWay = RenderWayType.query_default.getType();
	/**
	 * 用来定义列表显示方式;
	 */
	private int listRenderWay  = RenderWayType.list_default.getType();
	/**
	 * 用来定义编辑列显示方式;
	 */
	private int editRenderWay  = RenderWayType.edit_default.getType();
	
	/**
	 * 列标题;
	 */
	private String columnTitle;
	
	public boolean isQueryRenderShow() {
		return queryRenderShow;
	}
	public void setQueryRenderShow(boolean queryRenderShow) {
		this.queryRenderShow = queryRenderShow;
	}
	public boolean isListRenderShow() {
		return listRenderShow;
	}
	public void setListRenderShow(boolean listRenderShow) {
		this.listRenderShow = listRenderShow;
	}
	public boolean isEditRenderShow() {
		return editRenderShow;
	}
	public void setEditRenderShow(boolean editRenderShow) {
		this.editRenderShow = editRenderShow;
	}
	public int getQueryRenderWay() {
		return queryRenderWay;
	}
	public void setQueryRenderWay(int queryRenderWay) {
		this.queryRenderWay = queryRenderWay;
	}
	public int getListRenderWay() {
		return listRenderWay;
	}
	public void setListRenderWay(int listRenderWay) {
		this.listRenderWay = listRenderWay;
	}
	public int getEditRenderWay() {
		return editRenderWay;
	}
	public void setEditRenderWay(int editRenderWay) {
		this.editRenderWay = editRenderWay;
	}
	public String getColumnTitle() {
		if(columnTitle == null){
			columnTitle = columnCommon;
		}
		return columnTitle;
	}
	public void setColumnTitle(String columnTitle) {
		this.columnTitle = columnTitle;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TableColumn other = (TableColumn) obj;
		if (columnName == null) {
			if (other.columnName != null)
				return false;
		} else if (!columnName.equals(other.columnName))
			return false;
		return true;
	}
	
	
	
}
