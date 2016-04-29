/**
 * 
 */
package me.paddingdun.gen.code.data.table;

import java.io.Serializable;
import java.text.MessageFormat;

import com.google.gson.annotations.Expose;

/**
 * 
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 1.0
 * @deprecated
 */
public class QueryColumn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 关联字段名称;
	 */
//	@Expose
	private String relColumnName;
	
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
	
	/**
	 * 名称描述;
	 * 如果为null, 默认获取column的title;
	 */
	@Expose
	private String title;
	
	private int renderWayType;
	
	private String setMethod;
	private String getMethod;
	
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

	/**
	 * 是否是新的属性, 如果为true将会添加在实体bean中;
	 */
	private boolean newProperty = false;
	
	/**
	 * 是否是字符串属性;
	 */
	private boolean stringJavaType;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isNewProperty() {
		return newProperty;
	}

	public void setNewProperty(boolean newProperty) {
		this.newProperty = newProperty;
	}

	/**
	 * 与关联字段的逻辑操作;(如: {0} = {1} , {0} > {1})
	 */
	@Expose
	private String logic;
	
	public String getLogicDes(){
		String tmp = this.logic.replaceAll("'", "''");
		return MessageFormat.format(tmp, this.relColumnName, "#" + this.propertyName + "#");
	}
	
	
	public String getRelColumnName() {
		return relColumnName;
	}

	public void setRelColumnName(String relColumnName) {
		this.relColumnName = relColumnName;
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

	public String getLogic() {
		return logic;
	}

	public void setLogic(String logic) {
		this.logic = logic;
	}

	public int getRenderWayType() {
		return renderWayType;
	}

	public void setRenderWayType(int renderWayType) {
		this.renderWayType = renderWayType;
	}

	public boolean isStringJavaType() {
		return stringJavaType;
	}

	public void setStringJavaType(boolean stringJavaType) {
		this.stringJavaType = stringJavaType;
	}
	
}
