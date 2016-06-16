/**
 * 
 */
package me.paddingdun.gen.code;

/**
 * 
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
 */
public interface IConsant {

	/**
	 * java package name separate character;
	 */
	String PACKAGE_SEPARATE = ".";
	
	/**
	 * http path separate character;
	 */
	String URL_PATH_SEPARATE = "/";
	
	/**
	 * java接口实现类包名;
	 */
	String INTERFACE_IMPL_PACKAGE_NAME = "impl";
	
	
	/**
	 * 显示排序中默认的值;
	 */
	Integer DEF_MAX_SEQ = 999;
	
	/**
	 * 主键默认排序为最小
	 */
	Integer DEF_MIN_SEQ = 0;
	
	
	String IBATIS_VM = "ibatis/2.0";
	String MYBATIS_VM = "mybatis/3.0";
}
