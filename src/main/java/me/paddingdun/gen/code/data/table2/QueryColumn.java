/**
 * 
 */
package me.paddingdun.gen.code.data.table2;

import java.text.MessageFormat;

import com.google.gson.annotations.Expose;

import me.paddingdun.gen.code.util.VelocityHelper;

/**
 * 查询字段;
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 2.0
 * @version 2.0
 */
public class QueryColumn implements IEntityProperty {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	/**
//	 * 表别名;
//	 */
//	private String tableAlias;
//
//	/**
//	 * 关联字段名称;
//	 */
//	private String relColumnName;
	
	/**
	 * 作为实体bean中的属性名称;
	 */
	@Expose
	private String propertyName;
	
	/**
	 * 作为实体bean中的属性java类型(完全类型);
	 */
	@Expose
	private String javaType;
	
	private String setMethod;
	
	private String getMethod;
	
	/**
	 * 名称描述;
	 * 如果为null, 默认获取column的title;
	 */
	@Expose
	private String title;
	
	/**
	 * 查询参数html控件的表现方式;
	 */
	private int renderWayType;
	
	/**
	 * 是否是新的属性, 如果为true将会添加在实体bean中;
	 */
	private boolean newProperty = false;
	
	/**
	 * 是否是字符串属性;
	 */
	private boolean stringJavaType;
	
	/**
	 * 与关联字段的逻辑操作;(如: {0} = {1} , {0} > {1})
	 */
	@Expose
	private String logic;
	
	private String propertyTitle;
	
	public String getLogicDes(){
		String tmp = this.logic.replaceAll("'", "''");
		return MessageFormat.format(tmp, VelocityHelper.queryParamMark(propertyName));
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public String getSetMethod() {
		return setMethod;
	}

	public void setSetMethod(String setMethod) {
		this.setMethod = setMethod;
	}

	public String getGetMethod() {
		return getMethod;
	}

	public void setGetMethod(String getMethod) {
		this.getMethod = getMethod;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRenderWayType() {
		return renderWayType;
	}

	public void setRenderWayType(int renderWayType) {
		this.renderWayType = renderWayType;
	}

	public boolean isNewProperty() {
		return newProperty;
	}

	public void setNewProperty(boolean newProperty) {
		this.newProperty = newProperty;
	}

	public boolean isStringJavaType() {
		return stringJavaType;
	}

	public void setStringJavaType(boolean stringJavaType) {
		this.stringJavaType = stringJavaType;
	}

	public String getLogic() {
		return logic;
	}

	public void setLogic(String logic) {
		this.logic = logic;
	}

//	public String getTableAlias() {
//		return tableAlias;
//	}
//
//	public void setTableAlias(String tableAlias) {
//		this.tableAlias = tableAlias;
//	}
//
//	public String getRelColumnName() {
//		return relColumnName;
//	}
//
//	public void setRelColumnName(String relColumnName) {
//		this.relColumnName = relColumnName;
//	}

	public String getPropertyTitle() {
		return propertyTitle;
	}

	public void setPropertyTitle(String propertyTitle) {
		this.propertyTitle = propertyTitle;
	}
}
