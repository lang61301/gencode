/**
 * 
 */
package me.paddingdun.gen.code.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author paddingdun
 *
 * 2015年12月28日
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Value1 {

	/**
	 * 键值;
	 * @return
	 */
	public String value() default "";
	
	/**
	 * 默认值;
	 * @return
	 */
	public String def() default "";
}
