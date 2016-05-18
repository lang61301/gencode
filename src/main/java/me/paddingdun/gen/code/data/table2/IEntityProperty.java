/**
 * 
 */
package me.paddingdun.gen.code.data.table2;

import java.io.Serializable;

/**
 * 实体属性接口;
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 2.0
 * @version 2.0
 */
public interface IEntityProperty extends Serializable {

	void setJavaType(String javaType);
	/**
	 * java class property type string;
	 * @return
	 */
	String getJavaType();


	void setPropertyName(String propertyName);
	/**
	 * java class property name;
	 * @return
	 */
	String getPropertyName();


	void setGetMethod(String getMethod);
	/**
	 * java class getMethod string;
	 * @return
	 */
	String getGetMethod();


	void setSetMethod(String setMethod);
	/**
	 * java class setMethod string;
	 * @return
	 */
	String getSetMethod();
	
	void setPropertyTitle(String propertyTitle);
	/**
	 * java class field comment;
	 * @return
	 */
	String getPropertyTitle();

}
