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

	/**
	 * java class property type string;
	 * @return
	 */
	String getJavaType();


	/**
	 * java class property name;
	 * @return
	 */
	String getPropertyName();


	/**
	 * java class getMethod string;
	 * @return
	 */
	String getGetMethod();


	/**
	 * java class setMethod string;
	 * @return
	 */
	String getSetMethod();

}
