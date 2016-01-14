/**
 * 
 */
package me.paddingdun.gen.code.data.option;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author paddingdun
 *
 * 2015年12月22日
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ModelValue {
	
	/**
	 * 表示同一类型的modelvalue;
	 * 常用于分类;
	 * @return
	 */
	public ModelValueCategory category() default ModelValueCategory.Default;
	
	/**
	 * 默认获取值的方法名称;
	 * @return
	 */
	public String valueGetFuncName() default "getValue";
	
	/**
	 * 默认设置值的方法名称;
	 * @return
	 */
	public String valueSetFuncName() default "setValue";
	
}
