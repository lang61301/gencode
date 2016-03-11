/**
 * 
 */
package me.paddingdun.gen.code.data.edit;

/**
 * @author paddingdun
 *
 * 2016年3月10日
 */
public enum EditValueGenWayType {

	nothing, //不做任何操作;
	input,	 //用户输入;
	time,	 //获取当前时间;
	date,	 //获取当前日期;
	custom	 //自定义; 当为该属性时,获取"newCustom"或者"editCustom"的值;
}
